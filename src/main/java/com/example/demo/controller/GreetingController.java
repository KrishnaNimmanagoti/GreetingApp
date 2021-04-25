package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting;
import com.example.demo.service.IGreetingService;

@RestController
@RequestMapping({"/", " "})
public class GreetingController {
	
	@Autowired
	private IGreetingService greetingService;
	
	@GetMapping("/getGreeting")
	public Greeting getGreeting(@RequestParam(value="firstName") Optional<String> firstName, 
			@RequestParam(value="lastName") Optional<String> lastName) {
		String name = "";
		if(firstName.isPresent())
			name += firstName.get();
		if(lastName.isPresent())
			name += " " + lastName.get();
		if(name.length() == 0)
			name = "Hello World";
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
