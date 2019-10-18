package kr.co.itcen.jblog.initializer;

import javax.servlet.Filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import kr.co.itcen.jblog.config.AppConfig;
import kr.co.itcen.jblog.config.WebConfig;

public class JblogApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Root Application Context
		return new Class<?>[] { AppConfig.class }; // 클레스 지정
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web Application Context
		return new Class<?>[] { WebConfig.class }; // 클레스 지정
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"}; // urlMapping 작업
	}

	@Override
	protected Filter[] getServletFilters() {
		// CharacterEncoding
		return new Filter[] { new CharacterEncodingFilter("UTF-8", true) };
	}

	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		DispatcherServlet dispatcherServlet = 
				(DispatcherServlet)super.createDispatcherServlet(servletAppContext);
		
		// Exception Handler가 발견되지 않으면 Error!!
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		
		return dispatcherServlet;
	}
	
}
