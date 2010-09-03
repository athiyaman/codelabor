package org.codelabor.javaprogramming.homework;

public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("정수를 명령행 매개변수로 입력하세요.");
			return;
		}
		
		int yearOfBirth = Integer.parseInt(args[0]);
		String zondiacalSign = null;
		switch	(yearOfBirth % 12) {
		case 0:
			zondiacalSign = "원숭이";
			break;
		case 1:
			zondiacalSign = "닭";
			break;
		case 2:
			zondiacalSign = "개";
			break;
		case 3:
			zondiacalSign = "돼지";
			break;
		case 4:
			zondiacalSign = "쥐";
			break;
		case 5:
			zondiacalSign = "소";
			break;
		case 6:
			zondiacalSign = "호랑이";
			break;
		case 7:
			zondiacalSign = "토끼";
			break;
		case 8:
			zondiacalSign = "용";
			break;
		case 9:
			zondiacalSign = "뱀";
			break;
		case 10:
			zondiacalSign = "말";
			break;
		case 11:
			zondiacalSign = "양";
			break;
		}
		System.out.println(yearOfBirth+"년도에 태어난 당신은 "+zondiacalSign+"띠입니다.");
	}

}
