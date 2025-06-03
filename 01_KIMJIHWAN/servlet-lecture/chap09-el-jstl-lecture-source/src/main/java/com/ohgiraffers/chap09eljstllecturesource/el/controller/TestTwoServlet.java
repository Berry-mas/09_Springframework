package com.ohgiraffers.chap09eljstllecturesource.el.controller;

import com.ohgiraffers.chap09eljstllecturesource.el.model.dto.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test2")
public class TestTwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO member = new MemberDTO("홍길동", 19, "010-1234-5678", "gildong@ohgiraffers.com");
        request.setAttribute("member", member);

        RequestDispatcher rd = request.getRequestDispatcher("views/el/testEl2.jsp");
        rd.forward(request, response);
    }
}
