package com.ohgiraffers.section02.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new GenericXmlApplicationContext("section01/xmlconfig/spring-config.xml");

        String[] defininitionNames = applicationContext.getBeanDefinitionNames();
        for (String defininitionName : defininitionNames) {
            System.out.println("defininitionName = " + defininitionName);

            MemberDTO member = applicationContext.getBean("member", MemberDTO.class);
            System.out.println(member.getPersonalAccount().getBalance());
        }
    }
}
