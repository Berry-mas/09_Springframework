package com.ohgiraffers.entity.section05.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleMemberServiceTest {

    @Autowired
    private SimpleMemberService simpleMemberService;

    private static Stream<Arguments> productAndMember() {
        return Stream.of(
                Arguments.of(
                       1L, "상품1", "category1",
                        2L, "user02", "신사임당", "shinsa@example.com",
                        2L, "상품2", "category1",
                        3L, "user03", "강감찬", "kang@example.com",
                        "user01", "pass01", "홍길동", "seller@example.com"
                )
        );
    }

    @DisplayName("Product 엔티티 저장 테스트")
    @ParameterizedTest
    @MethodSource("productAndMember")
    void registProduct(
            Long productNo1, String productName1, String productCategory1,
            Long sellerNo1, String sellerId1, String sellerName1, String sellerEmail1,
            Long productNo2, String productName2, String productCategory2,
            Long sellerNo2, String sellerId2, String sellerName2, String sellerEmail2,
            String memberId, String memberPwd, String memberName, String memberEmail
    ){
        // given
        ProductDTO product = ProductDTO.builder().productNo(productNo1).productName(productName1).categoryName(productCategory1)
                .seller(SampleMemberDTO.builder().memberNo(sellerNo1).memberId(sellerId1).memberName(sellerName1).memberEmail(sellerEmail1).build()).build();
        ProductDTO product2 = ProductDTO.builder().productNo(productNo2).productName(productName2).categoryName(productCategory2)
                .seller(SampleMemberDTO.builder().memberNo(sellerNo2).memberId(sellerId2).memberName(sellerName2).memberEmail(sellerEmail2).build()).build();
        SampleMemberDTO seller = SampleMemberDTO.builder()
                .memberId(memberId)
                .memberPwd(memberPwd)
                .memberName(memberName)
                .memberEmail(memberEmail)
                .favorites(Set.of(product, product2))
                .build();

        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> simpleMemberService.testInsert(seller)
        );

    }

    private static Stream<Arguments> modifyProduct() {
        return Stream.of(
                Arguments.of(
                        1L, "상품1", "category1",
                        2L, "user02", "신사임당", "shinsa@example.com",
                        2L, "상품2", "category1",
                        3L, "user03", "강감찬", "kang@example.com",
                        "user01", "pass01", "홍길동", "seller@example.com",
                        1L, "Updated Product Name", "Updated Category"
                )
        );
    }

    @DisplayName("Product 엔터티 수정 테스트")
    @ParameterizedTest
    @MethodSource("modifyProduct")
    void modifyProduct(
            Long productNo1, String productName1, String productCategory1,
            Long sellerNo1, String sellerId1, String sellerName1, String sellerEmail1,
            Long productNo2, String productName2, String productCategory2,
            Long sellerNo2, String sellerId2, String sellerName2, String sellerEmail2,
            String memberId, String memberPwd, String memberName, String memberEmail,
            Long modifyNo, String modifyName, String modifyCategoryName
    ){
        // given
        /* Product 등록 */
        ProductDTO product = ProductDTO.builder().productNo(productNo1).productName(productName1).categoryName(productCategory1)
                .seller(SampleMemberDTO.builder().memberNo(sellerNo1).memberId(sellerId1).memberName(sellerName1).memberEmail(sellerEmail1).build()).build();
        ProductDTO product2 = ProductDTO.builder().productNo(productNo2).productName(productName2).categoryName(productCategory2)
                .seller(SampleMemberDTO.builder().memberNo(sellerNo2).memberId(sellerId2).memberName(sellerName2).memberEmail(sellerEmail2).build()).build();
        SampleMemberDTO seller = SampleMemberDTO.builder()
                .memberId(memberId)
                .memberPwd(memberPwd)
                .memberName(memberName)
                .memberEmail(memberEmail)
                .favorites(Set.of(product, product2))
                .build();
        Assertions.assertDoesNotThrow(
                () -> simpleMemberService.testInsert(seller)
        );

        /* Product 수정 */
        ProductDTO modifyProduct = ProductDTO.builder()
                .productNo(modifyNo)
                .productName(modifyName)
                .categoryName(modifyCategoryName).build();
        // when
        // then
        simpleMemberService.testUpdate(modifyProduct);

        Product foundProduct = simpleMemberService.selectByProductNo(modifyNo);
        Assertions.assertEquals(modifyName, foundProduct.getProductName());
        Assertions.assertEquals(modifyCategoryName, foundProduct.getCategoryName());

    }

}