package org.codelabor.edu;

public class HelloWorldImpl implements HelloWorld {

	private Greeting greeting;

	public String sayHello() {
		return greeting.getGreeting();
	}

	public Greeting getGreeting() {
		return greeting;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

}
