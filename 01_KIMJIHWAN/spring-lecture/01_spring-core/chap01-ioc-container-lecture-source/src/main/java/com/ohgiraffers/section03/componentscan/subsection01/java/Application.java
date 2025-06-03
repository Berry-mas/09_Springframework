package com.ohgiraffers.section03.componentscan.subsection01.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /*
        * ComponentScan?
        * base package로 설정된 하위 경로에 특정 어노테이션을 가지고 있는 클래스를 bean으로 등록하는 기능이다.
        * @Component어노테이션이 작성된 클래스를 인식하여 bean으로 등록한다.
        * 특수 목적에 따라 세부 기능을 제공하는 @Controller, @Service, @Repository, @Configuration 등을 사용한다.
        * */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationContext.class);

        // getBeanDefinitionNames: 스프링 컨테이너에서 생성된 bean들의 이름을 배열로 반환
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println("definitionName = " + definitionName);
        }

    }
}
