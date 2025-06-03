package com.ohgiraffers.chap01lifecyclelecturesource.section01.xml;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class LifeCycleTest extends HttpServlet {

    public LifeCycleTest() {
        System.out.println("XML mapping constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("XML mapping init");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("XML mapping service");
    }

    @Override
    public void destroy() {
        System.out.println("XML mapping destroy");
    }
}
