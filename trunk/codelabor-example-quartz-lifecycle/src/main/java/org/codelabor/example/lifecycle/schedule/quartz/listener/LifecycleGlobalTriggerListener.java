package org.codelabor.example.lifecycle.schedule.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleGlobalTriggerListener implements TriggerListener {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleGlobalTriggerListener.class);

	public LifecycleGlobalTriggerListener() {
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
	public void triggerComplete(Trigger arg0, JobExecutionContext arg1, int arg2) {
		logger.debug("triggerComplete");
	}

	@Override
	public void triggerFired(Trigger arg0, JobExecutionContext arg1) {
		logger.debug("triggerFired");
	}

	@Override
	public void triggerMisfired(Trigger arg0) {
		logger.debug("triggerMisfired");
	}

	@Override
	public boolean vetoJobExecution(Trigger arg0, JobExecutionContext arg1) {
		logger.debug("vetoJobExecution");
		return false;
	}

}
