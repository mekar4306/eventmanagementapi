package com.karadayi.eventmanagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //This annotation is used in method level you can check in the Eventrepository delete method.
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		//Here {noop} means you do not need password encoding
		auth.inMemoryAuthentication().withUser("Mehmet").password("{noop}150712").roles("USER").and().withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().and().authorizeRequests().
		antMatchers(HttpMethod.POST, "/events").hasRole("ADMIN").
		antMatchers(HttpMethod.PUT, "/events/**").hasRole("ADMIN").
		antMatchers(HttpMethod.PATCH, "/events/**").hasRole("ADMIN").
		and().csrf().disable();
		
	}
	
}
