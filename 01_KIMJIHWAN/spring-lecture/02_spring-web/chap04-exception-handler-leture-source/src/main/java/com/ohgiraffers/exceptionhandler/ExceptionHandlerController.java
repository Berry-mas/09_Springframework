package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

public class ExceptionHandlerController {

    @GetMapping("/controller-null")
    public String nullPointerExceptionTest(){
        String str = null;
        System.out.println(str.charAt(0));  // 의도적으로 NullPointerException 발생
        return "/";
    }

    @GetMapping("/controller-user")
    public String userExceptionTest() throws MemberRegistException {
        boolean check = true;
        if(check) throw new MemberRegistException("당신 같은 사람은 회원으로 받을 수 없습니다.");
        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e){
        System.out.println("지역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException e, Model model){
        System.out.println("지역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());
        model.addAttribute("exception", e);
        return "error/memberRegist";
    }
}
