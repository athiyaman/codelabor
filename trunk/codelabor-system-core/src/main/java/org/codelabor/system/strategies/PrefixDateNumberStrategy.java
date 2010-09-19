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

package org.codelabor.system.strategies;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import anyframe.common.util.StringUtil;
import anyframe.core.idgen.IdGenerationStrategy;

/**
 * 날짜, 숫자 조합 접두어 정책
 * 
 * @author Shin Sangjae
 * 
 */
public class PrefixDateNumberStrategy implements IdGenerationStrategy {

	/**
	 * 접두어
	 */
	protected String prefix;

	/**
	 * 구분자
	 */
	protected String delimiter;

	protected String datePattern;

	/**
	 * 채우기 문자
	 */
	protected char fillChar;

	/**
	 * 자리 수
	 */
	protected int cipers;

	/**
	 * 자리 수를 설정한다.
	 * 
	 * @param cipers
	 *            자리 수
	 */
	public void setCipers(int cipers) {
		this.cipers = cipers;
	}

	/**
	 * 날짜 패턴을 설정한다.
	 * 
	 * @param dateAndTimePattern
	 *            날짜 패턴
	 */
	public void setDatePattern(String dateAndTimePattern) {
		this.datePattern = dateAndTimePattern;
	}

	/**
	 * 채우기 글자를 설정한다.
	 * 
	 * @param fillChar
	 *            채우기 글자
	 */
	public void setFillChar(char fillChar) {
		this.fillChar = fillChar;
	}

	/**
	 * 접두어를 설정한다.
	 * 
	 * @param prefix
	 *            접두어
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * 구분자를 설정한다.
	 * 
	 * @param delimiter
	 *            구분자
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see anyframe.core.idgen.IdGenerationStrategy#makeId(java.lang.String)
	 */
	public String makeId(String originalId) {
		DateFormat dateFormat = new SimpleDateFormat(datePattern, Locale
				.getDefault());
		String dateFormatString = dateFormat.format(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		if (delimiter != null) {
			sb.append(delimiter);
		}
		sb.append(dateFormatString);
		if (delimiter != null) {
			sb.append(delimiter);
		}
		sb.append(StringUtil.fillString(originalId, fillChar, cipers));
		return sb.toString();
	}

}
