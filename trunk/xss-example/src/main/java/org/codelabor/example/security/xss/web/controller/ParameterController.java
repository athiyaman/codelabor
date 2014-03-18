package org.codelabor.example.security.xss.web.controller;

import org.codelabor.example.security.xss.dto.ParameterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/xss/springframework/taglib/parameter/spring-form")
public class ParameterController {

	Logger logger = LoggerFactory.getLogger(ParameterController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView prepareForm() {
		logger.debug("prepareForm");
		ModelAndView mav = new ModelAndView();
		ParameterDto parameterDto = new ParameterDto();
		String param1 = "<b>value1</b><script type='text/javascript'>alert('value1');</script>";
		parameterDto.setParam1(param1);
		mav.addObject("parameterDto", parameterDto);
		mav.setViewName("security/xss/springframework/taglib/parameter/spring-form/form");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submitForm(@RequestParam("param1") String param1) {
		logger.debug("submitForm");
		ModelAndView mav = new ModelAndView();
		String attrib1 = param1;
		mav.addObject("attrib1", attrib1);
		mav.setViewName("security/xss/springframework/taglib/parameter/spring-form/complete");
		return mav;
	}
}
