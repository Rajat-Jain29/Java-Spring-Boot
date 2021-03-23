package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@ResponseBody
public class DemoApplication {
	
	@RequestMapping("/welcome.html")
	public ModelAndView index() {
		return new ModelAndView("welcome");
	}

}