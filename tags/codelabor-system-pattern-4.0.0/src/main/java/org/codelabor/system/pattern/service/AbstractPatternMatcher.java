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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

/**
 * 패턴 매처 추상 클래스<br/>
 * 매처에 공통적으로 필요한 패턴 리스트 처리 방법을 추상화 한다.
 * 
 * @author Shin Sang-jae
 * 
 */
public abstract class AbstractPatternMatcher implements PatternMatcher, InitializingBean {

	/**
	 * 제외할 패턴 List (String 타입)
	 */
	protected List<String> excludesPatternList;
	/**
	 * 포함할 패턴 List (String 타입)
	 */
	protected List<String> includesPatternList;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.PatternMatcher#maches(java.lang.
	 * String)
	 */
	public abstract boolean matches(String inputString);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.PatternMatcher#maches(java.lang.
	 * String, java.lang.String)
	 */
	public abstract boolean matches(String pattern, String inputString);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.PatternMatcher#maches(java.util.
	 * List, java.lang.String)
	 */
	public abstract boolean matches(List<String> patternList, String inputString);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.PatternMatcher#maches(java.util.
	 * List, java.util.List, java.lang.String)
	 */
	public abstract boolean matches(List<String> includesPatternList, List<String> excludesPatternList, String inputString);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		if (includesPatternList == null) {
			includesPatternList = new ArrayList<String>();
		}
		if (excludesPatternList == null) {
			excludesPatternList = new ArrayList<String>();
		}
	}

	/**
	 * 제외할 패턴 List를 가져온다.
	 * 
	 * @return 패턴 List
	 */
	public List<String> getExcludesPatternList() {
		return excludesPatternList;
	}

	/**
	 * 포함할 패턴 List를 가져온다.
	 * 
	 * @return 패턴 List
	 */
	public List<String> getIncludesPatternList() {
		return includesPatternList;
	}

	/**
	 * 제외할 패턴 List를 설정한다.
	 * 
	 * @param excludesPatternList
	 *            패턴 List
	 */
	public void setExcludesPatternList(List<String> excludesPatternList) {
		this.excludesPatternList = excludesPatternList;
	}

	/**
	 * 포함할 패턴 List를 설정한다.
	 * 
	 * @param includesPatternList
	 *            패턴 List
	 */
	public void setIncludesPatternList(List<String> includesPatternList) {
		this.includesPatternList = includesPatternList;
	}
}
