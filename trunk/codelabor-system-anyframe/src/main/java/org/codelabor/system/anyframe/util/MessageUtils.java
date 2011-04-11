/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.system.anyframe.util;

import org.codelabor.system.anyframe.MessageType;
import org.codelabor.system.anyframe.dto.MessageDTO;
import org.codelabor.system.anyframe.exception.CommonException;

import anyframe.common.exception.BaseException;
import anyframe.common.exception.message.Message;

/**
 * 메시지 유틸
 * 
 * @author Shin Sang-jae
 * 
 */
public class MessageUtils {
	/**
	 * 예외 클래스를 메시지 DTO로 변환한다.
	 * 
	 * @param e
	 *            예외
	 * @return 메시지 DTO
	 */
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
