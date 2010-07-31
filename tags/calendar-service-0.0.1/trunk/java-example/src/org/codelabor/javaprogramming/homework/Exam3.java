package org.codelabor.javaprogramming.homework;

public class Exam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("출력하지 않을 단을 명령행 매개변수로 입력하세요.");
			return;
		}
		
		int userInput = Integer.parseInt(args[0]);
		
		for (int i=2; i<=9; i++) {
			for (int j=2; j<=9; j++) {
				if (j == userInput) continue;
				System.out.print(j+"*"+i+"="+(j*i));
				System.out.print('\t');
			}
			System.out.println();
		}

	}

}
