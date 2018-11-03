package com.soham.training.spring.SpringSimpleEmail.mailutils;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class Srvc_Email {

	@Autowired
	JavaMailSender mailUtil;
	
	public void sendEmail(String to,String subject,String body) {
		SimpleMailMessage mailMessage=new  SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		mailUtil.send(mailMessage);
	}
	
	public void sendEmailWithAttachment(String to,String subject,String body,String filePath) throws MessagingException {
		MimeMessage mailMessage=mailUtil.createMimeMessage();
		MimeMessageHelper messageHelper=new  MimeMessageHelper(mailMessage,true);
		messageHelper.setTo(to);
		messageHelper.setSubject(subject);
		messageHelper.setText(body);
		FileSystemResource fileSystemResource=new FileSystemResource(filePath);
		messageHelper.addAttachment(new File(filePath).getName(), fileSystemResource);
		mailUtil.send(mailMessage);
	}
}
