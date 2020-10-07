package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// Configure users (in memory, database, ldap, etc.)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("MANAGER"))
			.withUser(users.username("susan").password("test123").roles("ADMIN"));
		
	}

	// Configure security of web paths in application, login, logout, etc.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() // restrict access based on the HTTPServletRequest
			.anyRequest().authenticated() // user must be logged in
			.and()
			.formLogin() // custom login page
			.loginPage("/showMyLoginPage") // show our custom login
			// (Note: controller mapping is needed for this ^)
			.loginProcessingUrl("/authenticateTheUser") // submit data & check credentials
			// (Note: no controller mapping is needed for this ^)
			.permitAll() // allow everyone to see login page
			.and()
			.logout().permitAll(); // adds logout support
		
	}
	
	
	
	

}
