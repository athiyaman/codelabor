package org.codelabor.javaprogramming.homework.exam10;

public class AClient implements TimeClient {

	public void setDate(int day, int month, int year) {
		System.out.println("클라이언트의 시간을 "+year+"년 "+month+"월 "+day+"일로 설정합니다.");
	}

	public void setDateAndTime(int day, int month, int year, int hour,	int minute, int second) {
		this.setDate(day, month, year);
		this.setTime(hour, minute, second);
	}

	public void setTime(int hour, int minute, int second) {
		System.out.println("클라이언트의 시간을 "+hour+"시 "+minute+"분 "+second+"초로 설정합니다.");
	}

}
