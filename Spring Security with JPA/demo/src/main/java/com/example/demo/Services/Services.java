package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Implementation.Details;
import com.example.demo.config.User;
import com.example.demo.config.UserRepo;

@Service
public class Services implements UserDetailsService {

	 @Autowired
	    private UserRepo userRepository;
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }    
	        return new Details(user);
	    }
}