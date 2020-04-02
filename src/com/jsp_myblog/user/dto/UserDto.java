package com.jsp_myblog.user.dto;

import java.sql.Timestamp;

public class UserDto {
	private String id;
	private String password;
	private String name;
	private String email;
	private Timestamp rdate;
	private String isAdmin;
	
	public UserDto() {
		
	}
	
	public UserDto(String id, String password, String name, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setRDate(Timestamp rdate) {
		this.rdate = rdate;
	}
	
	public Timestamp getRDate() {
		return this.rdate;
	}
	
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public String getIsAdmin() {
		return this.isAdmin;
	}
}
