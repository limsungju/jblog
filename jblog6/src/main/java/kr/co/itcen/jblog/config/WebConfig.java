package kr.co.itcen.jblog.config;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import kr.co.itcen.jblog.security.LoginInterceptor;
import kr.co.itcen.jblog.security.LogoutInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	// MessageConverter
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		Jackson2ObjectMapperBuilder builder = 
				new Jackson2ObjectMapperBuilder()
				.indentOutput(true)
				.dateFormat(new SimpleDateFormat("yyyy-mm-dd"))
				.modulesToInstall(new ParameterNamesModule()); // pom.xml에 Jackson Module Parameter Names Library 추가
		
		MappingJackson2HttpMessageConverter converter = 
				new MappingJackson2HttpMessageConverter(builder.build());
		
		converter.setSupportedMediaTypes(
				Arrays.asList(
					new MediaType("application", "json", Charset.forName("UTF-8"))
				)
			); // Arrays.asList : 값이 배열로 되어있는 경우 사용
		
		return converter;
	}
	
	// MessageConverter
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		converter.setSupportedMediaTypes(
				Arrays.asList(
					new MediaType("application", "json", Charset.forName("UTF-8"))
				)
			);
		
		return converter;
	}
	
	// MessageConverter
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter());
		converters.add(stringHttpMessageConverter());
	}
	
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
