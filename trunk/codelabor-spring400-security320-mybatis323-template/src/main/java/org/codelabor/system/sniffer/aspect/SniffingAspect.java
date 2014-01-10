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
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SniffingAspect implements Ordered {
	private Logger logger = LoggerFactory.getLogger(SniffingAspect.class);
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
	@Before("org.codelabor.system.sniffer.aspect.SystemArchitecture.businessService()")
	public void dumpArguments(JoinPoint joinPoint) {
		logger.debug("class: {}", joinPoint.getTarget().getClass().getName());
		logger.debug("method: {}", joinPoint.getSignature().getName());
		logger.debug("args: {}", Arrays.toString(joinPoint.getArgs()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	@Override
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
