package org.codelabor.example.helloworld.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String sayHello() {
		return "Hello, World!";
	}

	@Override
	public String sayHello(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello, ");
		if (StringUtils.isNotEmpty(name)) {
			sb.append(name).append('!');
		} else {
			sb.append("World!");
		}
		return sb.toString();
	}
}
