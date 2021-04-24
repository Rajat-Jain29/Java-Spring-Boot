package com.example.JPA.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class control {
	@Autowired
	private userrepo userRepo;
	
	@GetMapping("/get")
	public List<user> getAll(){
		return userRepo.findAll();
	}
	
	@PostMapping("/insert")
	public String users(@Validated @RequestBody user u) {
	    userRepo.save(u);
	    return "Inserted Succesfully";
	}
	
	@GetMapping("/get/{id}")
	public Optional<user> getOne(@PathVariable int id){
		return userRepo.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String getOneDelete(@PathVariable int id){
		userRepo.deleteById(id);
		return "Deleted Successfully";
		
	}
	
	@PutMapping("/update")
	public String getUpdate(@RequestBody user u)  {
		userRepo.save(u);
		return "Updated";		
	}
	
	@GetMapping("/username/{id}")
	public String getUserName(@PathVariable("id") int id){
		Optional<user> Optionaluser= userRepo.findById(id);
		String username=Optionaluser.get().getUsername();
		return username;
	}
	
}