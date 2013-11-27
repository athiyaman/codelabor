package org.codelabor.example.validation.web.controller;

import javax.validation.Valid;

import org.codelabor.example.validation.dto.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/example/validation/registration")
public class RegistrationController {

	private static Logger logger = LoggerFactory
			.getLogger(RegistrationController.class);

	@RequestMapping(value = "/registrationUser")
	public void registrationUser(@Valid PersonDto personDto) {
		logger.debug("personDto: {}", personDto);
	}
}
