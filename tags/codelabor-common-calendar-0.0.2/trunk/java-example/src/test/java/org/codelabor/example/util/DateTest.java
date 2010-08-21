package org.codelabor.example.util;

import java.util.Calendar;
import java.util.Date;

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

}
