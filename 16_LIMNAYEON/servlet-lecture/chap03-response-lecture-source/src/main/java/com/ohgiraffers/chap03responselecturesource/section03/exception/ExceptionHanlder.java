package com.ohgiraffers.chap03responselecturesource.section03.exception;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

// custom error page 응답하는 서블릿
@WebServlet(value = "/showErrorPage")
public class ExceptionHanlder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            System.out.println(attributeName + " : " + request.getAttribute(attributeName));
        }

        int statusCode = (int)request.getAttribute("javax.servlet.error.status_code");
        String message = (String)request.getAttribute("javax.servlet.error.message");
        String servletName = (String)request.getAttribute("javax.servlet.error.servlet_name");

        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<head>")
                .append("<title>응답페이지</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append(statusCode)
                .append("</h1><h2>")
                .append(message)
                .append("</h2><h3>")
                .append(servletName)
                .append("</h3>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.write(sb.toString());
        out.flush();
        out.close();

    }

}
