package com.ohgiraffers.section03.proxy.subsection02.cglib;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;


public class Handler implements InvocationHandler {

    /* 타겟 오브젝트를 Class타입으로 사용할 수 있다. */
    private final OhgiraffersStudent ohgiraffersStudent;

    public Handler(OhgiraffersStudent ohgiraffersStudent) {
        this.ohgiraffersStudent = ohgiraffersStudent;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("=== 공부가 너무 하고 싶어요 =====");
        System.out.println("호출 대상 메소드 : " + method);
        for(Object arg : args) {
            System.out.println("전달 인자 : " + arg);
        }

        // 타겟 오브젝트의 메소드를 호출
        method.invoke(ohgiraffersStudent, args);

        System.out.println("=== 공부를 마치고 정리를 위해서 수면 학습을 시작합니다 ===");

        return null;
    }
}
