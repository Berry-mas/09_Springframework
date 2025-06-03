package com.ohgiraffers.chap08jsplecturesource.menu.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 요청에 대한 처리 (값 추출, 검증..)
        String name = request.getParameter("menuName");
        int amount = Integer.parseInt(request.getParameter("amount"));

        System.out.println("name = " + name);
        System.out.println("amount = " + amount);

        // 2. 비지니스 로직 처리(대부분 DB에 CRUD연산..)
        int orderPrice = 0;
        switch (name){
            case "햄버거" : orderPrice = 8000 * amount; break;
            case "짜장면" : orderPrice = 10000 * amount; break;
            case "짬뽕" : orderPrice = 12000 * amount;  break;
            case "순대국" : orderPrice = 10000 * amount;  break;
        }

        // 3. 응답 페이지 생성 후 응답
        // 직접 문자열로 페이지를 생성한 뒤 스트림으로 보낼 수 있지만,
        // 페이지 작성이 용이하고 응답을 보여주는 view의 역할을 구분하여 만든 JSP를 활용한다.
        request.setAttribute("orderPrice", orderPrice);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/5_response.jsp");
        dispatcher.forward(request, response);
    }

}
