package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component// 이 객체를 빈으로 등록하고 싶을 때
public class StopwatchInterceptor implements HandlerInterceptor {
    /* Interceptor는 스프링 컨테이너에 존재하는 빈을 의존성 주입 받을 수 있다. */
    private final MenuService menuService;

    public StopwatchInterceptor(MenuService menuService) {
        this.menuService = menuService;
    }

    /* 전처리 메소드 */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return false; // controller handler method로 호출이 이어진다. false이면 호출하지 않는다.
        System.out.println("preHandler 메소드 동작");

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    /* 후처리 메소드 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /* ModelAndView 객체를 후처리 시 가공할 수도 있다. */
        System.out.println("postHandler 메소드 호출");

        long endTime = System.currentTimeMillis();
        long startTime = (long) request.getAttribute("startTime");
        modelAndView.addObject("interval", endTime - startTime);
    }

    /* 뷰가 렌더링 된 이후 동작하는 메소드, Exception 사용 가능*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 메소드 호출");
        menuService.method();
    }
}
