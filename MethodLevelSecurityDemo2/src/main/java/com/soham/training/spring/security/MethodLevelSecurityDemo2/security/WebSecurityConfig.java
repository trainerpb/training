package com.soham.training.spring.security.MethodLevelSecurityDemo2.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("rohit").password("sharma").roles("EMP")
			.and()
			.withUser("virat").password("happy").roles("ADMIN")
			.and().passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/*","/nov/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/emp/**","/admin/**").hasRole("EMP")
			.and()
			.formLogin().successForwardUrl("/home");
	}

	
	
}
