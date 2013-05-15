package org.codelabor.example.codepro.performance.service.impl;


import org.codelabor.example.codepro.performance.service.AppendStringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppendStringServiceImpl implements AppendStringService {
	private final Logger logger = LoggerFactory
			.getLogger(AppendStringServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.codepro.performance.service.AppendStringService
	 * #appendStringLiteral(java.lang.String)
	 */
	public String appendStringLiteral(String data) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(data);
		sb.append("]");
		logger.debug(sb.toString());
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.codepro.performance.service.AppendStringService
	 * #appendCharacterLiteral(java.lang.String)
	 */
	public String appendCharacterLiteral(String data) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		sb.append(data);
		sb.append(']');
		logger.debug(sb.toString());
		return sb.toString();
	}
}
