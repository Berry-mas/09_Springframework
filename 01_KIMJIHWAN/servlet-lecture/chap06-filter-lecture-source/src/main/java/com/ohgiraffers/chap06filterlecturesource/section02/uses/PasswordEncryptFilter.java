package com.ohgiraffers.chap06filterlecturesource.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(value="/member /*")
public class PasswordEncryptFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        RequestWrapper requestWrapper = new RequestWrapper(request);
        filterChain.doFilter(requestWrapper, servletResponse);
    }
} /* select * from user where userid = 'user01'*/
