package kr.co.itcen.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kr.co.itcen.jblog.security.LoginInterceptor;
import kr.co.itcen.jblog.security.LogoutInterceptor;

/**
 * 1. Interceptor 설정
 */
@Configuration
@EnableWebMvc
public class SecurityConfig extends WebMvcConfigurerAdapter {

	// Interceptors
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Bean
	public LogoutInterceptor logoutInterceptor() {
		return new LogoutInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 로그인 인터셉터 처리
		registry
			.addInterceptor(loginInterceptor())
			.addPathPatterns("/user/auth");
		
		// 로그아웃 인터셉터 처리
		registry
		.addInterceptor(logoutInterceptor())
		.addPathPatterns("/user/logout");
		
	}
	
}
