package org.codelabor.example.helloworld.service;

import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.helloworld.service.HelloWorldService#sayHello()
	 */
	public String sayHello() {
		return "Hello, World!";
	}

}
