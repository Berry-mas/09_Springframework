package com.ohgiraffers.springsecurity.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginRequest {

    // 기본적으로 정의되어 있는 변수명
    private final String username;  // ID
    private final String password;  // 비밀번호


}
