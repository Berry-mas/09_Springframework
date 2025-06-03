package com.ocean.ch03response.part03.exception;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(value="/show500error")
public class Show500Error extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(500, "500에러는 누구잘못? 개발자! 개발자는 누구? 여러분!");
    }
}
