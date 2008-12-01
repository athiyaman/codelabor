package org.codelabor.system.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;
import anyframe.core.query.IQueryService;

public class BaseServiceImpl {

	protected MessageSource messageSource;

	protected Log log = LogFactory.getLog(this.getClass());

	protected String loggerName = this.getClass().getName();

	protected IPropertiesService propertiesService;

	protected IIdGenerationService idGenerationService;

	protected IQueryService queryService;
	
	public BaseServiceImpl() {
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

	public IIdGenerationService getIdGenerationService() {
		return idGenerationService;
	}

	public void setIdGenerationService(
			IIdGenerationService sequenceIdGenerationService) {
		this.idGenerationService = sequenceIdGenerationService;
	}

	public IQueryService getQueryService() {
		return queryService;
	}

	public void setQueryService(IQueryService queryService) {
		this.queryService = queryService;
	}
}
