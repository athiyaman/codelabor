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

package org.codelabor.system.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date 유틸리티 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class DateUtils {
	/**
	 * 로거
	 */
	final static Logger logger = LoggerFactory.getLogger(DateUtils.class);

	/**
	 * 해당 연, 월에 대한 최대 일 수를 가져온다.
	 * 
	 * @param year
	 *            연
	 * @param month
	 *            월
	 * @return 최대 일 수
	 */
	static public int getDays(int year, int month) {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, 1);
		boolean isLeapYear = calendar.isLeapYear(year);
		int lastDate = calendar.getActualMaximum(Calendar.DATE);

		logger.debug("calendar.getTime(): {}", calendar.getTime());
		logger.debug("isLeapYear: {}", isLeapYear);
		logger.debug("lastDate: {}", lastDate);
		return lastDate;
	}
}
