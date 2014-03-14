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
package org.codelabor.example.authentication.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Shin Sang-Jae
 *
 */
@Controller
@RequestMapping("/example/authentication")
public class LoginController {

	private final static Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = "/loginFailure", method = RequestMethod.GET)
	public ModelAndView loginFailure() {
		logger.debug("loginFailure");

		// TODO set retry count (or in handler)

		final ModelAndView mav = new ModelAndView();
		// TODO if retry count exceeded, deny access and lock account
		// mav.setViewName("example/authentication/accessDenied");
		mav.setViewName("forward:/example/authentication/prepareLogin");
		return mav;
	}

	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public ModelAndView loginSuccess() {
		logger.debug("loginSuccess");

		// TODO get last access info (time, ip) (or in handler)

		final ModelAndView mav = new ModelAndView();
		// TODO set last access info (time, ip)
		mav.setViewName("example/authentication/loginSuccess");
		return mav;
	}

	@RequestMapping(value = "/logoutSuccess", method = RequestMethod.GET)
	public ModelAndView logoutSuccess() {
		logger.debug("logoutSuccess");

		// TODO get elapsed time

		final ModelAndView mav = new ModelAndView();
		// TODO set elapsed time
		mav.setViewName("example/authentication/logoutSuccess");
		return mav;
	}

	@RequestMapping(value = "/prepareLogin", method = RequestMethod.GET)
	public ModelAndView prepareLogin(final HttpSession session) {
		logger.debug("prepareLogin");

		// get spring security exception
		final Object springSecurityLastException = session
				.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		if (springSecurityLastException != null) {
			logger.error("springSecurityLastException: {}",
					springSecurityLastException);
		}

		// TODO get retry count

		final ModelAndView mav = new ModelAndView();
		// TODO set retry count
		mav.setViewName("example/authentication/loginForm");
		return mav;
	}

}
