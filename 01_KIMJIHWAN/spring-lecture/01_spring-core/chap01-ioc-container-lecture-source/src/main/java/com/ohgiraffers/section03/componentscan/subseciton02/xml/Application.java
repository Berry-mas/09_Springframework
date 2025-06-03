package com.ohgiraffers.section03.componentscan.subseciton02.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new GenericXmlApplicationContext("section03/xmlconfig/spring-context.xml");
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println("definitionName = " + definitionName);
        }
    }
}