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

import java.util.List;
import java.util.Map;

/**
 * 패턴 리플레이서 인터페이스<br/>
 * 패턴에 일치되는 문자열을 치환한다.
 * 
 * @author Shin Sang-jae
 * 
 */
public interface PatternReplacer {
	/**
	 * 문자열을 치환한다.<br/>
	 * 내장된 규칙에 따라 문자열을 치환한다.
	 * 
	 * @param targetString
	 *            치환 대상 문자열
	 * @return 치환된 문자열
	 */
	public String replace(String targetString);

	/**
	 * 문자열을 치환한다.<br/>
	 * 검색 패턴을 찾아 치환 패턴에 해당하는 형태로 문자열을 치환한다.
	 * 
	 * @param searchPattern
	 *            검색 패턴
	 * @param replacePattern
	 *            치환 패턴
	 * @param targetString
	 *            치환 대상 문자열
	 * @return 치환된 문자열
	 */
	public String replace(String searchPattern, String replacePattern, String targetString);

	/**
	 * 문자열을 치환한다.<br/>
	 * Map의 Key에 해당하는 패턴을 찾아 Map의 Value에 해당하는 형태로 문자열을 치환한다.
	 * 
	 * @param patternMap
	 *            패턴 Map
	 * @param targetString
	 *            치환 대상 문자열
	 * @return 치환된 문자열
	 */
	public String replace(Map<String, String> patternMap, String targetString);

	/**
	 * 문자열을 치환한다.<br/>
	 * 포함할 패턴 Map의 Key에 해당하는 패턴을 찾아 Map의 Value에 해당하는 형태로 문자열을 치환한다.<br/>
	 * 단, 제외 패턴 List에 해당된다면 치환하지 않는다.
	 * 
	 * @param includesPatternMap
	 *            포함할 패턴 Map
	 * @param excludesPatternMap
	 *            제외할 패턴 List *
	 * @param targetString
	 *            치환 대상 문자열
	 * @return 치환된 문자열
	 */
	public String replace(Map<String, String> includesPatternMap, List<String> excludesPatternMap, String targetString);
}
