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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author Shin Sang-jae
 * 
 */
public abstract class AbstractPatternReplacer implements PatternReplacer, InitializingBean {

	/**
	 * 제외할 패턴 List (String 타입)
	 */
	protected List<String> excludesPatternList;
	/**
	 * 포함할 검색 및 치환 패턴 Map (String, String 타입)
	 */
	protected Map<String, String> searchAndReplacePatternMap;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.PatternReplacer#replace(java.lang
	 * .String)
	 */
	public abstract String replace(String targetString);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.PatternReplacer#replace(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	public abstract String replace(String searchPattern, String replacePattern, String targetString);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.PatternReplacer#replace(java.util
	 * .Map, java.lang.String)
	 */
	public abstract String replace(Map<String, String> patternMap, String targetString);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.PatternReplacer#replace(java.util
	 * .Map, java.util.List, java.lang.String)
	 */
	public abstract String replace(Map<String, String> includesPatternMap, List<String> excludesPatternMap, String targetString);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		if (searchAndReplacePatternMap == null) {
			searchAndReplacePatternMap = new HashMap<String, String>();
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
	 * 포함할 검색 및 치환 패턴 Map을 가져온다.
	 * 
	 * @return 검색 및 치환 패턴 Map
	 */
	public Map<String, String> getSearchAndReplacePatternMap() {
		return searchAndReplacePatternMap;
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
	 * 포함할 검색 및 치환 패턴 Map을 설정한다.
	 * 
	 * @param searchAndReplacePatternMap
	 *            검색 및 치환 패턴 Map
	 */
	public void setSearchAndReplacePatternMap(Map<String, String> searchAndReplacePatternMap) {
		this.searchAndReplacePatternMap = searchAndReplacePatternMap;
	}

}
