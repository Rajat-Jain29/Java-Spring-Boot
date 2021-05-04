package com.example.demo.config;


public class AuthRequest {
	private String username;
    private String pwd;
    
    public AuthRequest()
    {
    	
    }
	public AuthRequest(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
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
    
    

}
