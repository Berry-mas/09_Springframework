package com.ohgiraffers.chap04forwardredirectlecturesource.section02.redirect;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/redirect")
public class redirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("이 서블릿으로 redirect완료!");
        String name2 = (String) request.getAttribute("name2");
        System.out.println("name2 = " + name2);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>이 서블릿으로 redirect완료!</h1>");
        out.flush();
        out.close();
    }
}
