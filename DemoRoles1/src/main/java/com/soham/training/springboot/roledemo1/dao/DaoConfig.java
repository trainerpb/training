package com.soham.training.springboot.roledemo1.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DaoConfig {

	@Bean("userDataSource")
	public DataSource getUserDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("net.ucanaccess.jdbc.UcanaccessDriver");
		String msAccDB = "D:\\Training Github\\training\\AuthDB.accdb";
		String dbURL = "jdbc:ucanaccess://" + msAccDB;
		ds.setUrl(dbURL);
		return ds;
	}
}
