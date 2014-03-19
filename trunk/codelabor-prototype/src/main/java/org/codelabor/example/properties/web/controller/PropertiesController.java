/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.example.properties.web.controller;

import org.codelabor.example.properties.service.PropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Shin Sang-Jae
 * 
 */
@Controller
@RequestMapping("/example/properties")
public class PropertiesController {

	private final static Logger logger = LoggerFactory
			.getLogger(PropertiesController.class);

	@Autowired
	private Environment env;

	@Value("${jdbc.driverClassName}")
	private String jdbcDriverClassName;

	@Autowired
	private PropertiesService propertiesService;

	@Value("${webmaster.email}")
	private String webSiteFeedBackEmailAddress;

	@Value("${webmaster.phoneNumber}")
	// do not use list type
	// private List<String> webSiteFeedBackPhoneNumbers;
	private String[] webSiteFeedBackPhoneNumbers;

	@RequestMapping(value = "/listProperties", method = RequestMethod.GET)
	public ModelAndView listProperties() {
		logger.debug("getProperties");

		// from controller
		logger.debug("webmaster.email: {}", webSiteFeedBackEmailAddress);
		for (String webSiteFeedBackPhoneNumber : webSiteFeedBackPhoneNumbers) {
			logger.debug("webmaster.phoneNumber: [{}]",
					webSiteFeedBackPhoneNumber);
		}
		logger.debug("jdbc.driverClassName: {}", jdbcDriverClassName);

		// from service
		String feedbackEmailAddress = propertiesService
				.getFeedbackEmailAddress();
		logger.debug("propertiesService.getFeedbackEmailAddress(): {}",
				feedbackEmailAddress);

		// from environment
		String javaHome = env.getProperty("JAVA_HOME");
		logger.debug("env.getProperty(\"JAVA_HOME\"): {}", javaHome);

		ModelAndView mav = new ModelAndView();
		mav.addObject("websiteFeedbackEmailAddress",
				webSiteFeedBackEmailAddress);
		mav.addObject("websiteFeedbackPhoneNumbers",
				webSiteFeedBackPhoneNumbers);
		mav.addObject("jdbcDriverClassName", jdbcDriverClassName);
		mav.addObject("javaHome", javaHome);
		mav.setViewName("example/properties/list");
		return mav;
	}

}
