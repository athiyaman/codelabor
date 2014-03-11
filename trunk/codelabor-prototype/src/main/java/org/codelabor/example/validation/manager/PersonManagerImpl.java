package org.codelabor.example.validation.manager;

import org.codelabor.example.validation.dao.PersonDao;
import org.codelabor.example.validation.dto.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonManagerImpl implements PersonManager {

	private static final Logger logger = LoggerFactory
			.getLogger(PersonManagerImpl.class);

	@Autowired
	private PersonDao personDao;

	@Override
	public int registrationPerson(PersonDto personDto) {
		logger.debug("registrationPerson");
		return personDao.insertPerson(personDto);
	}

}
