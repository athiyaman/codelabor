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

package org.codelabor.system.exceptions;

import org.springframework.context.MessageSource;

/**
 * @author Shin Sangjae
 * 
 */
public class NoRollbackCommonException extends CommonException implements
		NoRollbackable {

	public NoRollbackCommonException() {
		super();

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters,
			String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, defaultMessage,
				wrappedException);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters, String defaultMessage) {
		super(messageSource, messageKey, messageParameters, defaultMessage);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters,
			Throwable wrappedException) {
		super(messageSource, messageKey, messageParameters, wrappedException);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Object[] messageParameters) {
		super(messageSource, messageKey, messageParameters);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, String defaultMessage, Throwable wrappedException) {
		super(messageSource, messageKey, defaultMessage, wrappedException);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, String defaultMessage) {
		super(messageSource, messageKey, defaultMessage);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey, Throwable wrappedException) {
		super(messageSource, messageKey, wrappedException);

	}

	public NoRollbackCommonException(MessageSource messageSource,
			String messageKey) {
		super(messageSource, messageKey);

	}

	public NoRollbackCommonException(String messageKey,
			Object[] messageParameters, Throwable wrappedException) {
		super(messageKey, messageParameters, wrappedException);

	}

	public NoRollbackCommonException(String messageKey,
			Object[] messageParameters) {
		super(messageKey, messageParameters);

	}

	public NoRollbackCommonException(String messageKey,
			Throwable wrappedException) {
		super(messageKey, wrappedException);

	}

	public NoRollbackCommonException(String messageKey) {
		super(messageKey);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3414460040784097981L;

}
