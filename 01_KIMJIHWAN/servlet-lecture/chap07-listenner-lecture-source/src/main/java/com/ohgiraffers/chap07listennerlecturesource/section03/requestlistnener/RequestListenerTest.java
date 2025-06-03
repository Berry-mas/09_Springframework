package com.ohgiraffers.chap07listennerlecturesource.section03.requestlistnener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

    public RequestListenerTest() {
        /* context가 로드 될 때 생성자 호출하여 인스턴스는 생성된다. */
        System.out.println("request listener 인스턴스 생성");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        /* request가 소멸될 때 호출된다. */
        System.out.println("request destroyed!!!");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        /* request가 생성될 때 호출된다. */
        System.out.println("request initialized!!!");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("attribute added!!!");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("attribute removed!!!");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("attribute replaced!!!");
    }
}
