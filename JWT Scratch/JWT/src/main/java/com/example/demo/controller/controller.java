package com.example.demo.controller;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	
	@RequestMapping("/hello")
	public String firstPage() {
	return "Hello World";
	}
	
	@GetMapping("/")
	public String readCookie(@CookieValue(value = "someSessionId", defaultValue = "user") String token) {
	    	
	return "Hey! My cookie is "+token;
	
	}
	

}
