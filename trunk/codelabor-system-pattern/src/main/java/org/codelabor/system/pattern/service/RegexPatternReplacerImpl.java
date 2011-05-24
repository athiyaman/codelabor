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

import org.codelabor.system.pattern.util.SimplePatternReplaceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Regex 패턴 리플레이서 구현 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class RegexPatternReplacerImpl extends AbstractPatternReplacer {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory.getLogger(RegexPatternReplacerImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.AbstractPatternReplacer#replace(
	 * java.lang.String)
	 */
	@Override
	public String replace(String targetString) {
		logger.debug("searchAndReplacePatternMap: {}", searchAndReplacePatternMap);
		logger.debug("excludesPatternList: {}", excludesPatternList);
		logger.debug("targetString: {}", targetString);
		return SimplePatternReplaceUtils.replace(searchAndReplacePatternMap, excludesPatternList, targetString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.AbstractPatternReplacer#replace(
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String replace(String searchPattern, String replacePattern, String targetString) {
		return SimplePatternReplaceUtils.replace(searchPattern, replacePattern, targetString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.AbstractPatternReplacer#replace(
	 * java.util.Map, java.lang.String)
	 */
	@Override
	public String replace(Map<String, String> patternMap, String targetString) {
		return SimplePatternReplaceUtils.replace(patternMap, targetString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.pattern.service.AbstractPatternReplacer#replace(
	 * java.util.Map, java.util.List, java.lang.String)
	 */
	@Override
	public String replace(Map<String, String> includesPatternMap, List<String> excludesPatternMap, String targetString) {
		return SimplePatternReplaceUtils.replace(includesPatternMap, excludesPatternMap, targetString);
	}

}
