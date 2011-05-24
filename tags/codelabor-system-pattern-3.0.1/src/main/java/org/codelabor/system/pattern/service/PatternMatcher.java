/*
 * Licensed to the Apache Software Foundation (import java.util.List;
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

import java.util.List;

/**
 * Regex 패턴 매처 인터페이스
 * 
 * @author Shin Sang-jae
 * 
 */
public interface PatternMatcher {
	/**
	 * 패턴 일치 여부를 확인한다.<br/>
	 * 내장된 규칙에 따라 패턴 일치 여부를 확인한다.
	 * 
	 * @param inputString
	 *            확인 대상 문자열
	 * @return 패턴 일치 여부
	 */
	public boolean maches(String inputString);

	/**
	 * 패턴 일치 여부를 확인한다.<br/>
	 * 
	 * @param pattern
	 *            패턴
	 * @param inputString
	 *            확인 대상 문자열
	 * @return 패턴 일치 여부
	 */
	public boolean maches(String pattern, String inputString);

	/**
	 * 패턴 일치 여부를 확인한다.
	 * 
	 * @param patternList
	 *            패턴 List
	 * @param inputString
	 *            확인 대상 문자열
	 * @return 패턴 일치 여부
	 */
	public boolean maches(List<String> patternList, String inputString);

	/**
	 * 패턴 일치 여부를 확인한다.
	 * 
	 * @param includesPatternList
	 *            포함할 패턴 List
	 * @param excludesPatternList
	 *            제외할 패턴 List
	 * @param inputString
	 *            확인 대상 문자열
	 * @return 패턴 일치 여부
	 */
	public boolean maches(List<String> includesPatternList, List<String> excludesPatternList, String inputString);
}
