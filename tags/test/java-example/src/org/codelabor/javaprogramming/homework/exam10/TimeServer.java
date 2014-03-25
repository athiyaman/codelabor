package org.codelabor.javaprogramming.homework.exam10;

public class TimeServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TimeClient tmClient = new AClient();
		int day = 1;
		int month = 1;
		int year = 2010;
		int hour = 6;
		int minute = 30;
		int second = 20;
		tmClient.setDateAndTime(day, month, year, hour, minute, second);
	}

}
