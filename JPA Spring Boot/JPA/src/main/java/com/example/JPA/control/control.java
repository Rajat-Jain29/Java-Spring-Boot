package com.example.JPA.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
public class control {
	@Autowired
	private userrepo userRepo;
	@Autowired
	private RestTemplate rest;
	@GetMapping("/get")
	public List<user> getAll(){
		return userRepo.findAll();	
		
//		String authStr = "Raja:1234";
//	    String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
//	    System.out.println(base64Creds);
		
//	    RestTemplateBuilder rst = new RestTemplateBuilder();
//	    this.rest= rst.basicAuthentication("Raja","1234").build();
//	    
//	    // getForObject used for -- It retrieves an entity using HTTP GET method on the given URL.
//	    
//		String p=rest.getForObject("http://localhost:8080/admin", String.class);
//		String q=rest.getForObject("http://localhost:8080/user", String.class);
//		return p+" "+q;
		
		//return "RAJAT";
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/insert")
	public String users(@Validated @ModelAttribute user u) {
	    userRepo.save(u);
	    return "Inserted Succesfully";
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/get/{id}")
	public Optional<user> getOne(@PathVariable int id){
		return userRepo.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@DeleteMapping("/delete/{id}")
	public String getOneDelete(@PathVariable int id){
		userRepo.deleteById(id);
		return "Deleted Successfully";
		
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping("/update")
	public String getUpdate(@ModelAttribute user u)  {
		userRepo.save(u);
		return "Updated";		
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/username/{id}")
	public String getUserName(@PathVariable("id") int id){
		Optional<user> Optionaluser= userRepo.findById(id);
		String username=Optionaluser.get().getUsername();
		return username;
	}
	
}