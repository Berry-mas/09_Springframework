package com.ohgiraffers.chap05cookiesessionlecturesource.section01.cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/cookie-redirect")
public class CookieRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        System.out.println("firstName = " + firstName + ", lastName = " + lastName);

        /* 저장된 쿠키값을 꺼내서 확인 */
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("firstName"))
                firstName = cookie.getValue();
            else if(cookie.getName().equals("lastName"))
                lastName = cookie.getValue();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>your firstName is " + firstName + " and lastName is " + lastName + "</h1>");
        out.flush();
        out.close();
    }




}
