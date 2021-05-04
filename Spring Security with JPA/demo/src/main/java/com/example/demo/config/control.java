package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class control {
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/path")
	public String get() {
		return "Hello JPA";
	}

	@GetMapping("/get")
	public List<User> getAll(){
		return (List<User>) userrepo.findAll();
	}
	
	@GetMapping("/")
	public List<User> getList(){
		return (List<User>) userrepo.findAll();
	}
	
	
	@PostMapping("/add")
	public String add( @RequestBody User u) {
		User user=new User();
		user.setId(u.getId());
		user.setUsername(u.getUsername());
		user.setPwd( passwordEncoder.encode(u.getPwd()  )  );
		user.setRoles(u.getRoles());
		userrepo.save(user);
	return "Added Sucessfully";
	}
}
