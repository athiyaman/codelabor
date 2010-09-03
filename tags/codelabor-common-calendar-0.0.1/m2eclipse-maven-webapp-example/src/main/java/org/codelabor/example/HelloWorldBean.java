package org.codelabor.example;

public class HelloWorldBean {
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	protected String greeting = "Hello, World!";

}
