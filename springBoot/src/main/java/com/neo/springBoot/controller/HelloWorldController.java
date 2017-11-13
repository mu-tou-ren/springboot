package com.neo.springBoot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.springBoot.domain.Admin;

@RestController
public class HelloWorldController {

	@Value("${com.neo.username}")
	private String username;
	@Value("${com.neo.password}")
	private String password;
	
	@RequestMapping("/hello")
	public String index(){
		return "Hello World";
	}
	
	@RequestMapping("/getUser")
	public String getUser(){
		return new Admin().toString();
	}
}
