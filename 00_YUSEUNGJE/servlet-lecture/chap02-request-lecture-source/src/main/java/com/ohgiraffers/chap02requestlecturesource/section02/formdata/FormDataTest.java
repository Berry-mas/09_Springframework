package com.ohgiraffers.chap02requestlecturesource.section02.formdata;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value="/formdata")
public class FormDataTest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * HttpServletRequest 객체로부터 요청 시 전달한 값을 getParameter메소드로 추출할 수 있다.
         * 인자로 input 태그의 name속성 값을 문자열 형태로 전달한다.
         * 모든 input 태그의 값을 hashmap으로 관리하고 있으므로 원하는 값을 찾기 위해
         * key 역할을 할 문자열이 필요하다
         * */ 
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("age = " + age);
        java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
        System.out.println("birthday = " + birthday);
        String gender = request.getParameter("gender");
        System.out.println("gender = " + gender);
        String national = request.getParameter("national");
        System.out.println("national = " + national);
        String[] hobbies = request.getParameterValues("hobbies");
        System.out.println("hobbies = " + Arrays.toString(hobbies));

    }
}
