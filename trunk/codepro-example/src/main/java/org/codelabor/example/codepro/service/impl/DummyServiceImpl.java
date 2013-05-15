package org.codelabor.example.codepro.service.impl;

import java.io.IOException;

import org.codelabor.example.codepro.service.DummyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyServiceImpl implements DummyService {
	private final Logger logger = LoggerFactory.getLogger(DummyServiceImpl.class);

	/* (non-Javadoc)
	 * @see org.codelabor.example.codepro.service.impl.DummyService#appendStringLiteral(java.lang.String)
	 */
	public String appendStringLiteral(String data) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(data);
		sb.append("]");
		logger.debug(sb.toString());
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see org.codelabor.example.codepro.service.impl.DummyService#appendCharacterLiteral(java.lang.String)
	 */
	public String appendCharacterLiteral(String data) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		sb.append(data);
		sb.append(']');
		logger.debug(sb.toString());
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see org.codelabor.example.codepro.service.impl.DummyService#executeCommand()
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
