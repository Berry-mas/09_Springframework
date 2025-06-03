package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigurationContext.class); // 이렇게 선언햇기 때문에 어노테이션 영향 안 받고 사용 가능

        MemberDTO member = applicationContext.getBean("member", MemberDTO.class);
        System.out.println(member);
    }
}
