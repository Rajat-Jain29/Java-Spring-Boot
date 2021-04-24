package com.example.JPA.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class control {
	
	
	@Autowired
	userRepo ur;
	
	@GetMapping("get")
	@Bean(name="entityManagerFactory")
	List<user> h(){
		return ur.findAll();
	}
	
}
