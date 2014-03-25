package org.codelabor.example.security.xss.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.codelabor.example.security.xss.dto.ValidParameterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/xss/springframework/taglib/parameter/spring-form/hibernate-validator")
public class ValidParameterController {

	static final Logger logger = LoggerFactory
			.getLogger(ValidParameterController.class);
	static final String FORM_VIEW = "security/xss/springframework/taglib/parameter/spring-form/hibernate-validator/form";
	static final String COMPLETE_VIEW = "security/xss/springframework/taglib/parameter/spring-form/hibernate-validator/complete";

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView prepareForm() {
		logger.debug("prepareForm");
		ModelAndView mav = new ModelAndView();
		ValidParameterDto validParameterDto = new ValidParameterDto();
		String param1 = "<b>value1</b><script type='text/javascript'>alert('value1');</script>";
		validParameterDto.setParam1(param1);
		mav.addObject("validParameterDto", validParameterDto);
		mav.setViewName(FORM_VIEW);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submitForm(@Valid ValidParameterDto validParameterDto,
			BindingResult result) {
		logger.debug("submitForm");
		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			logger.error("hasError");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				logger.error("default message: {}", error.getDefaultMessage());
			}
			mav.setViewName(FORM_VIEW);
		} else {
			String attrib1 = validParameterDto.getParam1();
			mav.addObject("attrib1", attrib1);
			mav.setViewName(COMPLETE_VIEW);
		}
		return mav;
	}
}
