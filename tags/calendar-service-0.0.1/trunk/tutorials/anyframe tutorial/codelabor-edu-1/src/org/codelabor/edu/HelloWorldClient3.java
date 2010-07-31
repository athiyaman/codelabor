package org.codelabor.edu;

public class HelloWorldClient3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorldImpl3();
		System.out.println(helloWorld.sayHello());
	}
}
