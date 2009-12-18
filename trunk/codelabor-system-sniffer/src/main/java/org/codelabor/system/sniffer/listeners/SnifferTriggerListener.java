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
package org.codelabor.system.sniffer.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class SnifferTriggerListener implements TriggerListener {

	protected Log log = LogFactory.getLog(SnifferTriggerListener.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#getName()
	 */
	public String getName() {
		return SnifferTriggerListener.class.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#triggerComplete(org.quartz.Trigger,
	 * org.quartz.JobExecutionContext, int)
	 */
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			int triggerInstructionCode) {
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append(trigger.getJobName()).append(" complete");
			log.debug(sb.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#triggerFired(org.quartz.Trigger,
	 * org.quartz.JobExecutionContext)
	 */
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append(trigger.getJobName()).append(" fired");
			log.debug(sb.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#triggerMisfired(org.quartz.Trigger)
	 */
	public void triggerMisfired(Trigger trigger) {
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append(trigger.getJobName()).append(" misfired");
			log.debug(sb.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#vetoJobExecution(org.quartz.Trigger,
	 * org.quartz.JobExecutionContext)
	 */
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append(trigger.getJobName()).append(" fired");
			log.debug(sb.toString());
		}
		return false;
	}
}
