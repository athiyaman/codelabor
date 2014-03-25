package org.codelabor.example.util.calendar;

import java.util.Calendar;

public class CalendarExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("calendar: ").append(calendar);
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append(System.getProperty("line.separator"));
		
		stringBuffer.append("calendar.get(Calendar.YEAR): ").append(calendar.get(Calendar.YEAR));
		stringBuffer.append(System.getProperty("line.separator"));		
		stringBuffer.append("calendar.get(Calendar.MONTH): ").append(calendar.get(Calendar.MONTH));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.DATE): ").append(calendar.get(Calendar.DATE));
		stringBuffer.append(System.getProperty("line.separator"));		
		stringBuffer.append("calendar.get(Calendar.HOUR): ").append(calendar.get(Calendar.HOUR));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.MINUTE): ").append(calendar.get(Calendar.MINUTE));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.SECOND): ").append(calendar.get(Calendar.SECOND));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.MILLISECOND): ").append(calendar.get(Calendar.MILLISECOND));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append(System.getProperty("line.separator"));
		
		stringBuffer.append("calendar.get(Calendar.AM): ").append(calendar.get(Calendar.AM));
		stringBuffer.append(System.getProperty("line.separator"));		
		stringBuffer.append("calendar.get(Calendar.PM): ").append(calendar.get(Calendar.PM));
		stringBuffer.append(System.getProperty("line.separator"));		
		stringBuffer.append("calendar.get(Calendar.AM_PM): ").append(calendar.get(Calendar.AM_PM));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append(System.getProperty("line.separator"));
		
		stringBuffer.append("calendar.get(Calendar.ZONE_OFFSET): ").append(calendar.get(Calendar.ZONE_OFFSET));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.DST_OFFSET): ").append(calendar.get(Calendar.DST_OFFSET));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.ERA): ").append(calendar.get(Calendar.ERA));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.UNDECIMBER): ").append(calendar.get(Calendar.UNDECIMBER));
		stringBuffer.append(System.getProperty("line.separator"));		
		stringBuffer.append(System.getProperty("line.separator"));
		
		stringBuffer.append("calendar.get(Calendar.WEEK_OF_YEAR): ").append(calendar.get(Calendar.WEEK_OF_YEAR));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.WEEK_OF_MONTH): ").append(calendar.get(Calendar.WEEK_OF_MONTH));
		stringBuffer.append(System.getProperty("line.separator"));		
		stringBuffer.append("calendar.get(Calendar.DAY_OF_YEAR): ").append(calendar.get(Calendar.DAY_OF_YEAR));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.DAY_OF_MONTH): ").append(calendar.get(Calendar.DAY_OF_MONTH));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.DAY_OF_WEEK): ").append(calendar.get(Calendar.DAY_OF_WEEK));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH): ").append(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		stringBuffer.append(System.getProperty("line.separator"));
		stringBuffer.append("calendar.get(Calendar.HOUR_OF_DAY): ").append(calendar.get(Calendar.HOUR_OF_DAY));
		stringBuffer.append(System.getProperty("line.separator"));
	
		System.out.println(stringBuffer);

	}

}
