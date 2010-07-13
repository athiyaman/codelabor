package org.codelabor.javaprogramming.homework;

public class Exam5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] score = new int[] {82, 45, 52, 98, 87};
		
		System.out.println("원래 순서:");
		for (int i=0; i<score.length; i++) {
			System.out.println(i+":"+score[i]);
		}
		
		for (int j=0; j<score.length-1; j++) {
			for (int k=j+1; k<score.length; k++) {
				if (score[j] < score[k]) {
					int temp = score[k];
					score[k] = score[j];
					score[j] = temp;
				} 
			}
		}
		
		System.out.println("정렬된 순서:");
		for (int l=0; l<score.length; l++) {
			System.out.println(l+":"+score[l]);
		}
	}
}
