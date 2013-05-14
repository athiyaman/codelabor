package org.codelabor.example.codepro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyService {
	private final Logger logger = LoggerFactory.getLogger(DummyService.class);

	public String someMethod1(String data) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(data);
		sb.append("]");
		logger.debug(sb.toString());
		return sb.toString();
	}

	public String someMethod2(String data) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		sb.append(data);
		sb.append(']');
		logger.debug(sb.toString());
		return sb.toString();
	}
}
