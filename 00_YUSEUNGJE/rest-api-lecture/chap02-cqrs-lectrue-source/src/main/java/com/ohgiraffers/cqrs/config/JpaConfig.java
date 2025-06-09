package com.ohgiraffers.cqrs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // 어노테이션을 활용해서 자동으로 값을 등록할 수 있다.
public class JpaConfig {
}
