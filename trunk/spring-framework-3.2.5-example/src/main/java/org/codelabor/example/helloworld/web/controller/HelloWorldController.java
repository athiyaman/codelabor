package org.codelabor.example.helloworld.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/example/helloworld", method = RequestMethod.GET)
public class HelloWorldController {
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@RequestMapping(value = "sayHello")
	public String sayHello() {
		logger.debug("sayHello");
		return "example/helloworld/say-hello";
	}
}
