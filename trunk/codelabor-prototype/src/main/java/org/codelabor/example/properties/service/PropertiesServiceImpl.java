package org.codelabor.example.properties.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesServiceImpl implements PropertiesService {

	private final static Logger logger = LoggerFactory
			.getLogger(PropertiesServiceImpl.class);

	@Value("${jdbc.driverClassName}")
	private String jdbcDriverClassName;

	@Value("${webmaster.email}")
	private String webSiteFeedBackEmailAddress;

	@Override
	public String getFeedbackEmailAddress() {
		logger.debug("webmaster.email: {}", webSiteFeedBackEmailAddress);
		return webSiteFeedBackEmailAddress;
	}

}
