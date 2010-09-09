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

package org.codelabor.commons.calendar.services;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.codelabor.commons.calendar.exceptions.DateOutOfRangeException;
import org.codelabor.commons.calendar.exceptions.NoSuchDateException;
import org.springframework.beans.factory.InitializingBean;

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
public class HolidayCalendarServiceImpl extends AbstractCalendarServiceImpl
		implements CalendarService, InitializingBean {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.common.calendar.services.CalendarService#getBusinessdayDate
	 * (java.util.Date, int, boolean)
	 */
	@Override
	public Date getBusinessdayDate(Date date, int amount,
			boolean isBaseDateIncluded) throws ParseException,
			NoSuchDateException, DateOutOfRangeException {
		Date businessdayDate = null;
		Date tempDate = date;

		if (isBaseDateIncluded) {// 기준일 포함
			if (amount == 0) { // 기준일 당일
				// no such date
			} else if (amount > 0) { // 기준일 이후
				tempDate = DateUtils.addDays(tempDate, -1);
				while (amount > 0) {
					tempDate = DateUtils.addDays(tempDate, 1);
					if (isBusinessday(tempDate)) {
						businessdayDate = tempDate;
						amount--;
					}
				}
			} else if (amount < 0) { // 기준일 이전
				tempDate = DateUtils.addDays(tempDate, 1);
				while (amount < 0) {
					tempDate = DateUtils.addDays(tempDate, -1);
					if (isBusinessday(tempDate)) {
						businessdayDate = tempDate;
						amount++;
					}
				}
			}

		} else { // 기준일 미포함
			if (amount == 0) { // 기준일 당일
				if (this.isBusinessday(tempDate)) {
					businessdayDate = tempDate;
				}
			} else if (amount > 0) { // 기준일 이후
				while (amount > 0) {
					tempDate = DateUtils.addDays(tempDate, 1);
					if (isBusinessday(tempDate)) {
						businessdayDate = tempDate;
						amount--;
					}
				}
			} else if (amount < 0) { // 기준일 이전
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
	 * org.codelabor.common.calendar.services.CalendarService#getHolidayDate
	 * (java.util.Date, int, boolean)
	 */
	@Override
	public Date getHolidayDate(Date date, int amount, boolean isBaseDateIncluded)
			throws ParseException, NoSuchDateException, DateOutOfRangeException {
		Date holidayDate = null;
		Date tempDate = date;

		if (isBaseDateIncluded) { // 기준일 포함
			if (amount == 0) { // 기준일 당일
				// no such date
			} else if (amount > 0) { // 기준일 이후
				tempDate = DateUtils.addDays(tempDate, -1);
				while (amount > 0) {
					tempDate = DateUtils.addDays(tempDate, 1);
					if (isHoliday(tempDate)) {
						holidayDate = tempDate;
						amount--;
					}
				}
			} else if (amount < 0) { // 기준일 이전
				tempDate = DateUtils.addDays(tempDate, 1);
				while (amount < 0) {
					tempDate = DateUtils.addDays(tempDate, -1);
					if (isHoliday(tempDate)) {
						holidayDate = tempDate;
						amount++;
					}
				}
			}
		} else { // 기준일 미포함
			if (amount == 0) { // 기준일 당일
				if (this.isHoliday(tempDate)) {
					holidayDate = tempDate;
				}
			} else if (amount > 0) { // 기준일 이후
				while (amount > 0) {
					tempDate = DateUtils.addDays(tempDate, 1);
					if (isHoliday(tempDate)) {
						holidayDate = tempDate;
						amount--;
					}
				}
			} else if (amount < 0) { // 기준일 이전
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
}
