package org.codelabor.example.lifecycle.service;

import org.codelabor.example.lifecycle.context.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleServiceImpl implements LifecycleService {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleServiceImpl.class);

	public LifecycleServiceImpl() {
		super();
		logger.debug("construct");
		logger.debug("thread id: {}", Thread.currentThread().getId());
	}

	@Override
	public void execute() {
		logger.debug("execute");
		logger.debug("thread id: {}", Thread.currentThread().getId());
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
	}

}