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

package org.codelabor.system.sniffer.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.codelabor.system.advices.BaseAdvice;
import org.codelabor.system.anyframe.exceptions.CommonException;
import org.springframework.core.Ordered;
import org.springframework.util.StopWatch;

import anyframe.common.exception.BaseException;
import anyframe.common.exception.message.Message;

/**
 * 스니핑 어드바이스 구현 클래스ㅣ
 * 
 * @author Shin Sangjae
 * 
 */
public class SniffingAdvice extends BaseAdvice implements Ordered {
	/**
	 * 순서
	 */
	protected int order;

	/**
	 * 생성자
	 */
	public SniffingAdvice() {
	}

	/**
	 * 아규먼트를 출력한다.
	 * 
	 * @param joinPoint
	 *            조인 포인트
	 */
	public void dumpArguments(JoinPoint joinPoint) {
		logger.debug("class: {}", joinPoint.getTarget().getClass().getName());
		logger.debug("method: {}", joinPoint.getSignature().getName());
		logger.debug("args: {}", Arrays.toString(joinPoint.getArgs()));
	}

	/**
	 * 리턴 값을 출력한다.
	 * 
	 * @param joinPoint
	 *            조인 포인트
	 * @param returnObject
	 *            리턴 값
	 */
	public void dumpReturn(JoinPoint joinPoint, Object returnObject) {
		logger.debug("class: {}", joinPoint.getTarget().getClass().getName());
		logger.debug("method: {}", joinPoint.getSignature().getName());
		logger.debug("return: {}", returnObject);
	}

	/**
	 * 예외를 출력한다.
	 * 
	 * @param joinPoint
	 *            조인 포인트
	 * @param exception
	 *            예외
	 */
	public void dumpException(JoinPoint joinPoint, Exception exception) {
		if (logger.isErrorEnabled()) {
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

			// SourceLocation sourceLocation = joinPoint.getSourceLocation();
			// String fileName = sourceLocation.getFileName();
			// int line = sourceLocation.getLine();

			logger.debug("class: {}", joinPoint.getTarget().getClass()
					.getName());
			logger.debug("method: {}", joinPoint.getSignature().getName());
			logger.error("exception class: {}", exception.getClass());
			logger.error("message code: {}", messageCode);
			logger.error("message key: {}", messageKey);
			logger.error("user message: {}", userMessage);
			logger.error("reason: {}", reason);
			logger.error("solution: {}", solution);

			if (cause != null) {
				StackTraceElement stackTraceElement = cause.getStackTrace()[0];
				logger.error("cause class: {}",
						stackTraceElement.getClassName());
				logger.error("cause method: {}",
						stackTraceElement.getMethodName());
				logger.error("cause file: {}", stackTraceElement.getFileName());
				logger.error("cause line: {}",
						stackTraceElement.getLineNumber());
			}
		}
	}

	/**
	 * 경과 시간을 가져온다.
	 * 
	 * @param joinPoint
	 *            조인 포인트
	 * @return 경고 시간
	 * @throws Throwable
	 *             예외
	 */
	public Object dumpElapsedTime(ProceedingJoinPoint joinPoint)
			throws Throwable {
		Object retrunValue = null;
		StopWatch stopWatch = null;
		if (logger.isDebugEnabled()) {
			stopWatch = new StopWatch(getClass().getName());
			stopWatch.start(joinPoint.toShortString());
		}
		retrunValue = joinPoint.proceed();
		if (logger.isDebugEnabled()) {
			stopWatch.stop();
			long totalTimeMillis = stopWatch.getTotalTimeMillis();

			logger.debug("class: {}", joinPoint.getTarget().getClass()
					.getName());
			logger.debug("method: {}", joinPoint.getSignature().getName());
			logger.debug("total time (millis): {}", totalTimeMillis);
		}
		return retrunValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	public int getOrder() {
		return this.order;
	}

	/**
	 * 순서를 설정한다.
	 * 
	 * @param order
	 *            순서
	 */
	public void setOrder(int order) {
		this.order = order;
	}
}
