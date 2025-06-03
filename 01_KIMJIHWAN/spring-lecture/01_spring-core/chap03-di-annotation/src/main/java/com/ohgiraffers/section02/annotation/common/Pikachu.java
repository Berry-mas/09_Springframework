package com.ohgiraffers.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
* @Autowired로 동일 타입의 빈이 여러개 찾아진 경우
* 우선시 할 타입을 설정
* */
@Primary
@Component
public class Pikachu implements Pokemon{
    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트");
    }
}