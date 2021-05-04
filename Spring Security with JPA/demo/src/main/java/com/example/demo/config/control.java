package com.example.demo.config;

import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.config.User;
import com.example.demo.security.AuthenticationResponse;
import com.example.demo.Utils.JwUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import com.example.demo.Services.Services;
import com.example.demo.Utils.JwUtil;

@RestController
public class control {
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	JwUtil jwtUtil;
	
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
	
	@RequestMapping("/add")
	public String add( @RequestBody User u) {
		User user=new User();
		user.setId(u.getId());
		user.setUsername(u.getUsername());
		user.setPwd( passwordEncoder.encode(u.getPwd()  )  );
		user.setRoles(u.getRoles());
		userrepo.save(user);
	return "Added Sucessfully";
	}
	
	@PostMapping("/user")
    public AuthenticationResponse generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPwd())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        final String jwt = jwtUtil.generateToken(authRequest.getUsername());
		return new AuthenticationResponse(jwt);
    }
}
