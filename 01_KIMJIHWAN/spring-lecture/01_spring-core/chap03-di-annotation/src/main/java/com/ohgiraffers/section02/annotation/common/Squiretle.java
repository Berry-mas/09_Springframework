package com.ohgiraffers.section02.annotation.common;

import org.springframework.stereotype.Component;

@Component
public class Squiretle implements Pokemon{
    @Override
    public void attack() {
        System.out.println("꼬부기 물대포 발사");
    }
}
