package org.codelabor.javaprogramming.homework.exam10;

public class AClient implements TimeClient {

	public void setDate(int day, int month, int year) {
		System.out.println("Ŭ���̾�Ʈ�� �ð��� "+year+"�� "+month+"�� "+day+"�Ϸ� �����մϴ�.");
	}

	public void setDateAndTime(int day, int month, int year, int hour,	int minute, int second) {
		this.setDate(day, month, year);
		this.setTime(hour, minute, second);
	}

	public void setTime(int hour, int minute, int second) {
		System.out.println("Ŭ���̾�Ʈ�� �ð��� "+hour+"�� "+minute+"�� "+second+"�ʷ� �����մϴ�.");
	}

}
