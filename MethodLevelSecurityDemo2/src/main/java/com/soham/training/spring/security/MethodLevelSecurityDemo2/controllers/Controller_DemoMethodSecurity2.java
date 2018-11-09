package com.soham.training.spring.security.MethodLevelSecurityDemo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soham.training.spring.security.MethodLevelSecurityDemo2.srvc.DummyService;

@Controller
public class Controller_DemoMethodSecurity2 {

	@Autowired
	DummyService dummyService;
	
	@RequestMapping("/home")
	public String home() {
		try {
			dummyService.domeSomethingElse("virat");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*dummyService.getOtherDays(dummyService.getAllDays())
					.forEach(q->System.out.println("Controller_DemoMethodSecurity2.home()"+q));
		*/
		String y=dummyService.getAllOtherDaysAsObjects(dummyService.getAllDaysAsObjects())
		;
		System.out.println(y);
		return "home";
	}
	
	@RequestMapping("/admin/a1")
	public String admin1() {
		dummyService.doSomeAdminWork();
		
		return "admin/admin1";
	}
	
	@RequestMapping("/emp/e1")
	public String e1() {
		int x=dummyService.sillyRandom();
		System.out.println("Controller_DemoMethodSecurity2.e1()"+x);
		return "emp/emp1";
	}
	
	@RequestMapping("/nov/n1")
	public String nov1() {
		return "nov/nov1";
	}
}
