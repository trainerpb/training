package com.soham.training.springboot.roledemo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoRoleController {

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
	
	@RequestMapping("/admin/a2")
	public String a2() {
		return "/admin/a1";
	}
	
	@RequestMapping("/payment/pay1")
	public String pay1() {
		return "/payment/pay1";
	}
	@RequestMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping("/emp/emp1")
	public String emp1() {
		return "/emp/emp1";
	}
	
	@RequestMapping("/emp/emp2")
	public String emp2() {
		return "/emp/emp2";
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
