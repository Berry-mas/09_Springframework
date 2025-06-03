package com.ocean.ch03response.part02.headers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(value="/headers")
public class ResponseHeaders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
//        response.setHeader("Refresh", "1");
        long currentTime = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<head>")
                .append("<title>응답페이지<title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append(currentTime)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(sb.toString());
        out.flush();
        out.close();

        // response header정보
        Collection<String> headerNames = response.getHeaderNames();
        for(String headerName : headerNames) {
            System.out.println(headerName);
        }
    }
}
