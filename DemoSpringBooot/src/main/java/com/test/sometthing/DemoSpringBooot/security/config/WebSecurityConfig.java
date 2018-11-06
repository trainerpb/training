package com.test.sometthing.DemoSpringBooot.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	
	DataSource userDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("soham").password("1234").roles("admin")
			.and()
			.withUser("babun").password("4321").roles("user");*/
		auth.jdbcAuthentication()
			.dataSource(userDataSource)
			.usersByUsernameQuery("select username, password, enabled"
		            + " from users where username=?")
		    .authoritiesByUsernameQuery("select username, authority "
		            + "from authorities where username=?")
		    .passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user/**").permitAll()
			.and()
			.authorizeRequests()
			.antMatchers("/admin/**")
				.authenticated()
				.and()
				.formLogin()
				.defaultSuccessUrl("/page1")
			.and()
		
			.logout()
		
			;
			
			
	}

}
