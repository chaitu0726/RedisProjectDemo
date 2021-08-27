package com.demo.radis.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Login")
public class Login implements Serializable {
	
	private int loginId;
	
	private String username;
	
	private String password;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

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
	
	
}
