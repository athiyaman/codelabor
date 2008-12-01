package org.codelabor.system.managers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

import anyframe.core.properties.IPropertiesService;

public class BaseManagerImpl {

	protected MessageSource messageSource;
	protected Log log = LogFactory.getLog(this.getClass());
	protected String loggerName = this.getClass().getName();
	protected IPropertiesService propertiesService;
	public BaseManagerImpl() {
		super();
	}

	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
		this.log = LogFactory.getLog(loggerName);
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public IPropertiesService getPropertiesService() {
		return propertiesService;
	}

	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

}
