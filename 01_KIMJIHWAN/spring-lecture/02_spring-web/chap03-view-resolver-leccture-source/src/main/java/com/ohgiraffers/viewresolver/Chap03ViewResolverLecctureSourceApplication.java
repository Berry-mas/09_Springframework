package com.ohgiraffers.viewresolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class Chap03ViewResolverLecctureSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap03ViewResolverLecctureSourceApplication.class, args);
	}

	@GetMapping("/modelandview")
	public ModelAndView modelAndView(ModelAndView mv){

		// Model 객체
		//  체에 attribue 저장
		mv.addObject("forwardMessage", "ModelAndView를 이용");
		// View 객체에 논리적 뷰 이름 설정
		mv.setViewName("result");

		return mv;
	}


}
