package kr.co.itcen.jblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import kr.co.itcen.config.app.DBConfig;
import kr.co.itcen.config.app.MyBatisConfig;

@Configuration
@EnableAspectJAutoProxy // <aop:aspectj-autoproxy /> 와 같음
@ComponentScan({"kr.co.itcen.jblog.service", "kr.co.itcen.jblog.repository", "kr.co.itcen.jblog.aspect"}) // <context:annotation-config />, <context:component-scan> 와 같음
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {
	
}
