package org.codelabor.example.validation.dao.mybatis;

import org.codelabor.example.validation.dao.PersonDao;
import org.codelabor.example.validation.dto.PersonDto;
import org.jasypt.util.text.TextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisPersonDao implements PersonDao {

	private static final Logger logger = LoggerFactory
			.getLogger(MyBatisPersonDao.class);

	@Autowired
	private TextEncryptor textEncryptor;

	@Override
	public int insertPerson(PersonDto personDto) {
		logger.debug("insertPerson");
		String email = personDto.getEmail();
		String encryptedEmail = textEncryptor.encrypt(email);
		logger.debug("email: {}, encryptedEmail: {}", email, encryptedEmail);

		// TODO Auto-generated method stub
		return 0;
	}

}
