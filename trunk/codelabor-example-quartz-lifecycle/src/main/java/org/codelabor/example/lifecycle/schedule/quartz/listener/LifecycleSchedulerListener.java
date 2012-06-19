package org.codelabor.example.lifecycle.schedule.quartz.listener;

import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleSchedulerListener implements SchedulerListener {

	private final static Logger logger = LoggerFactory
			.getLogger(LifecycleSchedulerListener.class);

	public LifecycleSchedulerListener() {
		super();
		logger.debug("constructor");
	}

	@Override
	public void jobScheduled(Trigger arg0) {
		logger.debug("jobScheduled");
	}

	@Override
	public void jobUnscheduled(String arg0, String arg1) {
		logger.debug("jobUnscheduled");
	}

	@Override
	public void jobsPaused(String arg0, String arg1) {
		logger.debug("jobsPaused");
	}

	@Override
	public void jobsResumed(String arg0, String arg1) {
		logger.debug("jobsResumed");
	}

	@Override
	public void schedulerError(String msg, SchedulerException cause) {
		logger.debug("schedulerError");
	}

	@Override
	public void schedulerShutdown() {
		logger.debug("schedulerShutdown");
	}

	@Override
	public void triggerFinalized(Trigger trigger) {
		logger.debug("triggerFinalized");
	}

	@Override
	public void triggersPaused(String arg0, String arg1) {
		logger.debug("triggersPaused");
	}

	@Override
	public void triggersResumed(String arg0, String arg1) {
		logger.debug("triggersResumed");
	}

}
