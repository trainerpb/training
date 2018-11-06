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
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	
	DataSource userDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/**
		 * I'm going to hardcode some usernames and passwords
		 */
		
		/*auth.inMemoryAuthentication()
			.withUser("toya").password("123456").roles("user")
			.and()
			.withUser("sohan").password("abcdef").roles("admin")
			.and().passwordEncoder(NoOpPasswordEncoder.getInstance());*/
		
		auth.jdbcAuthentication()
			.dataSource(userDataSource)
			.usersByUsernameQuery("select username, password, enabled"
		            + " from users where username=?")
		    .authoritiesByUsernameQuery("select username, authority "
		            + "from authorities where username=?")
		    .passwordEncoder(NoOpPasswordEncoder.getInstance());
		
		
		
		
		
		
		/*auth.jdbcAuthentication()
			.dataSource(userDataSource)
			.usersByUsernameQuery("select username, password, enabled"
		            + " from users where username=?")
		    .authoritiesByUsernameQuery("select username, authority "
		            + "from authorities where username=?")
		    .passwordEncoder(NoOpPasswordEncoder.getInstance());*/
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*This will make everything inaccessible*/
		//http.authorizeRequests().anyRequest().denyAll();
		
		/* This will open everything */
//		http.authorizeRequests().anyRequest().permitAll();
		
		/**
		 * The rule base- 
		 *  I want /user/** and /admin/** to be protected 
		 *  And only page1-3 to be accessible publicly
		 */
		http.authorizeRequests()
			.antMatchers("/admin/**","/user/**")
			.authenticated()
			.and()
			.formLogin().defaultSuccessUrl("/home")
			.and()
			.logout().logoutSuccessUrl("/goodbye")
			;
		
		
		
		/*http.authorizeRequests()
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
		
			;*/
			
			
	}

}
