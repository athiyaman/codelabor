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

package org.codelabor.system.remoting.strategies;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.commons.lang.RandomStringUtils;

import anyframe.common.util.StringUtil;
import anyframe.core.idgen.IdGenerationStrategy;

/**
 * @author Sang Jae Shin
 * 
 */
public class TransactionIdStrategy implements IdGenerationStrategy {
	private String prefix;
	private String dateAndTimePattern;
	private int cipers;
	private char fillChar;

	public int getCipers() {
		return cipers;
	}

	public void setCipers(int cipers) {
		this.cipers = cipers;
	}

	public char getFillChar() {
		return fillChar;
	}

	public void setFillChar(char fillChar) {
		this.fillChar = fillChar;
	}

	public String getProcessId() {
		return RandomStringUtils.randomNumeric(8);
	}

	public String getDateAndTimePattern() {
		return dateAndTimePattern;
	}

	public void setDateAndTimePattern(String dateAndTimePattern) {
		this.dateAndTimePattern = dateAndTimePattern;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String makeId(String originalId) {
		SimpleDateFormat dateAndTimeFormat = new SimpleDateFormat(
				dateAndTimePattern, Locale.getDefault());
		String dateAndTimeString = dateAndTimeFormat.format(System
				.currentTimeMillis());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(prefix);
		stringBuilder.append(getProcessId());
		stringBuilder.append(dateAndTimeString.substring(0, 12));
		stringBuilder.append(dateAndTimeString.substring(13, 15));
		stringBuilder.append(StringUtil
				.fillString(originalId, fillChar, cipers));
		return stringBuilder.toString();
	}
}
