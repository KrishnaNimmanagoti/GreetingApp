package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting;
import com.example.demo.service.IGreetingService;

@RestController
public class GreetingController {
	
	@Autowired
	private IGreetingService greetingService;
	
	@GetMapping("/getGreeting")
	public Greeting getGreeting(@RequestParam(value="name", defaultValue="World") String name) {
		return greetingService.getGreeting(name);
	}
	
	@PutMapping("/putGreeting")
	public Greeting putGreeting(@RequestParam(value="name", defaultValue="Unidentified") String name) {
		return greetingService.putGreeting(name);
	}
	
	@PostMapping("/postGreeting")
	public Greeting postGreeting(@RequestParam(value="name") String name) {
		return greetingService.postGreeting(name);
	}

}
