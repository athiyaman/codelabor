package org.codelabor.edu;

public class HelloWorldClient2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorldImpl2 helloWorld = new HelloWorldImpl2();
		System.out.println(helloWorld.sayHello());
		System.out.println(helloWorld.sayHelloLowerCase());
		System.out.println(helloWorld.sayHelloUpperCase());
	}
}
