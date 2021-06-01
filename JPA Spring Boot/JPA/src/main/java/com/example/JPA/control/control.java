package com.example.JPA.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
//import org.springframework.web.client.RestTemplate;

@RestController
public class control {
	@Autowired
	private userrepo userRepo;

	@Autowired
//	private RestTemplate rest;
	@ApiOperation(value = "Get All User", response = control.class)
	@GetMapping("/get")
	public List<user> getAll() {
		System.out.println("");
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

		// return "RAJAT";
	}

	@ApiOperation(value = "Registered the user in Database", response = control.class)
//	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/insert")
	public String users(@Validated @ModelAttribute user u) {
		userRepo.save(u);
		return "Inserted Succesfully";
	}

	@ApiOperation(value = "Get username information through particular id", response = control.class)
//	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/get/{id}")
	public user getOne(@PathVariable int id) {
		
		return userRepo.findById( id );
	}

	@ApiOperation(value = "Delete any user record", response = control.class)
//	@CrossOrigin(origins = "http://localhost:8080")
	@DeleteMapping("/delete/{id}")
	public String getOneDelete(@PathVariable int id) {
		userRepo.deleteById(id);
		return "Deleted Successfully";

	}

	@ApiOperation(value = "Update the user information", response = control.class)
//	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping("/update")
	public String getUpdate(@ModelAttribute user u) {
		userRepo.save(u);
		return "Updated";
	}

	@ApiOperation(value = "Get username through particular id", response = control.class)
//	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/username/{id}")
	public String getUserName(@PathVariable("id") int id) {
		user Optionaluser = userRepo.findById(id);
		String username = Optionaluser.getUsername();
		return username;
	}

}