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

package org.codelabor.system.file.strategies;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import anyframe.common.util.StringUtil;
import anyframe.core.idgen.IdGenerationStrategy;

/**
 * @author Shin Sangjae
 * 
 */
public class UniqueFileNameStrategy implements IdGenerationStrategy {

	protected String prefix;

	protected int cipers;

	protected String dateAndTimePattern;

	protected char fillChar;

	protected String delimiter;

	public void setCipers(int cipers) {
		this.cipers = cipers;
	}

	public void setDateAndTimePattern(String dateAndTimePattern) {
		this.dateAndTimePattern = dateAndTimePattern;
	}

	public void setFillChar(char fillChar) {
		this.fillChar = fillChar;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String makeId(String originalId) {
		DateFormat dateFormat = new SimpleDateFormat(dateAndTimePattern, Locale
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

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
}
