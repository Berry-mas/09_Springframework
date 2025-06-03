package com.ohgiraffers.chap04forwardredirectlecturesource.section01.foward;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(value = "/foward")
public class ReceiveInformation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        request.setAttribute("userName", "홍길동");    // 다 넣어줄 수 있다? (오브젝트 타입)

        RequestDispatcher dispatcher = request.getRequestDispatcher("print");
        dispatcher.forward(request, response);  // 현재 request, response 객체 정보를 위임
    }
}
