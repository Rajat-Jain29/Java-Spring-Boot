package com.example.demo.config;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "sign")
public class User {

	
	
	
	@Id
	private int id;

	private String username;
	private String pwd;
	private String roles;
	
	
	public User(int id, String username, String pwd, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.roles = roles;
	}
	

	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		BCryptPasswordEncoder m= new BCryptPasswordEncoder();
		return m.encode(pwd);

	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
