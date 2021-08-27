package com.demo.radis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.demo.radis.model.Login;
import com.demo.radis.repository.RedisRepository;

@Service
public class RedisServiceImpl implements RedisService{
	
	private static final String HASH_KEY = "login";
	
	@Autowired
	private RedisRepository redisRepository;

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public String login(Login login) {
		Login data = this.redisRepository.login(login);
		if(data != null) {
			this.redisTemplate.opsForHash().put(HASH_KEY, login.getUsername(), login);
		}
		return data != null ? "Login Successful" : "Invalid Username or Password";
	}

	@Override
	public Login checkSession(String username) {
		return (Login) this.redisTemplate.opsForHash().get(HASH_KEY, username);
	}

	@Override
	public boolean logout(String username) {
		
		this.redisTemplate.opsForHash().delete(HASH_KEY, username);
		
		return true;
	}
	
	
}
