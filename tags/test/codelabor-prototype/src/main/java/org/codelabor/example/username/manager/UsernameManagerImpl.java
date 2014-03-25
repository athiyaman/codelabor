package org.codelabor.example.username.manager;

import org.codelabor.example.username.dao.UsernameDao;
import org.codelabor.example.username.dto.RegistrationFormDto;
import org.codelabor.system.security.core.context.SecurityContextHolderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsernameManagerImpl implements UsernameManager {

	private static final Logger logger = LoggerFactory
			.getLogger(UsernameManagerImpl.class);
	@Autowired
	private UsernameDao usernameDao;

	@Override
	public int insertRegistrationForm(RegistrationFormDto registrationFormDto) {
		String username = SecurityContextHolderUtils.getUsername();
		logger.debug("username: {}", username);
		return usernameDao.insertRegistrationForm(registrationFormDto);
	}
}
