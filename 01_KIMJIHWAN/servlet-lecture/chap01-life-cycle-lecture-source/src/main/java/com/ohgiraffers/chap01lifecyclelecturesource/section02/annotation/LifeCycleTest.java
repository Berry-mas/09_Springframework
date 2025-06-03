package com.ohgiraffers.chap01lifecyclelecturesource.section02.annotation;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/*
* @WebServlet : 서블릿을 서블릿 컨테이너에 등록
* value 속성 : 서블릿 매핑2
 */

@WebServlet(value="/annotation-lifecycle", loadOnStartup = 1)
public class LifeCycleTest extends HttpServlet {
    public LifeCycleTest() {
        System.out.println("Annotation mapping constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Annotation mapping init");
    }

    // 계속 요청을 받고 get요청, post요청을 구분
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Annotation mapping service");
    }

    @Override
    public void destroy() {
        System.out.println("Annotation mapping destroy");
    }
}
