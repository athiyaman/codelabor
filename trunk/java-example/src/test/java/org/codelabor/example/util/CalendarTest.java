package org.codelabor.example.util;

import java.util.Calendar;
import java.util.Locale;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalendarTest extends TestCase {

	Logger logger = LoggerFactory.getLogger(CalendarTest.class);

	public void testGet() {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.DATE, 5);

		int calendarDate1 = calendar1.get(Calendar.DATE);
		int calendarDate2 = calendar2.get(Calendar.DATE);

		int diff = calendarDate2 - calendarDate1;

		logger.debug("calendar1: {}", calendar1);
		logger.debug("calendar2: {}", calendar2);
		logger.debug("diff: {}", diff);

		Assert.assertEquals(5, diff);

	}

	public void testGetDisplayName() {
		Calendar calendar = Calendar.getInstance();
		String displayName = null;
		displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);
		logger.debug("displayName: {}", displayName);

		displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.ENGLISH);
		logger.debug("displayName: {}", displayName);

		displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.KOREAN);
		logger.debug("displayName: {}", displayName);

		displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.KOREAN);
		logger.debug("displayName: {}", displayName);
	}

}

