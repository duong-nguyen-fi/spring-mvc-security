package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

//add annotation and then configure method =>done
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("test123").roles("USER"))
		.withUser(users.username("mary").password("test123").roles("USER","MANAGER"))
		.withUser(users.username("susan").password("test123").roles("ADMIN", "USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				//.anyRequest().authenticated()
			.antMatchers("/").hasRole("USER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
				.logout()
				.permitAll()
			.and()
				.exceptionHandling()
					.accessDeniedPage("/access-denied");
	}
	
	
	
	
}
