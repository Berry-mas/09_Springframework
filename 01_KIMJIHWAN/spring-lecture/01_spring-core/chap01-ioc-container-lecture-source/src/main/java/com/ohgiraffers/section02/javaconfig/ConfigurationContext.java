package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration 어노테이션은 해당 클래스가 빈을 생성하는 클래스임을 표기한다.
@Configuration  // 설정값에 대한 것은 무조건 써줘야 함
public class ConfigurationContext {

    /*
    * @Bean어노테이션은 해당 메소드의 반환 값을 스프링 컨테이너에 빈으로 등록한다는 의미이다.
    * 이름을 별도로 지정하지 않으면 메소드 이름이 bean의 id로 자동 인식한다.
    * @Bean("myName") 또는 @Bean(name="myName")의 형식으로 bean의 id를 설정할 수 있다.
    * */


    @Bean(name="member")
    public MemberDTO getMember() {
        return new MemberDTO(1,"user01", "pass01", "홍길동2");
    }
}
