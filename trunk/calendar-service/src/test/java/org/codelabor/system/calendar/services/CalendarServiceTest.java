package org.codelabor.system.calendar.services;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

public class CalendarServiceTest extends AbstractSingleSpringContextTests {
	private final static Logger logger = LoggerFactory
			.getLogger(CalendarServiceTest.class);
	private CalendarService calendarService;

	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext-calendarService.xml" };
	}

	public void onSetUp() throws Exception {
		this.calendarService = (CalendarService) applicationContext
				.getBean("holidayCalendarService");
	}

	public void testGetHolidayDate() {
		try {
			// test
			int amount = 10;
			Date baseDate = Calendar.getInstance().getTime();
			Date holidayDate = this.calendarService.getHolidayDate(baseDate,
					amount);
			String holidayDescription = this.calendarService
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
			int amount = 10;
			Date baseDate = Calendar.getInstance().getTime();
			Date businessdayDate = this.calendarService.getBusinessdayDate(
					baseDate, amount);
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
