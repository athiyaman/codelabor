package org.codelabor.example.security.xss.web.controller;

import org.codelabor.example.security.xss.dto.ParameterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/xss/springframework/taglib/parameter/spring-form")
public class ParameterController {

	Logger logger = LoggerFactory.getLogger(ParameterController.class);

	@RequestMapping(value = "prepare", method = RequestMethod.GET)
	public ModelAndView prepareForm() {
		logger.debug("prepareForm");
		ModelAndView mav = new ModelAndView();
		mav.addObject("parameterDto", new ParameterDto());
		mav.setViewName("security/xss/springframework/taglib/parameter/spring-form/form");
		return null;
	}

	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public ModelAndView submitForm() {
		logger.debug("submitForm");
		return null;
	}
}
