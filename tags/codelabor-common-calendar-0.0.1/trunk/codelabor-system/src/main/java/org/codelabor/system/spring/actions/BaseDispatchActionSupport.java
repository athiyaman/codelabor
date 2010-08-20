package org.codelabor.system.spring.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.DispatchActionSupport;

import anyframe.core.properties.IPropertiesService;

public class BaseDispatchActionSupport extends DispatchActionSupport {

	protected Log log = LogFactory.getLog(this.getClass());
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
