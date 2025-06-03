package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
/*
* proxyTargetClass = true : Proxy 객체 생성의 방식으로 CGLib방식을 사용
* target object가 class인 경우에도 proxy 객체 생성 가능
* */
@EnableAspectJAutoProxy
public class ContextConfiguration {

}
