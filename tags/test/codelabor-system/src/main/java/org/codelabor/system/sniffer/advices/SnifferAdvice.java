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

package org.codelabor.system.sniffer.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.codelabor.system.advices.BaseAdvice;
import org.codelabor.system.exceptions.CommonException;
import org.springframework.core.Ordered;
import org.springframework.util.StopWatch;

import anyframe.common.exception.BaseException;
import anyframe.common.exception.message.Message;

/**
 * @author Sang Jae Shin
 * 
 */
public class SnifferAdvice extends BaseAdvice implements Ordered {
	protected int order;

	public SnifferAdvice() {
	}

	public void dumpArguments(JoinPoint joinPoint) {
		if (log.isDebugEnabled()) {
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName() + "()";

			Object[] args = joinPoint.getArgs();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("class: ").append(className);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("method: ").append(methodName);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("args: ");
			for (int i = 0; i < args.length; i++) {
				stringBuilder.append(args[i]);
				if (i != (args.length - 1)) {
					stringBuilder.append(", ");
				}
			}
			log.debug(stringBuilder.toString());
		}
	}

	public void dumpReturn(JoinPoint joinPoint, Object returnObject) {
		if (log.isDebugEnabled()) {
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName() + "()";

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("class: ").append(className);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("method: ").append(methodName);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("return: ");
			stringBuilder.append(returnObject);

			log.debug(stringBuilder.toString());
		}
	}

	public void dumpException(JoinPoint joinPoint, Exception exception) {
		if (log.isErrorEnabled()) {
			StringBuilder stringBuilder = new StringBuilder();
			String messageCode = null;
			String messageKey = null;
			String userMessage = null;
			String reason = null;
			String solution = null;
			Throwable cause = exception.getCause();

			if (exception instanceof BaseException) {
				BaseException baseException = (BaseException) exception;
				Message message = baseException.getMessages();
				messageKey = message.getMessageKey();
				userMessage = message.getUserMessage();
				reason = message.getReason();
				solution = message.getSolution();
				if (exception instanceof CommonException) {
					CommonException commonException = (CommonException) exception;
					messageCode = commonException.getMessageCode();
				}
			} else {
				userMessage = exception.getMessage();
			}

			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName() + "()";
			// SourceLocation sourceLocation = joinPoint.getSourceLocation();
			// String fileName = sourceLocation.getFileName();
			// int line = sourceLocation.getLine();

			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("-----------------------");
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("class: ").append(className);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("method: ").append(methodName);
			stringBuilder.append(System.getProperty("line.separator"));
			// stringBuilder.append("file: ").append(fileName);
			// stringBuilder.append(System.getProperty("line.separator"));
			// stringBuilder.append("line: ").append(line);
			// stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("exception class: ").append(
					exception.getClass());
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("message code: ").append(messageCode);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("message key: ").append(messageKey);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("user message: ").append(userMessage);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("reason: ").append(reason);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("solution: ").append(solution);
			stringBuilder.append(System.getProperty("line.separator"));

			if (cause != null) {
				StackTraceElement stackTraceElement = cause.getStackTrace()[0];
				stringBuilder.append("cause class: ").append(
						stackTraceElement.getClassName());
				stringBuilder.append(System.getProperty("line.separator"));
				stringBuilder.append("cause method: ").append(
						stackTraceElement.getMethodName());
				stringBuilder.append(System.getProperty("line.separator"));
				stringBuilder.append("cause file: ").append(
						stackTraceElement.getFileName());
				stringBuilder.append(System.getProperty("line.separator"));
				stringBuilder.append("cause line: ").append(
						stackTraceElement.getLineNumber());
				stringBuilder.append(System.getProperty("line.separator"));
			}

			stringBuilder.append("-----------------------");
			stringBuilder.append(System.getProperty("line.separator"));

			log.error(stringBuilder.toString());
		}
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Object getElapsedTime(ProceedingJoinPoint joinPoint)
			throws Throwable {
		Object returnValue = null;
		if (log.isDebugEnabled()) {
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName() + "()";

			StopWatch stopWatch = new StopWatch(getClass().getName());
			stopWatch.start(joinPoint.toShortString());
			returnValue = joinPoint.proceed();
			stopWatch.stop();

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("class: ").append(className);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("method: ").append(methodName);
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("total time (millis): ").append(
					stopWatch.getTotalTimeMillis());

			log.debug(stringBuilder.toString());
		}
		return returnValue;
	}
}
