package com.ohgiraffers.entity.section03.element.collection.sub03.map.setting2;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserSettingTwoService {

    private UserSettingTwoRepository userSettingTwoRepository;

    public UserSettingTwoService(UserSettingTwoRepository userSettingTwoRepository) {
        this.userSettingTwoRepository = userSettingTwoRepository;
    }

    @Transactional
    public void registUserSetting(UserSettingDTO userSettingDTO) {

        UserSetting userSetting = UserSetting.builder()
                .userId(userSettingDTO.getUserId())
                .props(userSettingDTO.getProps()).build();

        userSettingTwoRepository.registUserSetting(userSetting);
    }

    @Transactional
    public void updateUserSetting(UserSettingDTO userSettingDTO, String key, String value, boolean enabled) {

        UserSetting userSetting = userSettingTwoRepository.findByUserId(userSettingDTO.getId());
        userSetting.changeProp(key, value, enabled);
    }

    @Transactional
    public void removeUserSetting(UserSettingDTO userSettingDTO, String key) {

        UserSetting userSetting = userSettingTwoRepository.findByUserId(userSettingDTO.getId());
        userSetting.removeProp(key);
    }
}
