package com.ohgiraffers.chap04forwardredirectlecturesource.section01.foward;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/print")
public class PrintLoginSuccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * foward된 servlet에서도 요청 방식이 그대로 유지 된다. post → post
        * 또한 전달된 request, response의 모든 정보를 이용해 새로운
        * request, response를 깊은 복사를 통해 만들어서 전달한다.
        * 고로 이전 데이터가 그대로 유지된다.
        * */
        String userName = (String) request.getAttribute("userName");

        System.out.println("userName = " + userName);
        String userId = request.getParameter("userId");
        System.out.println("userId = " + userId);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + userName + "님 환영합니다." +"</h1>");

    }
}
