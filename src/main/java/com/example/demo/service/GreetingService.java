package com.example.demo.service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.example.demo.model.Greeting;

@Service
public class GreetingService implements IGreetingService{
	private AtomicLong counter = new AtomicLong();
	private String template = "Hello, %s!";
	
	@Override
	public Greeting getGreeting(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@Override
	public Greeting putGreeting(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template,  name));
	}

	@Override
	public Greeting postGreeting(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
