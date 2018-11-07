package com.soham.training.springboot.roledemo1.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class RolebasedSecurityAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	
	DataSource userDataSource;
	
	/** 
	 * Use jdbc to authenticate and authorize user
	 *  
	 *  */
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
		.jdbcAuthentication()
		.dataSource(userDataSource)
		.usersByUsernameQuery("select username, password, enabled"
	            + " from usersWithRole where username=?")
	    .authoritiesByUsernameQuery("select username, authority "
	            + "from authorities where username=?")
	    .passwordEncoder( NoOpPasswordEncoder.getInstance());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
			.antMatchers("/*").permitAll()
			.antMatchers("/admin/**","/emp/**","/payment/**").hasRole("ADMIN")
			.antMatchers("/emp/**").hasRole("EMP")
		.and()
			.formLogin().successForwardUrl("/home") //defaultSuccessUrl("/home")
				.and()
			.logout().logoutSuccessUrl("/goodbye")
		;
	}

}
