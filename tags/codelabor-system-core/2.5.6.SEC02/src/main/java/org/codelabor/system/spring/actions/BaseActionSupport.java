package org.codelabor.system.spring.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.ActionSupport;

import anyframe.core.properties.IPropertiesService;

public class BaseActionSupport extends ActionSupport {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected IPropertiesService propertiesService;
	protected MessageSource messageSource;
	protected WebApplicationContext webApplicationContext;

	public BaseActionSupport() {
		super();
		webApplicationContext = getWebApplicationContext();
		propertiesService = (IPropertiesService) webApplicationContext
				.getBean("propertiesService");
		messageSource = (MessageSource) webApplicationContext
				.getBean("messageSource");
	}

}
