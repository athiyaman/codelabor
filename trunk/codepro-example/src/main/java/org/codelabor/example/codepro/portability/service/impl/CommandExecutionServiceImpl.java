package org.codelabor.example.codepro.portability.service.impl;

import java.io.IOException;

import org.codelabor.example.codepro.portability.service.CommandExecutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandExecutionServiceImpl implements CommandExecutionService {

	private final Logger logger = LoggerFactory
			.getLogger(CommandExecutionServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.codepro.portability.service.CommandExecutionService
	 * #executeCommand()
	 */
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
