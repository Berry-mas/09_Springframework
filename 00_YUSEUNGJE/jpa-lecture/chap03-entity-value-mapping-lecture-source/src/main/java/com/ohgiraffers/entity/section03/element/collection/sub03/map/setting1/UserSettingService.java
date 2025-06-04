package com.ohgiraffers.entity.section03.element.collection.sub03.map.setting1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class UserSettingService {

    private UserSettingRepository userSettingRepository;

    public UserSettingService(UserSettingRepository userSettingRepository) {
        this.userSettingRepository = userSettingRepository;
    }

    @Transactional
    public void registUserSetting(UserSettingDTO userSettingDTO) {

        UserSetting userSetting = UserSetting.builder()
                .userId(userSettingDTO.getUserId())
                .props(userSettingDTO.getProps())
                .build();
        userSettingRepository.registUserSetting(userSetting);
    }
}
