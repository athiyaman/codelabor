package org.codelabor.example.util.arrays;

import java.util.Arrays;

public class ArraysExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = new String("1298klaslk78#9baa;sdf");
		
		System.out.println("[fill]");
		StringBuilder stringBuilder = new StringBuilder();
		char[] charArray = string.toCharArray(); 
		stringBuilder.append("before: ").append(charArray);
		stringBuilder.append(System.getProperty("line.separator"));
		Arrays.fill(charArray, 3, 8, '0');
		stringBuilder.append("after: ").append(charArray);
		System.out.println(stringBuilder);
		
		System.out.println("[sort]");
		stringBuilder = new StringBuilder();
		byte[] byteArray = string.getBytes();
		stringBuilder.append("before: ").append(new String(byteArray));
		stringBuilder.append(System.getProperty("line.separator"));
		Arrays.sort(byteArray);
		stringBuilder.append("after: ").append(new String(byteArray));
		System.out.println(stringBuilder);
	}
}
