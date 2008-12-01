package org.codelabor.example;

public class HelloWorldImpl implements HelloWorld {

	public String sayHello() throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("sayHello() thread: ").append(
				Thread.currentThread().hashCode());
		stringBuilder.append(", instance: ").append(this.hashCode());
		System.out.println(stringBuilder.toString());
		return "Hello, World!";
	}

	public String sayHello(String name) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("sayHello(String name) thread: ").append(
				Thread.currentThread().hashCode());
		stringBuilder.append(", instance: ").append(this.hashCode());
		System.out.println(stringBuilder.toString());
		return "Hello, " + name + "!";
	}
}
