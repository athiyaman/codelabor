package org.codelabor.example.validation.web.controller;

import javax.validation.Valid;

import org.codelabor.example.validation.dto.PersonDto;
import org.codelabor.example.validation.manager.PersonManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/example/validation/registration")
public class RegistrationController {

	private static final Logger logger = LoggerFactory
			.getLogger(RegistrationController.class);

	@Autowired
	private PersonManager personManager;

	private final String formViewName = "example/validation/registrationForm";
	private final String completedViewName = "example/validation/registrationCompleted";

	@RequestMapping(value = "/registrationUser", method = RequestMethod.GET)
	public ModelAndView prepareRegistrationUser(ModelAndView mav) {
		logger.debug("prepareRegistrationUser");
		mav.setViewName(formViewName);
		mav.addObject("personDto", new PersonDto());
		return mav;
	}

	@RequestMapping(value = "/registrationUser", method = RequestMethod.POST)
	public String registrationUser(@Valid PersonDto personDto,
			BindingResult result) {
		logger.debug("registrationUser");
		logger.debug("personDto: {}", personDto);
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("error: {}", error.getDefaultMessage());
			}
			return formViewName;
		} else {
			personManager.registrationPerson(personDto);
			return completedViewName;
		}
	}
}
