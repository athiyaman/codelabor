package org.codelabor.example.username.dao.mybatis;

import org.codelabor.example.username.dao.UsernameDao;
import org.codelabor.example.username.dto.RegistrationFormDto;
import org.codelabor.system.security.core.context.SecurityContextHolderUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MyBatisUsernameDaoImpl implements UsernameDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private MessageSource messageSource;

	private static final Logger logger = LoggerFactory
			.getLogger(MyBatisUsernameDaoImpl.class);

	@Override
	public int insertRegistrationForm(RegistrationFormDto registrationFormDto) {
		String username = SecurityContextHolderUtils.getUsername();
		logger.debug("username: {}", username);

		String message = messageSource.getMessage("success.create.completed",
				null, LocaleContextHolder.getLocale());
		logger.debug(message);
		return 1;
	}
}
