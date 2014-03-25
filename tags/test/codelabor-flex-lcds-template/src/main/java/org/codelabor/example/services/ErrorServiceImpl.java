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

package org.codelabor.example.services;

import org.codelabor.system.exceptions.CommonException;
import org.codelabor.system.exceptions.NoRollbackCommonException;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.codelabor.system.services.BaseServiceImpl;

/**
 * @author SangJae Shin
 * 
 */
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
