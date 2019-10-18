package kr.co.itcen.jblog.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import kr.co.itcen.jblog.config.AppConfig;
import kr.co.itcen.jblog.config.WebConfig;

public class SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {AppConfig.class}; // 클레스 지정
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class}; // 클레스 지정
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"}; // urlMapping 작업
	}

}
