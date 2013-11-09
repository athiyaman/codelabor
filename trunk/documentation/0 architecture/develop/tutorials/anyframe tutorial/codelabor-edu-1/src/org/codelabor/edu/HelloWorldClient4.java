package org.codelabor.edu;

public class HelloWorldClient4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorldImpl4();
		System.out.println(helloWorld.sayHello());
	}
}
