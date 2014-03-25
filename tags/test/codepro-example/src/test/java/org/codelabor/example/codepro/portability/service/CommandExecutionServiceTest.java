package org.codelabor.example.codepro.portability.service;

import org.codelabor.example.codepro.portability.service.impl.CommandExecutionServiceImpl;
import org.junit.Test;

public class CommandExecutionServiceTest {

	CommandExecutionService commandExecutionService = new CommandExecutionServiceImpl();

	@Test
	public void testExecuteCommand() {
		commandExecutionService.executeCommand();
	}

}
