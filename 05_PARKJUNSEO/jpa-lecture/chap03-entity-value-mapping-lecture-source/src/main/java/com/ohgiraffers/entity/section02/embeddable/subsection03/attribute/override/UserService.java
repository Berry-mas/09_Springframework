package com.ohgiraffers.entity.section02.embeddable.subsection03.attribute.override;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void registUser(UserDTO userDTO){
        Address homeAddress = new Address(userDTO.getHomeAddress1(), userDTO.getHomeAddress2(), userDTO.getHomeZipCode());

        Address workAddress = new Address(userDTO.getWorkAddress1(), userDTO.getWorkAddress2(), userDTO.getWorkZipCode());

        User user = User.builder()
                .id(userDTO.getId())
                .homeAddress(homeAddress)
                .workAddress(workAddress).build();

        userRepository.registUser(user);
    }
}
