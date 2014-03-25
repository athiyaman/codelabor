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

package org.codelabor.system.calendar.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.codelabor.system.calendar.exceptions.DateOutOfRangeException;
import org.codelabor.system.calendar.exceptions.NoSuchDateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 주5일 근무제를 반영한 휴일, 영업일 관리 서비스
 * 
 * <p>
 * 휴일에 토요일, 일요일을 기본적으로 포함하므로, 주말을 제외한 휴일만 관리하면 된다. HolidayCalendarSerivceImpl을
 * 상속하므로 기본적인 설정은 HolidayCalendarServiceImpl의 것과 동일하다.
 * </p>
 * 
 * @author Shin Sangjae
 * @see HolidayCalendarServiceImpl
 * 
 */
public class FiveDayWorkweekCalendarServiceImpl extends
		HolidayCalendarServiceImpl {

	private final Logger logger = LoggerFactory
			.getLogger(FiveDayWorkweekCalendarServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.HolidayCalendarServiceImpl#isHoliday
	 * (java.util.Date)
	 */
	@Override
	public boolean isHoliday(Date date) throws ParseException,
			DateOutOfRangeException {
		logger.debug("date: {}", date);
		if (!this.isInRange(date)) {
			throw new DateOutOfRangeException();
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
		case Calendar.SATURDAY:
			return true;
		default:
			String dateString = dateFormat.format(date);
			return holidayMap.containsKey(dateString);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.HolidayCalendarServiceImpl#isHoliday
	 * (java.lang.String)
	 */
	@Override
	public boolean isHoliday(String dateString) throws ParseException,
			DateOutOfRangeException {
		return this.isHoliday(dateFormat.parse(dateString));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.calendar.services.HolidayCalendarServiceImpl#
	 * getHolidayDescription(java.util.Date)
	 */
	@Override
	public String getHolidayDescription(Date date) throws NoSuchDateException {
		logger.debug("date: {}", date);
		String description = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
		case Calendar.SATURDAY:
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
			description = simpleDateFormat.format(date);
			break;
		default:
			String dateString = dateFormat.format(date);
			if (holidayMap.containsKey(dateString)) {
				description = (String) holidayMap.get(dateString);
			}
			break;
		}
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.system.calendar.services.HolidayCalendarServiceImpl#
	 * getHolidayDescription(java.lang.String)
	 */
	@Override
	public String getHolidayDescription(String dateString)
			throws NoSuchDateException, ParseException {
		return this.getHolidayDescription(dateFormat.parse(dateString));
	}

}
