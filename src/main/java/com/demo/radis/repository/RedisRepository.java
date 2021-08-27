package com.demo.radis.repository;

import com.demo.radis.model.Login;

public interface RedisRepository {
	
	public Login login(Login login);
}
