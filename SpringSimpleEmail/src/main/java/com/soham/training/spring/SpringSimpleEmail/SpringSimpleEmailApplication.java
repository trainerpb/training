package com.soham.training.spring.SpringSimpleEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soham.training.spring.SpringSimpleEmail.mailutils.Srvc_Email;

@SpringBootApplication
public class SpringSimpleEmailApplication implements CommandLineRunner{

	@Autowired
	Srvc_Email srvc_Email;

	public static void main(String[] args) {
		SpringApplication.run(SpringSimpleEmailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		srvc_Email.sendEmail("soham.payback@gmail.com", "From Spring Email", "Sent from Spring email");
		
		srvc_Email.sendEmailWithAttachment("soham.payback@gmail.com", "From Spring Email", "Sent from Spring email","D:\\abc.txt");
		
	}
}
