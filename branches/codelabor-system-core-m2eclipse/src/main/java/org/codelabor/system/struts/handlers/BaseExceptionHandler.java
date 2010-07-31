package org.codelabor.system.struts.handlers;

import org.apache.struts.action.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import anyframe.core.properties.IPropertiesService;

public class BaseExceptionHandler extends ExceptionHandler {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected String loggerName = this.getClass().getName();
	protected MessageSource messageSource;
	protected IPropertiesService propertiesService;

	public String getLoggerName() {
		return loggerName;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public IPropertiesService getPropertiesService() {
		return propertiesService;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
		this.logger = LoggerFactory.getLogger(loggerName);
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

}
