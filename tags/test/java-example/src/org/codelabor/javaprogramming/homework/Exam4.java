package org.codelabor.javaprogramming.homework;

public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] charArray = new char[][] {
				{'*'}, 
				{'*', '*'}, 
				{'*', '*', '*'}, 
				{'*', '*', '*', '*'}, 
				{'*', '*', '*', '*', '*'}, 
				{'*', '*', '*', '*', '*', '*'},
				{'*', '*', '*', '*', '*', '*', '*'}, 
				{'*', '*', '*', '*', '*', '*', '*', '*'},
				{'*', '*', '*', '*', '*', '*', '*', '*', '*'}, 
				{'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}
		};
		
		for (int k=0; k<charArray.length; k++) {
			for (int l=0; l<charArray[k].length; l++) {
				System.out.print(charArray[k][l]);
			}
			System.out.println();
		}

	}

}
