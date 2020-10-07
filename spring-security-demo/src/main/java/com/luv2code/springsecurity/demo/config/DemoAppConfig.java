// The purpose of this class is to setup configurations with Java, rather than XML file & servlet
package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // provides similar support to <mvc:annotation-driven> (Ex: @RequestMapping, @Controller)
@ComponentScan(basePackages = "com.luv2code.springsecurity.demo")
public class DemoAppConfig {
	
	// define a bean for ViewResolver
	
	@Bean
	// The purpose of this method is so we can just pass in the name of the view page in our controller class
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver();
	}

}
