package org.codelabor.javaprogramming.homework;

public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("������ ����� �Ű������� �Է��ϼ���.");
			return;
		}
		
		int yearOfBirth = Integer.parseInt(args[0]);
		String zondiacalSign = null;
		switch	(yearOfBirth % 12) {
		case 0:
			zondiacalSign = "������";
			break;
		case 1:
			zondiacalSign = "��";
			break;
		case 2:
			zondiacalSign = "��";
			break;
		case 3:
			zondiacalSign = "����";
			break;
		case 4:
			zondiacalSign = "��";
			break;
		case 5:
			zondiacalSign = "��";
			break;
		case 6:
			zondiacalSign = "ȣ����";
			break;
		case 7:
			zondiacalSign = "�䳢";
			break;
		case 8:
			zondiacalSign = "��";
			break;
		case 9:
			zondiacalSign = "��";
			break;
		case 10:
			zondiacalSign = "��";
			break;
		case 11:
			zondiacalSign = "��";
			break;
		}
		System.out.println(yearOfBirth+"�⵵�� �¾ ����� "+zondiacalSign+"���Դϴ�.");
	}

}
