package com.ohgiraffers.chap02_requestlecturesource.section02.formdata;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value="/formdata")
public class FormDataTest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post요청확인");
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
