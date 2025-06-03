package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {

    @GetMapping("/string")
    public String stringReturning(Model model){
        // Model : view에서 표현 되어야 하는 동적인 데이터를 담는 용도로 사용하는 객체
        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환");

        // ViewResolver가 prefix/suffix를 합쳐서 물리적인 뷰를 선택
        return "result";
    }

    @GetMapping("/string-redirect")
    public String stringRedirect() {
        // 핸들러 메소드에서 viewresolver의 기본전송방식은 forward입니다.
        // 경우에 따라서 redirect로 전송을 하도록해야하는데
        // 그때는 viewresolver객체에게 redirect: 를 붙여서 요청하면
        // redirect 방식으로 이동
        return "redirect:/";

    }

    /* Redirect 시 request scope의 데이터는 공유 되지 않는다.
     * session scope에 너무 많은 데이터를 저장하는 것은 서버 성능에 영향을 준다.
     * RedirectAttributes 객체를 통해 잠시 세션에 저장했다가 redirect 후 세션에서
     * 제거되게 할 수 있다. */
    @GetMapping("/string-redirect-attr")
    public String stringRedirectAttr(RedirectAttributes rttr) {
        rttr.addFlashAttribute("flashMessage", "리다이렉트 attr사용하여 redirect");
        return "redirect:/";
    }

    @GetMapping("/modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv){
        mv.setViewName("redirect:/");
        return mv;
    }
}
