package org.codelabor.example.lifecycle.schedule.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleGlobalJobListener implements JobListener {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleGlobalJobListener.class);

	public LifecycleGlobalJobListener() {
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

	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		logger.debug("jobToBeExecuted");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
		logger.debug("jobWasExecuted");
	}

}
