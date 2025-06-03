package com.ohgiraffers.chap06filterlecturesource.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value ="/first/filter")
public class FirstFilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet doGet 메소드 호출");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>필터 확인용 서블릿</h1>");
        out.flush();
        out.close();
    }

}
