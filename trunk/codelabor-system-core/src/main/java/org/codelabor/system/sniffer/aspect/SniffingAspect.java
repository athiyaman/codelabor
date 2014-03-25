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

package org.codelabor.system.sniffer.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class SniffingAspect implements Ordered {
	private static final Logger logger = LoggerFactory
			.getLogger(SniffingAspect.class);
	/**
	 * 순서
	 */
	protected int order;

	/**
	 * 아규먼트를 출력한다.
	 *
	 * @param joinPoint
	 *            조인 포인트
	 */
	public void dumpArguments(JoinPoint joinPoint) {
		logger.info("target: {}", joinPoint.getTarget().getClass().getName());
		logger.info("signature: {}", joinPoint.getSignature().getName());
		logger.info("args: {}", Arrays.toString(joinPoint.getArgs()));
	}

	/**
	 * 소요 시간을 info 레벨의 로그로 기록한다.
	 *
	 * @param joinPoint
	 *            조인 포인트
	 * @throws Throwable
	 *             예외
	 */
	public void dumpElapsedTime(ProceedingJoinPoint joinPoint) throws Throwable {

		if (logger.isInfoEnabled()) {
			StopWatch stopWatch = new StopWatch(getClass().getName());
			stopWatch.start(joinPoint.toShortString());
			joinPoint.proceed();
			stopWatch.stop();
			long totalTimeMillis = stopWatch.getTotalTimeMillis();
			logger.info("target: {}", joinPoint.getTarget().getClass()
					.getName());
			logger.info("signature: {}", joinPoint.getSignature().getName());
			logger.info("total time millis: {}", totalTimeMillis);
		}
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
			String message = exception.getMessage();
			SourceLocation sourceLocation = joinPoint.getSourceLocation();
			logger.debug("sourceLocation: {}", sourceLocation);

			// UnsupportedOperationException occurs.
			// String fileName = sourceLocation.getFileName();
			// int line = sourceLocation.getLine();

			logger.error("target: {}", joinPoint.getTarget().getClass()
					.getName());
			logger.error("signature: {}", joinPoint.getSignature().getName());
			// logger.debug("file name: {}, line: {}", fileName, line);
			logger.error("exception class: {}", exception.getClass().toString());
			logger.error("exception message: {}", message);
			logger.error("cause: {}", exception.getCause());
			StackTraceElement[] stackTraceElements = exception.getStackTrace();
			logger.error("stack trace:");
			int i = 0;
			for (StackTraceElement stackTraceElement : stackTraceElements) {
				logger.error("{} {}", i++, stackTraceElement);
				/*
				 * logger.error("index: {}", i++); logger.error("class: {}",
				 * stackTraceElement.getClassName()); logger.error("method: {}",
				 * stackTraceElement.getMethodName());
				 * logger.error("is native method: {}",
				 * stackTraceElement.isNativeMethod());
				 * logger.error("file name: {}, line: {}",
				 * stackTraceElement.getFileName(),
				 * stackTraceElement.getLineNumber());
				 */
			}
		}
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
		logger.info("target: {}", joinPoint.getTarget().getClass().getName());
		logger.info("signature: {}", joinPoint.getSignature().getName());
		logger.info("return: {}", returnObject);
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
