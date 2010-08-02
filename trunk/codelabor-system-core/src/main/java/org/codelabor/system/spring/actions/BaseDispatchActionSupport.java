package org.codelabor.system.spring.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.DispatchActionSupport;

import anyframe.core.properties.IPropertiesService;

public class BaseDispatchActionSupport extends DispatchActionSupport {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected MessageSource messageSource;
	protected IPropertiesService propertiesService;
	protected WebApplicationContext webApplicationContext;

	public BaseDispatchActionSupport() {
		super();
		webApplicationContext = getWebApplicationContext();
		propertiesService = (IPropertiesService) webApplicationContext
				.getBean("propertiesService");
		messageSource = (MessageSource) webApplicationContext
				.getBean("messageSource");
	}
}
