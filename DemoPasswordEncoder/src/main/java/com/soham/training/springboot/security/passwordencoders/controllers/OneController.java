package com.soham.training.springboot.security.passwordencoders.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OneController {

	@RequestMapping("/page1")
	public String page1() {
		return "page1";
	}
	@RequestMapping("/page2")
	public String page2() {
		return "page2";
	}
	@RequestMapping("/page3")
	public String page3() {
		return "page3";
	}
	@RequestMapping("/admin/a1")
	public String a1() {
		return "/admin/a1";
	}
	@RequestMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping("/user/u1")
	public String u1() {
		return "/user/u1";
	}
	
	/**
	 * @return The url where we'll land upon 
	 * after log out
	 */
	@RequestMapping("/goodbye")
	public String logoutPage() {
		return "/goodbye";
	}
}
