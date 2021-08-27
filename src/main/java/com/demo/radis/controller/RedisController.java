package com.demo.radis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.radis.model.Login;
import com.demo.radis.service.RedisService;

@RestController
@CrossOrigin(origins = {"*"})
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		return this.redisService.login(login);
	}
	
	@GetMapping("/checkSession")
	public boolean checkSession(@RequestParam String username) {
		Login login =  this.redisService.checkSession(username);
		return login != null;
	}
	
	@GetMapping("/logout")
	public boolean logout(@RequestParam String username) {
		return this.redisService.logout(username);
	}
}
