package com.demo.radis.service;

import com.demo.radis.model.Login;

public interface RedisService {
	
	public String login(Login login);
	
	public Login checkSession(String username);
	
	public boolean logout(String username);
}
