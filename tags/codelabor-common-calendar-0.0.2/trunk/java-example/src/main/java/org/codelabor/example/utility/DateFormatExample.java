package org.codelabor.example.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormatExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = DateFormat.getDateInstance();
		((SimpleDateFormat) dateFormat).applyPattern("yyyy-MM-dd HH:mm:ss");
		String dateString = dateFormat.format(calendar.getTime());
		System.out.println(dateString);
	}

}
