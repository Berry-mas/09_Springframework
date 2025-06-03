package com.ohgiraffers.chap08jsplecturesource;

import  java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/test")
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("test");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/test.jsp");
        dispatcher.forward(request, response);
    }

}