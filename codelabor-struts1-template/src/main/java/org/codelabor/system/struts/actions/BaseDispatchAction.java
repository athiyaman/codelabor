package org.codelabor.system.struts.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.actions.DispatchAction;
import org.springframework.context.MessageSource;

import anyframe.core.properties.IPropertiesService;

public class BaseDispatchAction extends DispatchAction {

	protected Log log = LogFactory.getLog(this.getClass());

	protected IPropertiesService propertiesService;

	protected MessageSource messageSource;

	protected String loggerName = this.getClass().getName();

	public IPropertiesService getPropertiesService() {
		return propertiesService;
	}

	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
		this.log = LogFactory.getLog(loggerName);
	}
}
