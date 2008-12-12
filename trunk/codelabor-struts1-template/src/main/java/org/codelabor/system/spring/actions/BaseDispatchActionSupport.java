package org.codelabor.system.spring.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.DispatchActionSupport;

import anyframe.core.properties.IPropertiesService;

public class BaseDispatchActionSupport extends DispatchActionSupport {

	protected Log log = LogFactory.getLog(this.getClass());

	protected IPropertiesService propertiesService;

	protected MessageSource messageSource;

	protected String loggerName = this.getClass().getName();

	protected WebApplicationContext webApplicationContext = getWebApplicationContext();

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
