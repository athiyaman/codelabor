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
package org.codelabor.example.validation.hibernate.safeHtml.web.controller;

import javax.validation.Valid;

import org.codelabor.example.validation.hibernate.safeHtml.dto.HtmlContents1Dto;
import org.codelabor.example.validation.hibernate.safeHtml.dto.HtmlContents2Dto;
import org.codelabor.example.validation.hibernate.safeHtml.dto.HtmlContents3Dto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/example/validation/hibernate/safeHtml")
public class HtmlContentsController {

	private static final Logger logger = LoggerFactory
			.getLogger(HtmlContentsController.class);

	private final String FORM_VIEW_NAME = "example/validation/hibernate/safe-html/form";
	private final String COMPLETED_VIEW_NAME = "example/validation/hibernate/safe-html/completed";

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public ModelAndView preparePost(ModelAndView mav) {
		logger.debug("preparePost");
		mav.setViewName(FORM_VIEW_NAME);
		mav.addObject("htmlContents1Dto", new HtmlContents1Dto());
		mav.addObject("htmlContents2Dto", new HtmlContents2Dto());
		mav.addObject("htmlContents3Dto", new HtmlContents3Dto());
		return mav;
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String performPost(@Valid HtmlContents1Dto htmlContents1Dto, @Valid HtmlContents2Dto htmlContents2Dto, @Valid HtmlContents3Dto htmlContents3Dto,
			BindingResult result) {
		logger.debug("performPost");
		logger.debug("htmlContents1Dto: {}", htmlContents1Dto);
		logger.debug("htmlContents2Dto: {}", htmlContents2Dto);
		logger.debug("htmlContents3Dto: {}", htmlContents3Dto);
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("error: {}", error.getDefaultMessage());
			}
			return FORM_VIEW_NAME;
		} else {
			// TODO: invoke service
			return COMPLETED_VIEW_NAME;
		}
	}
}
