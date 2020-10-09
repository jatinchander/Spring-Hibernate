package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;

	// Configure users (in memory, database, ldap, etc.)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
		// add our users for in memory authentication
		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * 
		 * auth.inMemoryAuthentication()
		 * .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
		 * .withUser(users.username("mary").password("test123").roles("EMPLOYEE",
		 * "MANAGER"))
		 * .withUser(users.username("susan").password("test123").roles("EMPLOYEE",
		 * "ADMIN"));
		 */
		
	}

	// Configure security of web paths in application, login, logout, etc.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() // restrict access based on the HTTPServletRequest
		//	.anyRequest().authenticated() // user must be logged in
			.antMatchers("/").hasRole("EMPLOYEE") // root path accessed by any employee
			.antMatchers("/leaders/**").hasRole("MANAGER") // /leaders accessed by managers only
			.antMatchers("/systems/**").hasRole("ADMIN") // /systems accessed by admins only
			.and()
			.formLogin() // custom login page
			.loginPage("/showMyLoginPage") // show our custom login
			// (Note: controller mapping is needed for this ^)
			.loginProcessingUrl("/authenticateTheUser") // submit data & check credentials
			// (Note: no controller mapping is needed for this ^)
			.permitAll() // allow everyone to see login page
			.and()
			.logout().permitAll() // adds logout support
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied"); // our custom page
	}
	
	
	
	

}
