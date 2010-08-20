package org.codelabor.example.managers;

import org.codelabor.example.daos.HelloWorldDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldManagerImpl implements HelloWorldManager {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldManagerImpl.class);
	protected HelloWorldDAO helloWorldDAO;

	public String sayHello() throws Exception {
		logger.debug("sayHello()");
		return helloWorldDAO.sayHello();
	}

	public void setHelloWorldDAO(HelloWorldDAO helloWorldDAO) {
		this.helloWorldDAO = helloWorldDAO;
	}
}
