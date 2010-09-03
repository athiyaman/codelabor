package org.codelabor.example.io;

import java.io.IOException;

public class Echo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int temp;
		int count = 0;

		try {
			while ((temp = System.in.read()) != -1) {
				count++;
				System.out.print((char) temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("total bytes: " + count);

	}

}
