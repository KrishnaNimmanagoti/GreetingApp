package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/getGreetings")
	public List<Greeting> getGreeting(@RequestParam(value="name", defaultValue="World") String name) {
		return greetingService.getGreetings();
	}
	
	@PutMapping("/putGreeting/{id}")
	public Greeting putGreeting(@RequestParam(value="message", defaultValue="Not provided") String message, @PathVariable Long id) {
		return greetingService.putGreeting(message, id);
	}
	
	@PostMapping("/postGreeting")
	public Greeting postGreeting(@RequestParam(value="firstName") Optional<String> firstName, 
			@RequestParam(value="lastName") Optional<String> lastName) {
		String name = "";
		if(firstName.isPresent())
			name += firstName.get();
		if(lastName.isPresent())
			name += " " + lastName.get();
		if(name.length() == 0)
			name = "Hello World";
		return greetingService.postGreeting(name);
	}
	
	@GetMapping("/getGreeting/{id}")
	public Greeting getGreetingById(@PathVariable Long id) {
		return greetingService.getGreetingById(id);
	}
}
