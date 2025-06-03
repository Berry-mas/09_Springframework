package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.setcion01.aop");
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }

        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.println("========================== selectMembers ===============================");
        System.out.println(memberService.selectMembers());
        System.out.println("========================== selectMember ===============================");
        System.out.println(memberService.selectMember(3L));

        MemberTwoService memberService2 = context.getBean("memberTwoService", MemberTwoService.class);
        System.out.println("========================== selectMembers ===============================");
        System.out.println(memberService2.selectMembers());
        System.out.println("========================== selectMember ===============================");
        System.out.println(memberService2.selectMember(1L));
    }
}
