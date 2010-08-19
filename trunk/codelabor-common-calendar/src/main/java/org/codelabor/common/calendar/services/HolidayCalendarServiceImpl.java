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

package org.codelabor.common.calendar.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.codelabor.common.calendar.exceptions.DateOutOfRangeException;
import org.codelabor.common.calendar.exceptions.NoSuchDateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * 휴일만 관리하는 휴일, 영업일 관리 서비스
 * 
 * <p>
 * 휴일만 관리하고, 그 외의 날짜는 영업일로 간주한다. 휴일 정보는 holidayMap 프로퍼티에 등록한다. holidayMap 프로퍼티에
 * 휴일 정보만 관리하고 영업일 정보는 등록하지 않는다. 휴일, 영업일 검색 범위를 지정하기 위해 dateRangeFrom,
 * dateRangeTo 프로퍼티를 사용한다. 프로퍼티에 사용되는 날짜 형식은 <a
 * href="http://www.w3.org/TR/NOTE-datetime">ISO 8601 표준</a>(YYYY-MM-DD)을 따른다.
 * (java 포맷으로는 yyyy-MM-dd으로 표현)
 * </p>
 * 
 * @author Shin Sangjae
 */
public class HolidayCalendarServiceImpl implements CalendarService,
		InitializingBean {

	private final Logger logger = LoggerFactory
			.getLogger(HolidayCalendarServiceImpl.class);

	/**
	 * 기준일 포함 여부
	 */
	protected boolean isBaseDateIncluded = false;

	/**
	 * 휴일 정보를 담고있는 Properties 타입의 프로퍼티
	 */
	protected Map<Date, String> holidayMap = null;
	/**
	 * 프로퍼티에 사용될 날짜의 문자열 포맷
	 */
	protected String formatPattern;
	/**
	 * formatPattern을 지원하는 SimpleDateFormat
	 */
	protected SimpleDateFormat dateFormat;
	/**
	 * 휴일, 영업일의 상한 범위 일자
	 */
	protected Date dateRangeTo = null;
	/**
	 * 휴일, 영업일의 하한 범위 일자
	 */
	protected Date dateRangeFrom = null;
	/**
	 * 휴일, 영업일의 상한, 하한 범위를 지정하지 않을 경우, 현재 일자 기준, 몇 년 전, 후를 상한, 하한 범위로 지정 (기본 값은
	 * 현재 날짜 기준 1년 전이 하한 범위, 1년 후가 상한 범위가 됨)
	 */
	protected int dateRangeByYears = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.CalendarService#getBusinessdayDate
	 * (java.util.Date, int)
	 */
	public Date getBusinessdayDate(Date date, int amount)
			throws ParseException, NoSuchDateException, DateOutOfRangeException {
		Date businessdayDate = null;
		Date tempDate = date;

		if (isBaseDateIncluded) {
			if (amount == 0) {
				// no such date
			} else if (amount > 0) {
				tempDate = DateUtils.addDays(tempDate, -1);
				while (amount > 0) {
					tempDate = DateUtils.addDays(tempDate, 1);
					if (isBusinessday(tempDate)) {
						businessdayDate = tempDate;
						amount--;
					}
				}
			} else if (amount < 0) {
				tempDate = DateUtils.addDays(tempDate, 1);
				while (amount < 0) {
					tempDate = DateUtils.addDays(tempDate, -1);
					if (isBusinessday(tempDate)) {
						businessdayDate = tempDate;
						amount++;
					}
				}
			}
		} else {
			if (amount == 0) {
				if (this.isBusinessday(tempDate)) {
					businessdayDate = tempDate;
				}
			} else if (amount > 0) {
				while (amount > 0) {
					tempDate = DateUtils.addDays(tempDate, 1);
					if (isBusinessday(tempDate)) {
						businessdayDate = tempDate;
						amount--;
					}
				}
			} else if (amount < 0) {
				while (amount < 0) {
					tempDate = DateUtils.addDays(tempDate, -1);
					if (isBusinessday(tempDate)) {
						businessdayDate = tempDate;
						amount++;
					}
				}
			}
		}
		if (businessdayDate == null) {
			throw new NoSuchDateException();
		}
		return businessdayDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.CalendarService#getHolidayDate
	 * (java.util.Date, int)
	 */
	public Date getHolidayDate(Date date, int amount) throws ParseException,
			NoSuchDateException, DateOutOfRangeException {
		Date holidayDate = null;
		Date tempDate = date;

		if (isBaseDateIncluded) {
			if (amount == 0) {
				// no such date
			} else if (amount > 0) {
				tempDate = DateUtils.addDays(tempDate, -1);
				while (amount > 0) {
					tempDate = DateUtils.addDays(tempDate, 1);
					if (isHoliday(tempDate)) {
						holidayDate = tempDate;
						amount--;
					}
				}
			} else if (amount < 0) {
				tempDate = DateUtils.addDays(tempDate, 1);
				while (amount < 0) {
					tempDate = DateUtils.addDays(tempDate, -1);
					if (isHoliday(tempDate)) {
						holidayDate = tempDate;
						amount++;
					}
				}
			}
		} else {
			if (amount == 0) {
				if (this.isHoliday(tempDate)) {
					holidayDate = tempDate;
				}
			} else if (amount > 0) {
				while (amount > 0) {
					tempDate = DateUtils.addDays(tempDate, 1);
					if (isHoliday(tempDate)) {
						holidayDate = tempDate;
						amount--;
					}
				}
			} else if (amount < 0) {
				while (amount < 0) {
					tempDate = DateUtils.addDays(tempDate, -1);
					if (isHoliday(tempDate)) {
						holidayDate = tempDate;
						amount++;
					}
				}
			}
		}
		if (holidayDate == null) {
			throw new NoSuchDateException();
		}
		return holidayDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.CalendarService#isBusinessday(
	 * java.lang.String)
	 */
	public boolean isBusinessday(String date) {
		return !holidayMap.containsKey(date);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.CalendarService#isBusinessday(
	 * java.util.Date)
	 */
	public boolean isBusinessday(Date date) throws ParseException,
			DateOutOfRangeException {
		return !isHoliday(date);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.CalendarService#isHoliday(java
	 * .util.Date)
	 */
	public boolean isHoliday(Date date) throws ParseException,
			DateOutOfRangeException {
		return this.isHoliday(dateFormat.format(date));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.CalendarService#isHoliday(java
	 * .lang.String)
	 */
	public boolean isHoliday(String date) throws ParseException,
			DateOutOfRangeException {
		logger.debug("date: {}", date);

		if (!this.isInRange(date)) {
			throw new DateOutOfRangeException();
		}
		return holidayMap.containsKey(date);
	}

	/**
	 * 기준일이 휴일, 영업일 관리 범위안에 있는지 확인한다.
	 * 
	 * @param date
	 *            기준일
	 * @return 관리 범위안에 들어가는지 여부
	 */
	protected boolean isInRange(Date date) {
		Assert.notNull(date);
		return ((date.equals(dateRangeFrom) || date.after(dateRangeFrom)) && (date
				.equals(dateRangeTo) || date.before(dateRangeTo)));
	}

	/**
	 * @param dateString
	 *            기준일
	 * @return 관리 범위 안에 들어가는지 여부
	 * @throws ParseException
	 */
	protected boolean isInRange(String dateString) throws ParseException {
		return isInRange(this.dateFormat.parse(dateString));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.CalendarService#getHolidayDescription
	 * (java.util.Date)
	 */
	public String getHolidayDescription(Date date) throws NoSuchDateException,
			ParseException {
		return getHolidayDescription(dateFormat.format(date));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.calendar.services.CalendarService#getHolidayDescription
	 * (java.lang.String)
	 */
	public String getHolidayDescription(String date)
			throws NoSuchDateException, ParseException {
		if (holidayMap.containsKey(date)) {
			return holidayMap.get(date);
		} else {
			throw new NoSuchDateException();
		}
	}

	/**
	 * 문자열 형태의 날짜 포맷을 지정한다.
	 * 
	 * @param formatPattern
	 *            문자열 형태의 날짜 포맷 (<a
	 *            href="http://download.oracle.com/javase/1.4.2/docs/api
	 *            /java/text/SimpleDateFormat.html">Date and Time Patterns</a>)
	 */
	public void setFormatPattern(String formatPattern) {
		this.formatPattern = formatPattern;
	}

	/**
	 * java.util.Date 타입의 휴일을 관리한다.
	 * 
	 * @param holidayMap
	 */
	public void setHolidayMap(Map<Date, String> holidayMap) {
		this.holidayMap = holidayMap;
	}

	/**
	 * 휴일, 영업일 관리의 상한 범위를 지정한다.
	 * 
	 * @param dateRangeTo
	 */
	public void setDateRangeTo(Date dateRangeTo) {
		this.dateRangeTo = dateRangeTo;
	}

	/**
	 * 휴일, 영업일 관리의 하한 범위를 지정한다.
	 * 
	 * @param dateRangeFrom
	 */
	public void setDateRangeFrom(Date dateRangeFrom) {
		this.dateRangeFrom = dateRangeFrom;
	}

	/**
	 * 휴일, 영업일 관리의 상한, 하한 범위를 현재 일 기준, 몇 년 전, 후로 지정한다. (기본 값은 1년 전, 후)
	 * 
	 * @param dateRangeByYears
	 */
	public void setDateRangeByYears(int dateRangeByYears) {
		this.dateRangeByYears = dateRangeByYears;
	}

	public void setBaseDateIncluded(boolean isBaseDateIncluded) {
		this.isBaseDateIncluded = isBaseDateIncluded;
	}

	public void afterPropertiesSet() {
		this.dateFormat = new SimpleDateFormat(formatPattern);
		Date currentDate = Calendar.getInstance().getTime();
		logger.debug("currentDate: {}", currentDate);
		if (dateRangeTo == null && dateRangeFrom == null) {
			dateRangeTo = DateUtils.addYears(currentDate, dateRangeByYears);
			dateRangeFrom = DateUtils.addYears(currentDate, -dateRangeByYears);
		}
		logger.debug("dateRangeTo: {}", dateRangeTo);
		logger.debug("dateRangeFrom: {}", dateRangeFrom);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.common.calendar.services.CalendarService#getCurrentDate()
	 */
	public Date getCurrentDate() throws Exception {
		return Calendar.getInstance().getTime();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.common.calendar.services.CalendarService#getNextBusinessdayDate
	 * (java.util.Date)
	 */
	public Date getNextBusinessdayDate(Date date) throws Exception {
		return this.getBusinessdayDate(date, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.common.calendar.services.CalendarService#getNextHolidayDate
	 * (java.util.Date)
	 */
	public Date getNextHolidayDate(Date date) throws Exception {
		return this.getHolidayDate(date, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.common.calendar.services.CalendarService#
	 * getPreviousBusinessDate(java.util.Date)
	 */
	public Date getPreviousBusinessDate(Date date) throws Exception {
		return this.getBusinessdayDate(date, -1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.common.calendar.services.CalendarService#getPreviousHolidayDate
	 * (java.util.Date)
	 */
	public Date getPreviousHolidayDate(Date date) throws Exception {
		return this.getHolidayDate(date, -1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.common.calendar.services.CalendarService#getNextBusinessdayDate
	 * ()
	 */
	public Date getNextBusinessdayDate() throws Exception {
		return this.getNextBusinessdayDate(Calendar.getInstance().getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.common.calendar.services.CalendarService#getNextHolidayDate
	 * ()
	 */
	public Date getNextHolidayDate() throws Exception {
		return this.getNextHolidayDate(Calendar.getInstance().getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.codelabor.common.calendar.services.CalendarService#
	 * getPreviousBusinessDate()
	 */
	public Date getPreviousBusinessDate() throws Exception {
		return this.getPreviousBusinessDate(Calendar.getInstance().getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.common.calendar.services.CalendarService#getPreviousHolidayDate
	 * ()
	 */
	public Date getPreviousHolidayDate() throws Exception {
		return this.getPreviousHolidayDate(Calendar.getInstance().getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.common.calendar.services.CalendarService#isBusinessday()
	 */
	public boolean isBusinessday() throws Exception {
		return this.isBusinessday(Calendar.getInstance().getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.common.calendar.services.CalendarService#isHoliday()
	 */
	public boolean isHoliday() throws Exception {
		return this.isHoliday(Calendar.getInstance().getTime());
	}
}
