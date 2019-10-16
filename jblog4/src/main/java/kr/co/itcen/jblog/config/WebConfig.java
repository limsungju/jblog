package kr.co.itcen.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import kr.co.itcen.config.web.MVCConfig;

@Configuration
@EnableAspectJAutoProxy // <aop:aspectj-autoproxy />
@ComponentScan({"kr.co.itcen.jblog.controller"}) // auto-scan
@Import({MVCConfig.class})
public class WebConfig {
	
}
