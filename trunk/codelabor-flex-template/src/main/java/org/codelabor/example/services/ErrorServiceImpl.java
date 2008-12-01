package org.codelabor.example.services;

import org.codelabor.example.services.ErrorService;
import org.codelabor.system.exceptions.CommonException;
import org.codelabor.system.exceptions.NoRollbackCommonException;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.codelabor.system.services.BaseServiceImpl;

public class ErrorServiceImpl extends BaseServiceImpl implements ErrorService {
	public void rollbackMethod() throws CommonException {
		try {
			@SuppressWarnings("unused")
			int someValue = 1 / 0;
		} catch (Exception e) {
			String messageId = "error.rollback";
			CommonException commonException = new RollbackCommonException(
					messageSource, messageId);
			commonException.setMessageCode("EXAMPLE-ERROR-CODE");

			// log
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("message: ").append(
					commonException.getMessage());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("key: ").append(
					commonException.getMessageKey());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("message key: ").append(
					commonException.getMessages().getMessageKey());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("user message: ").append(
					commonException.getMessages().getUserMessage());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("reson: ").append(
					commonException.getMessages().getReason());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("solution: ").append(
					commonException.getMessages().getSolution());
			stringBuilder.append(System.getProperty("line.separator"));
			log.debug(stringBuilder.toString());

			throw commonException;
		}
	}

	public void noRollbackMethod() throws CommonException {
		try {
			@SuppressWarnings("unused")
			int someValue = 1 / 0;
		} catch (Exception e) {
			String messageId = "error.norollback";
			CommonException commonException = new NoRollbackCommonException(
					messageSource, messageId);
			commonException.setMessageCode("EXAMPLE-ERROR-CODE");

			// log
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("message: ").append(
					commonException.getMessage());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("key: ").append(
					commonException.getMessageKey());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("message key: ").append(
					commonException.getMessages().getMessageKey());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("user message: ").append(
					commonException.getMessages().getUserMessage());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("reson: ").append(
					commonException.getMessages().getReason());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("solution: ").append(
					commonException.getMessages().getSolution());
			stringBuilder.append(System.getProperty("line.separator"));
			log.debug(stringBuilder.toString());

			throw commonException;
		}
	}
}
