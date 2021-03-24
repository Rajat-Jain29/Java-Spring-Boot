package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Course;
import com.example.demo.services.couservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@ResponseBody
public class Test {
	@Autowired
	private couservice cs;
	@GetMapping("/")
	public String index() {
		return "Fish";
	}
	// get courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.cs.getCourses();
		 
	}
	
	@GetMapping("/courses/{cid}")
	public Course getCourse(@PathVariable String cid){
		return this.cs.getCourse(Long.parseLong(cid));
	}
	
	@PostMapping("/courses")
	public Course addc(@RequestBody Course c){
		return this.cs.addc(c);
	}
	
	
	
	
	
	

}