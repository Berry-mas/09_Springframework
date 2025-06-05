package com.ohgiraffers.entity.section02.embeddable.subsection01.single.table;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Year;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    private static Stream<Arguments> getRestaurant() {
        return Stream.of(
                Arguments.of(
                        "abc-1234",
                        "ABC 파스타",
                        2003,
                        "서울시 강남구",
                        "삼성동 1234",
                        "0123",
                        "FIVE_STAR"
                )
        );
    }

    @DisplayName("Restaurant 엔티티 등록")
    @ParameterizedTest
    @MethodSource("getRestaurant")
    void restaurantInsert(
            String id, String name,int since, String address1, String address2, String zipCode, String grade
    ){
        // given
        Address address = new Address(address1, address2, zipCode);
        RestaurantDTO newRestaurant = RestaurantDTO.builder()
                .id(id)
                .name(name)
                .since(Year.of(since))
                .address(address)
                .grade(Grade.from(grade)).build();

        System.out.println("restaurant = " + newRestaurant);
        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> restaurantService.insertRestaurant(newRestaurant)
        );
    }
}