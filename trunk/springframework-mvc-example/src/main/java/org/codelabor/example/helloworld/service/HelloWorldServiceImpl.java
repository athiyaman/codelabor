package org.codelabor.example.helloworld.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	public String sayHello() throws Exception {
		return "Hello, World!";
	}

	public String sayHello(String name) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello, ");
		if (StringUtils.isNotEmpty(name)) {
			sb.append(name).append("!");
		} else {
			sb.append("World!");
		}
		return sb.toString();
	}
}
