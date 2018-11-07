package com.soham.training.springboot.security.passwordencoders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSpringBoootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBoootApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		
		for(String p:args) {
			String encodedPassword=bCryptPasswordEncoder.encode(p);
			System.err.println(p+"\tEncoded Password is "+encodedPassword);
		}
	}
}
