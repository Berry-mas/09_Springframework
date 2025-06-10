package com.ohgiraffers.springsecurity.config;

import com.ohgiraffers.springsecurity.jwt.JwtAuthenticationFilter;
import com.ohgiraffers.springsecurity.jwt.JwtTokenProvider;
import com.ohgiraffers.springsecurity.jwt.RestAccessDeniedHandler;
import com.ohgiraffers.springsecurity.jwt.RestAuthenticationEntryPoint;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity // HTTP요청의 인증/인가 -> 처리할수있게
@EnableMethodSecurity // @PreAuthorize @PostAuthorize
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final RestAccessDeniedHandler restAccessDeniedHandler;

    // 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //  어떤 URL이 보호되고 공개되고 로그인, 로그아웃, 세션......
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        // CSRF 처리 비활성화
        http.csrf(AbstractHttpConfigurer::disable)
        // 세션 로그인 x -> 토큰 로그인 설정
        .sessionManagement(session
                -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // 인증 실패, 인가 실패 핸들러
        .exceptionHandling(exception ->
                exception.authenticationEntryPoint(restAuthenticationEntryPoint)    // 인증 실패
                        .accessDeniedHandler(restAccessDeniedHandler)          // 인가 실패
        )
        .authorizeHttpRequests(auth ->
                 auth.requestMatchers(HttpMethod.POST,"/api/v1/users", "/api/v1/auth/login"
                                 , "/api/v1/auth/refresh", "/api/v1/auth/logout").permitAll()
                         .requestMatchers(HttpMethod.GET, "/api/v1/me").hasAuthority("USER")
                         .anyRequest().authenticated()
        )
        // 커스텀 인증 필터(JWT 사용하여 확인)를 인증 필터 앞에 삽입
        .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        /* cors 설정 */
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()));
        return http.build();
    }

    @Bean
    public Filter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtTokenProvider, userDetailsService);
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:5173"); // 허용할 도메인
        config.addAllowedHeader("*"); // 모든 헤더 허용
        config.addAllowedMethod("*"); // 모든 HTTP 메소드 허용
        config.setAllowCredentials(true);// 자격 증명(쿠키 등) 허용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);// 모든 경로에 대해 설정
        return source;
    }
}
