package com.ohgiraffers.chap07listennerlecturesource.section03.requestlistnener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "honggildong");
        request.setAttribute("age", 20);
        request.setAttribute("gender", "M");

        request.setAttribute("username", "hong");

        request.removeAttribute("gender");
    }
}
