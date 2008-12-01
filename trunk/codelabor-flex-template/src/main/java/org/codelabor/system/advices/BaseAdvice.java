package org.codelabor.system.advices;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

import anyframe.core.properties.IPropertiesService;

public class BaseAdvice {

	protected Log log = LogFactory.getLog(this.getClass());

	protected String loggerName = this.getClass().getName();

	protected MessageSource messageSource;

	protected IPropertiesService propertiesService;

	public BaseAdvice() {
		super();
	}

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
		this.log = LogFactory.getLog(loggerName);
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

}
