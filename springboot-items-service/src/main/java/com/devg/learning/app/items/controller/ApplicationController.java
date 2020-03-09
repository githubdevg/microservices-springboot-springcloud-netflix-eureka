package com.devg.learning.app.items.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devg.learning.app.items.SpringbootItemsServiceApplication;

@RestController
public class ApplicationController {
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	private RestartEndpoint restartEndpoint;
	
	@Value("${config.description}")
	private String environmentDescription;
	
	@PostMapping("/restartManually")
	public void restartAppManually() {
		SpringbootItemsServiceApplication.restartApplicationContext();
	}
	
	
	@PostMapping("/restart")
	public void restart() {
		restartEndpoint.restart();
	}
	
	
	@GetMapping("/config")
	public ResponseEntity<?> getConfiguration() {
		Map<String, Object> response = new HashMap<>();
		response.put("environmentDescription", environmentDescription);
		
		if(env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")) {
			String devToken = env.getProperty("config.dev.authentication.token", "Default");
			response.put("devToken", devToken);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
