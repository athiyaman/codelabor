package org.codelabor.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleServiceImpl implements LifecycleService {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleServiceImpl.class);

	public LifecycleServiceImpl() {
		super();
		logger.debug("execute");
	}

	@Override
	public void execute() {
		logger.debug("execute");
	}

}
