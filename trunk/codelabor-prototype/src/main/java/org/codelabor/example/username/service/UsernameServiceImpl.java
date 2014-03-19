package org.codelabor.example.username.service;

import org.codelabor.example.username.dto.RegistrationFormDto;
import org.codelabor.example.username.manager.UsernameManager;
import org.codelabor.system.security.core.context.SecurityContextHolderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsernameServiceImpl implements UsernameService {

	private static final Logger logger = LoggerFactory
			.getLogger(UsernameServiceImpl.class);
	@Autowired
	private UsernameManager usernameManager;

	@Override
	public int registration(RegistrationFormDto registrationFormDto) {
		String username = SecurityContextHolderUtils.getUsername();
		logger.debug("username: {}", username);
		return usernameManager.insertRegistrationForm(registrationFormDto);
	}
}
