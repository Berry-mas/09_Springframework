package com.ohgiraffers.restapi.section05.swagger;

import com.ohgiraffers.restapi.section02.responseentity.ResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Spring Boot Swagger 연동 (user)")
@RestController
@RequestMapping("/swagger")
public class SwaggerTestController {

    // DB에 갔다왔다고 가정
    private List<UserDTO> users;

    public SwaggerTestController() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "홍창기"));
        users.add(new UserDTO(2, "user02", "pass02", "문성주"));
        users.add(new UserDTO(3, "user03", "pass03", "오스틴"));
    }

    @Operation(
            summary = "전체 회원 조회", description = "전체 회원 목록을 조회한다."
    )
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {
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

        // ResponseEntity : body, head, StatusCode 값을 넘길 수 있음
        return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
    }

    @Operation(
            summary = "회원 번호로 회원 조회"
    )
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        /* 응답 바디 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        responseMap.put("user", foundUser);

        /* 응답 메시지 설정 */
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", responseMap
        );
        return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseMessage> registUser(@RequestBody UserDTO userDTO) {

        int lastUserNo = users.get(users.size() - 1).getNo();
        userDTO.setNo(lastUserNo + 1);
        users.add(userDTO);

        // url 잠시 생성 (서버를 끄지 않는 이상 가능)
        return ResponseEntity
                .created(URI.create("/entity/users/" + users.get(users.size() - 1).getNo()))
                .build();
    }

    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyUser(@PathVariable int userNo, @RequestBody UserDTO userDTO) {
        // SELECT절 홍내낸 코드
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();

        foundUser.setPwd(userDTO.getPwd());
        foundUser.setName(userDTO.getName());

        return ResponseEntity.created(URI.create("/entity/users/" + userNo)).build();
    }

    @Operation(
            summary = "회원 번호로 회원 삭제"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "회원 정보 삭제 완료"),
            @ApiResponse(responseCode = "400", description = "잘못 입력된 파라미터")
    })
    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userNo) {
        // SELECT절 홍내낸 코드
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();

        users.remove(foundUser);
        return ResponseEntity.noContent().build();
    }


}
