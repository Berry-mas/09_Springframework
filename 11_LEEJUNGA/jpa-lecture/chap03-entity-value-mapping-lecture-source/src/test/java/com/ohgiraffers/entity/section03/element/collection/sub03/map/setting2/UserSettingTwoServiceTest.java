package com.ohgiraffers.entity.section03.element.collection.sub03.map.setting2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserSettingTwoServiceTest {

    @Autowired
    private UserSettingTwoService userSettingTwoService;

    private static Stream<Arguments> userSetting() {
        return Stream.of(
                Arguments.of(
                      123L,
                        Map.of(
                                "Notification", new PropValue("push", true),
                                "Language", new PropValue("Korean", true))
                )
        );
    }

    @DisplayName("UserSetting Entity 등록")
    @ParameterizedTest
    @MethodSource("userSetting")
    void registUserSetting(
            Long userId, Map<String, PropValue> props
    ){
        // given
        UserSettingDTO userSettingDTO = UserSettingDTO.builder()
                .userId(userId)
                .props(props).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                ()-> userSettingTwoService.registUserSetting(userSettingDTO)
        );
    }

    private static Stream<Arguments> userUpdateSetting() {
        return Stream.of(
                Arguments.of(
                        1L,
                        567L,
                        Map.of(
                                "Notification", new PropValue("push", true),
                                "Language", new PropValue("Korean", true)),
                        "Notification",
                        "push",
                        false

                )
        );
    }

    @DisplayName("UserSetting Entity props 수정")
    @ParameterizedTest
    @MethodSource("userUpdateSetting")
    void updateUserSetting(
            Long id, Long userId, Map<String, PropValue> props,
            String key, String value, boolean enabled
    ){
        // given
        UserSettingDTO userSettingDTO = UserSettingDTO.builder()
                .userId(userId)
                .props(props).build();
        userSettingTwoService.registUserSetting(userSettingDTO);
        // when
        // then
        userSettingDTO.setId(id);
        Assertions.assertDoesNotThrow(
                () -> userSettingTwoService.updateUserSetting(userSettingDTO,key, value, enabled)
        );
    }

    private static Stream<Arguments> userRemoveSetting() {
        return Stream.of(
                Arguments.of(
                        1L,
                        567L,
                        Map.of(
                                "Notification", new PropValue("push", true),
                                "Language", new PropValue("Korean", true)),
                        "Notification"
                )
        );
    }

    @DisplayName("UserSetting Entity props 삭제")
    @ParameterizedTest
    @MethodSource("userRemoveSetting")
    void removeUserSetting(
            Long id, Long userId, Map<String, PropValue> props, String key
    ){
        // given
        UserSettingDTO userSettingDTO = UserSettingDTO.builder()
                .userId(userId)
                .props(props).build();
        userSettingTwoService.registUserSetting(userSettingDTO);
        // when
        // then
        userSettingDTO.setId(id);
        Assertions.assertDoesNotThrow(
                () -> userSettingTwoService.removeUserSetting(userSettingDTO,key)
        );
    }
}