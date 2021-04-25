package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IGreetingRepository;
import com.example.demo.model.Greeting;

@Service
public class GreetingService implements IGreetingService{
	
	@Autowired
	private IGreetingRepository greetingRepository;
	
	private AtomicLong counter = new AtomicLong();
	private String template = "Hello, %s!";

	@Override
	public Greeting putGreeting(String greetingMessage, Long id) {
		Optional<Greeting> greeting = greetingRepository.findById(id);
		greeting.get().setMessage(greetingMessage);
		return greetingRepository.save(greeting.get());
	}

	@Override
	public Greeting postGreeting(String name) {
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		return greetingRepository.save(greeting);
	}
	
	@Override
	public List<Greeting> getGreetings() {
		return greetingRepository.findAll();
	}
	
	@Override
	public Greeting getGreetingById(Long id) {
		return greetingRepository.findById(id).get();
	}
	
	@Override
	public Greeting deleteGreeting(Long id) {
		Greeting greeting = this.getGreetingById(id);
		greetingRepository.deleteById(id);
		return greeting;
	}

}
