package com.example.demo.model;

public class Greeting {
	
	private long id;
	private String message;
	
	public Greeting(Long id, String greetingMessage) {
		this.id = id;
		this.message = greetingMessage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
