package com.example.springaop.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springaop.logging.LogExecutionTime;

@RestController
@RequestMapping("/v1")
public class HellowWordApi {
	
	@GetMapping("/hello")
	@LogExecutionTime
	public ResponseEntity<String> getHello(){
		return ResponseEntity.ok("Welcome to AOP logging");
	}
	
}
