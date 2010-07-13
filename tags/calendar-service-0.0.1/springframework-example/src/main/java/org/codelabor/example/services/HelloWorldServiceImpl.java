package org.codelabor.example.services;

import org.codelabor.example.managers.HelloWorldManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldServiceImpl implements HelloWorldService {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldServiceImpl.class);
	protected HelloWorldManager helloWorldManager;;

	public String sayHello() throws Exception {
		logger.debug("sayHello()");
		return helloWorldManager.sayHello();
	}

	public void setHelloWorldManager(HelloWorldManager helloWorldManager) {
		this.helloWorldManager = helloWorldManager;
	}
}
