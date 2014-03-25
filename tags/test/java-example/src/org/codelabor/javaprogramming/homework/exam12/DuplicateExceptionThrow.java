package org.codelabor.javaprogramming.homework.exam12;

public class DuplicateExceptionThrow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// init array
		String[] strArray = new String[5];
		strArray[0] = "java";
		strArray[1] = "exception";
		strArray[2] = "throw";
		strArray[3] = "throws";
		
		// get user input
		String userInput = args[0];
		
		try {
			for (int i=0; i<strArray.length; i++) {
				if (strArray[i].equals(userInput)) 
					throw new DuplicationException(userInput+" 는 중복된 데이터입니다.");
			}
		} catch (DuplicationException e) {
			System.out.println(e.getClass()+": "+e.getMessage());
		}
	}
}
