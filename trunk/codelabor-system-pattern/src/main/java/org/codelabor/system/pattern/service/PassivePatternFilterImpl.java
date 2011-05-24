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
package org.codelabor.system.pattern.service;

import org.codelabor.system.pattern.exception.PatternMatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 패시브 패턴 필터 구현 클래스<br/>
 * 수동적인 패턴 필터링을 수행한다. 검색 대상 패턴에 해당될 경우, 예외를 발생 시킨다.
 * 
 * @author Shin Sang-jae
 * 
 */
public class PassivePatternFilterImpl implements PatternFilter {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory.getLogger(PassivePatternFilterImpl.class);

	/**
	 * 패턴 리플레이서
	 */
	private PatternMatcher patternMatcher = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.PatternFilter#filter(java.lang.String
	 * )
	 */
	public String filter(String inputString) {
		if (patternMatcher.matches(inputString)) {
			StringBuilder sb = new StringBuilder();
			sb.append("Pattern is detected: ").append(inputString);
			logger.error(sb.toString());
			throw new PatternMatchException(sb.toString());
		} else {
			logger.debug("inputString: {}, outputString: {}", inputString, inputString);
			return inputString;
		}
	}

	/**
	 * 패턴 매처를 가져온다.
	 * 
	 * @return 패턴 매처
	 */
	public PatternMatcher getPatternMatcher() {
		return patternMatcher;
	}

	/**
	 * 패턴 매처를 설정한다.
	 * 
	 * @param patternMatcher
	 *            패턴 매처
	 */
	public void setPatternMatcher(PatternMatcher patternMatcher) {
		this.patternMatcher = patternMatcher;
	}

}
