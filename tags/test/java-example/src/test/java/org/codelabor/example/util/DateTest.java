package org.codelabor.example.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTest extends TestCase {

	Logger logger = LoggerFactory.getLogger(DateTest.class);

	public void testCompareTo() {
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();

		calendar.add(Calendar.DATE, 5);
		Date afterFiveDaysDate = calendar.getTime();

		logger.debug("currentDate: {}", currentDate);
		logger.debug("afterFiveDaysDate: {}", afterFiveDaysDate);

		int value = currentDate.compareTo(afterFiveDaysDate);
		logger.debug("currentDate.compareTo(afterFiveDaysDate): {}", value);
		Assert.assertTrue(value < 0);

		value = afterFiveDaysDate.compareTo(currentDate);
		logger.debug("afterFiveDaysDate.compareTo(currentDate): {}", value);
		Assert.assertTrue(value > 0);
	}

	public void testDateInfo() {
		Calendar calendar = Calendar.getInstance();
		Date time = calendar.getTime();
		long timeInMillis = calendar.getTimeInMillis();
		TimeZone timeZone = calendar.getTimeZone();

		logger.debug("calendar: {}", calendar);
		logger.debug("time: {}", time);
		logger.debug("timeInMillis: {}", timeInMillis);
		logger.debug("timeZone: {}", timeZone);
	}

}
