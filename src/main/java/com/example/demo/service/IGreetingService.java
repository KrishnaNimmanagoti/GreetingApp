package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Greeting;

public interface IGreetingService {
	
	List<Greeting> getGreetings();
	Greeting putGreeting(String name);
	Greeting postGreeting(String name);
	Greeting getGreetingById(Long id);

}