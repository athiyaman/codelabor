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

import java.util.Calendar;
import java.util.Date;

import org.codelabor.commons.calendar.services.CalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

public class CalendarServiceTest extends AbstractSingleSpringContextTests {
	private final static Logger logger = LoggerFactory
			.getLogger(CalendarServiceTest.class);
	private CalendarService calendarService;

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-calendarService.xml",
				"classpath:/**/applicationContext-customEditorConfigurer.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		// this.calendarService = (CalendarService)
		// applicationContext.getBean("holidayCalendarService");
		this.calendarService = (CalendarService) applicationContext
				.getBean("fiveDayWorkweekCalendarService");
	}

	public void testGetHolidayDate() {
		try {
			// test
			int amount = 1;

			// default
			Date baseDate = Calendar.getInstance().getTime();
			Date holidayDate = this.calendarService.getHolidayDate(baseDate,
					amount);
			String holidayDescription = this.calendarService
					.getHolidayDescription(holidayDate);
			logger.debug("baseDate: {}", baseDate);
			logger.debug("amount: {}", amount);
			logger.debug("holidayDate: {}", holidayDate);
			logger.debug("holidayDescription: {}", holidayDescription);

			// base date included
			holidayDate = this.calendarService.getHolidayDate(baseDate, amount,
					true);
			holidayDescription = this.calendarService
					.getHolidayDescription(holidayDate);
			logger.debug("baseDate: {}", baseDate);
			logger.debug("amount: {}", amount);
			logger.debug("holidayDate: {}", holidayDate);
			logger.debug("holidayDescription: {}", holidayDescription);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testGetBusinessdayDate() {
		try {
			// test
			int amount = 1;

			// default
			Date baseDate = Calendar.getInstance().getTime();
			Date businessdayDate = this.calendarService.getBusinessdayDate(
					baseDate, amount);
			logger.debug("baseDate: {}", baseDate);
			logger.debug("amount: {}", amount);
			logger.debug("businessdayDate: {}", businessdayDate);

			// base date included
			baseDate = Calendar.getInstance().getTime();
			businessdayDate = this.calendarService.getBusinessdayDate(baseDate,
					amount, true);
			logger.debug("baseDate: {}", baseDate);
			logger.debug("amount: {}", amount);
			logger.debug("businessdayDate: {}", businessdayDate);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testIsBusinessdayByDate() {
		try {
			// test
			Date currentDate = Calendar.getInstance().getTime();
			boolean isBusinessday = this.calendarService
					.isBusinessday(currentDate);
			logger.debug("isBusinessday: {}", isBusinessday);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testIsBusinessdayByString() {
		try {
			// test
			boolean isBusinessday = this.calendarService
					.isBusinessday("2010-06-16");
			logger.debug("isBusinessday: {}", isBusinessday);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testIsHolidayByDate() {
		try {
			// test
			Date currentDate = Calendar.getInstance().getTime();
			boolean isHoliday = this.calendarService.isHoliday(currentDate);
			logger.debug("isHoliday: {}", isHoliday);
			if (isHoliday) {
				String holidayDescription = this.calendarService
						.getHolidayDescription(currentDate);
				logger.debug("holidayDescription: {}", holidayDescription);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testIsHolidayByString() {
		try {
			// test
			boolean isHoliday = this.calendarService.isHoliday("2010-06-16");
			logger.debug("isHoliday: {}", isHoliday);
			if (isHoliday) {
				String holidayDescription = this.calendarService
						.getHolidayDescription("2010-06-16");
				logger.debug("holidayDescription: {}", holidayDescription);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
