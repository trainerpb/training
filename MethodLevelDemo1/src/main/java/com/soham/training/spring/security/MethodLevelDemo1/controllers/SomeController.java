package com.soham.training.spring.security.MethodLevelDemo1.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soham.training.spring.security.MethodLevelDemo1.services.Srvc_SomeService;

@Controller
public class SomeController {

	@Autowired
	
	Srvc_SomeService srvc_SomeService;
	
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("SomeController.home()"+srvc_SomeService.getRandomNumber());
		List<String> players=srvc_SomeService.getUsers(srvc_SomeService.getUsres());
		players.forEach((p)->System.out.println(p));
		srvc_SomeService.getOthers(srvc_SomeService.getPlayers())
						.forEach(p->System.out.println(p));
 		
		System.out.println("SomeController.home()"+srvc_SomeService.getByRun(srvc_SomeService.getPlayers(), 200));
		
		return "home";
	}
	
	@RequestMapping("/email")
	public String emailPage(@RequestParam("user")String user) {
		String email=srvc_SomeService.getMyEmail(user);
		System.out.println("SomeController.emailPage()"+email);
		return "email";
	}
	@RequestMapping("/pay")
	public String pay() {
		srvc_SomeService.doA();
		return "pay";
	}
	@RequestMapping("/doA")
	public String doA() {
		srvc_SomeService.doA();
		return "doA";
	}
}
