package org.codelabor.system.spring.actions;

import org.apache.struts.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import anyframe.core.properties.IPropertiesService;

public class BaseAction extends Action {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

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
		this.logger = LoggerFactory.getLogger(loggerName);
	}
}
