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
package org.codelabor.example.encoding.web.controller;

import org.codelabor.example.encoding.dto.ParamDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sang Jae Shin
 * 
 */
@Controller
@RequestMapping(value = "/example/encoding")
public class EncodingController {

	private final static Logger logger = LoggerFactory
			.getLogger(EncodingController.class);

	private final String formView = "example/encoding/post/request";
	private final String resultView = "example/encoding/post/result";

	/**
	 * 
	 */
	public EncodingController() {
	}

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public ModelAndView prepareForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("paramDto", new ParamDto());
		mav.setViewName(formView);
		return mav;
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ModelAndView submitForm(ParamDto paramDto) {
		logger.debug("paramDto: {}", paramDto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(resultView);
		return mav;
	}

}
