package com.example.demo.service;

import com.example.demo.model.Greeting;

public interface IGreetingService {
	
	Greeting getGreeting(String name);
	Greeting putGreeting(String name);
	Greeting postGreeting(String name);

}