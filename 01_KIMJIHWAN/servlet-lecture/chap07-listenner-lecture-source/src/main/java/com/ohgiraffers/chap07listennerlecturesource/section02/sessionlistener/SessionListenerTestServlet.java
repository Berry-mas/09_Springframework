package com.ohgiraffers.chap07listennerlecturesource.section02.sessionlistener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/session") // 또다른 속성이 없으면 value 생략 가능 (value = "", loadOnStartup = 0)
public class SessionListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println("발급받은 session id: " + session.getId());

        // add
        session.setAttribute("username", "honggildong");
        session.setAttribute("age", 30);
        session.setAttribute("gender", "M");

        // replaced
        session.setAttribute("username", "hong");

        // removed
        session.removeAttribute("gender");

        /* session을 만료 */
        session.invalidate();
    }

}
