package com.example.JPA.control;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class user {
	
	private String username;
	private String pwd;
	private String name;
	private String email;
	private int contact;
	private String ins;
	public user() {
		
	}
	public user(String username, String pwd, String name, String email, int contact, String ins) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.ins = ins;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getIns() {
		return ins;
	}
	public void setIns(String ins) {
		this.ins = ins;
	}

}
