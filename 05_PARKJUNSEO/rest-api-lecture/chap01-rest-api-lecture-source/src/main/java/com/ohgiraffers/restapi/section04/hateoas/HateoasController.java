package com.ohgiraffers.restapi.section04.hateoas;

import com.ohgiraffers.restapi.section02.responseentity.ResponseMessage;
import com.ohgiraffers.restapi.section03.valid.UserDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping
public class HateoasController {

    private List<UserDTO> users;

    public HateoasController() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "홍창기"));
        users.add(new UserDTO(2, "user02", "pass02", "문성주"));
        users.add(new UserDTO(3, "user03", "pass03", "오스틴"));
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseMessage>> findAllUsers() {
        /* Hateoas 설정 */
        List<EntityModel<UserDTO>> userWithRel = users.stream().map(
                user ->
                        EntityModel.of(
                                user,
                                linkTo(methodOn(HateoasController.class).findUserByNo(user.getNo())).withSelfRel(),
                                linkTo(methodOn(HateoasController.class).findUsers()).withRel("users")
                        )
        ).toList();

        /* 응답 바디 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", userWithRel);

        /* 응답 메시지 설정 */
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);
        return ResponseEntity.ok().body(responseMessage);
    }


    @GetMapping("/users/{userNo}")
    private ResponseEntity<ResponseMessage> findUserByNo(@PathVariable("userNo") int userNo) {

        /* 응답 헤더 설정 : JSON 응답이 default이지만 변경이 필요한 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        /* 응답 바디 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        /* 응답 메시지 설정 */
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", responseMap
        );

        // return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
        return ResponseEntity
                .ok()
                .header(httpHeaders)
                .body(responseMessage);
    }

}
