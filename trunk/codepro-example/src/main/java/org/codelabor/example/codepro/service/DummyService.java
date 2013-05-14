package org.codelabor.example.codepro.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyService {
	private final Logger logger = LoggerFactory.getLogger(DummyService.class);

	public String appendStringLiteral(String data) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(data);
		sb.append("]");
		logger.debug(sb.toString());
		return sb.toString();
	}

	public String appendCharacterLiteral(String data) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		sb.append(data);
		sb.append(']');
		logger.debug(sb.toString());
		return sb.toString();
	}

	public void executeCommand() {
		Runtime runtime = Runtime.getRuntime();
		String[] cmdarray = new String[1];
		cmdarray[0] = "dir";
		try {
			logger.debug(runtime.toString());
			runtime.exec(cmdarray);
		} catch (IOException e) {
			logger.equals(e.getMessage());
		}
	}
}
