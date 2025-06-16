package com.js.account_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Value("${account.name}")
	private String accountFromConfig;

	@GetMapping("/accountfromconfig")
	public ResponseEntity<String> getAccountFromConfig(){
		return ResponseEntity.ok("Config Repo has " + accountFromConfig);
	}
	
	@GetMapping("/{id}")
	public String getProduct(@PathVariable String id){
		return "account from account-service " + id;
	}
}
