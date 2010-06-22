package org.codelabor.system.calendar.services;

import java.util.Date;

public interface CalendarService {
	public Date getBusinessdayDate(Date date, int amount) throws Exception;

	public Date getHolidayDate(Date date, int amount) throws Exception;

	public boolean isBusinessday(Date date) throws Exception;

	public boolean isBusinessday(String date) throws Exception;

	public boolean isHoliday(Date date) throws Exception;

	public boolean isHoliday(String date) throws Exception;

	public String getHolidayDescription(Date date) throws Exception;

	public String getHolidayDescription(String date) throws Exception;
}
