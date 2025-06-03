package com.ohgiraffers.chap09eljstllecturesource.el.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test1")
public class TestOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", "홍길동");
        request.setAttribute("age", 19);
        request.setAttribute("phone", "010-1234-5678");

        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("banana");
        items.add("melon");

        request.setAttribute("items", items);

        RequestDispatcher rd = request.getRequestDispatcher("views/el/testEl1.jsp");
        rd.forward(request, response);
    }
}
