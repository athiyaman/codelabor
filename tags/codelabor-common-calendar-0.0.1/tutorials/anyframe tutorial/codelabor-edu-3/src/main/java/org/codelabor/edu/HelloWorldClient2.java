package org.codelabor.edu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldClient2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String configLocation = "applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocation);

		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld2");
		System.out.println(helloWorld.sayHello());

	}
}
