package com.test.sometthing.DemoSpringBooot.controllers;

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
	
	@RequestMapping("/user/u1")
	public String u1() {
		return "/user/u1";
	}
}
