package com.example.JPA.control;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="login")
@EntityListeners(AuditingEntityListener.class)
public class user {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String username;
	private String pwd;
	private String name;
	private String email;
	private String institution;
	private int contactno;
	private String roles;
	public user() {
		
	}
	

	public user(int id,int contactno,   String email, String institution,String name,String pwd,String username ,String roles) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.name = name;
		this.roles=roles;
		this.email = email;
		this.institution = institution;
		this.contactno = contactno;
	}
	


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
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

	public int getContactno() {
		return contactno;
	}




	public void setContactno(int contactno) {
		 this.contactno=contactno;
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
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getInstitution() {
		return institution;
	}


	public void setInstitution(String institution) {
		this.institution = institution;
	}
	

}
