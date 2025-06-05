package com.ohgiraffers.entity.section03.element.collection.sub03.map.setting1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.stream.Stream;

@SpringBootTest
class UserSettingServiceTest {

    @Autowired
    private UserSettingService userSettingService;

    private static Stream<Arguments> userSettings() {
        return Stream.of(
                Arguments.of(
                        123L,
                        Map.of("Notification", "NO", "Display", "LIGHT")
                )
        );
    }

    @DisplayName("UserSetting Entity 등록")
    @ParameterizedTest
    @MethodSource("userSettings")
    void registUserSetting(Long userId, Map<String, String> props){
        // given
        UserSettingDTO userSettingDTO = UserSettingDTO.builder()
                                                    .userId(userId).props(props).build();

        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> userSettingService.registUserSetting(userSettingDTO)
        );
    }
}