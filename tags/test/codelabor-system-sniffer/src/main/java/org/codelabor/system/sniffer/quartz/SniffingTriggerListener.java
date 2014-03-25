/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.system.sniffer.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 스니핑 트리거 리스너
 * 
 * @author Shin Sangjae
 * 
 */
public class SniffingTriggerListener implements TriggerListener {

	/**
	 * 로거
	 */
	protected Logger logger = LoggerFactory
			.getLogger(SniffingTriggerListener.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#getName()
	 */
	public String getName() {
		return SniffingTriggerListener.class.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#triggerComplete(org.quartz.Trigger,
	 * org.quartz.JobExecutionContext, int)
	 */
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			int triggerInstructionCode) {
		logger.debug("jobName: {}", trigger.getJobName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#triggerFired(org.quartz.Trigger,
	 * org.quartz.JobExecutionContext)
	 */
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		logger.debug("jobName: {}", trigger.getJobName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#triggerMisfired(org.quartz.Trigger)
	 */
	public void triggerMisfired(Trigger trigger) {
		logger.debug("jobName: {}", trigger.getJobName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#vetoJobExecution(org.quartz.Trigger,
	 * org.quartz.JobExecutionContext)
	 */
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		logger.debug("jobName: {}", trigger.getJobName());
		return false;
	}
}
