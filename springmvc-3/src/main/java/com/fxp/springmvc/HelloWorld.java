package com.fxp.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloWorld {
	@Autowired
	private UserService userService;
	public HelloWorld() {
		System.out.println("HelloWorld constructor...");
	}
	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("success");
		return "success";
	}
}
