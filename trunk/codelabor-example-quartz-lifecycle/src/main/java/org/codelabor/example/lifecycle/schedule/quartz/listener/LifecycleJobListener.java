package org.codelabor.example.lifecycle.schedule.quartz.listener;

import org.codelabor.example.lifecycle.context.UserContextHolder;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleJobListener implements JobListener {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleJobListener.class);

	public LifecycleJobListener() {
		super();
		logger.debug("constructor");
	}

	@Override
	public String getName() {
		logger.debug("getName");
		String name = this.getClass().getName();
		logger.debug("name: {}", name);
		return name;
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		logger.debug("jobExecutionVetoed");
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());

	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		logger.debug("jobToBeExecuted");
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
		logger.debug("jobWasExecuted");
		logger.debug("user id: {}", UserContextHolder.getContext().getUserId());
	}

}
