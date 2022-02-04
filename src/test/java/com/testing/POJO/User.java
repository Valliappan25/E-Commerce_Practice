package com.testing.POJO;

public class User {

	private String username;
	
	private String email;
	private String password;
	
	public User() {}
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public User(String username,String email, String password)
	{
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
}
