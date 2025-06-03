package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* 해당 어노테이션이 적용된 클래스의 @Exceptionhandler는 전역적으로 가능하다. */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e) {
        System.out.println("전역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException e, Model model){
        System.out.println("전역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());
        model.addAttribute("exception", e);
        return "error/memberRegist";
    }

    /* 모든 타입의 Excption에 대응하기 위해 상위 타입으로 선언된 핸들러 작성 */
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e){
        return "error/default";
    }
}
