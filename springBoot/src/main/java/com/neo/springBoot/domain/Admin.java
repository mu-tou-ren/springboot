package com.neo.springBoot.domain;

import org.springframework.beans.factory.annotation.Value;

public class Admin {

	@Value("${com.neo.username}")
	private String username;
	@Value("${com.neo.password}")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}
