package org.codelabor.edu;

public class HelloWorldClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorldImpl helloWorld = new HelloWorldImpl();
		System.out.println(helloWorld.sayHello());
	}
}
