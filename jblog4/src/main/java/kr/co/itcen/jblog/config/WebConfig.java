package kr.co.itcen.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import kr.co.itcen.config.web.MVCConfig;
import kr.co.itcen.config.web.MessageConfig;
import kr.co.itcen.config.web.SecurityConfig;

@Configuration
@EnableAspectJAutoProxy // <aop:aspectj-autoproxy />
@ComponentScan({"kr.co.itcen.jblog.controller"}) // auto-scan
@Import({MVCConfig.class, SecurityConfig.class, MessageConfig.class})
@ImportResource({"classpath:kr/co/itcen/jblog/config/web/dispatcher-servlet.xml"})
public class WebConfig {
	
}
