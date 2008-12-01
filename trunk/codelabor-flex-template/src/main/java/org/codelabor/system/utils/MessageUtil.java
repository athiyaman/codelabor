package org.codelabor.system.utils;

import anyframe.common.exception.BaseException;
import anyframe.common.exception.message.Message;
import org.codelabor.system.MessageType;
import org.codelabor.system.dtos.MessageDTO;
import org.codelabor.system.exceptions.CommonException;

public class MessageUtil {
	static public MessageDTO exceptionToMessageDTO(Exception e) {
		MessageDTO messageDTO = new MessageDTO();
		String messageCode = null;
		String messageKey = null;
		String userMessage = null;
		String reason = null;
		String solution = null;
		if (e instanceof BaseException) {
			BaseException baseException = (BaseException) e;
			Message message = baseException.getMessages();
			messageKey = message.getMessageKey();
			userMessage = message.getUserMessage();
			reason = message.getReason();
			solution = message.getSolution();
			if (e instanceof CommonException) {
				CommonException commonException = (CommonException) e;
				messageCode = commonException.getMessageCode();
			}
		} else {
			userMessage = e.getMessage();
		}
		messageDTO.setMessageCode(messageCode);
		messageDTO.setMessageKey(messageKey);
		messageDTO.setMessageType(MessageType.ERROR);
		messageDTO.setUserMessage(userMessage);
		messageDTO.setReason(reason);
		messageDTO.setSolution(solution);
		return messageDTO;
	}
}
