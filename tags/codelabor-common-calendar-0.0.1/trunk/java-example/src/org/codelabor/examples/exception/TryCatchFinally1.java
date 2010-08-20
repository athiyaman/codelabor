package org.codelabor.examples.exception;

public class TryCatchFinally1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("try");			
		} catch (Exception ex) {
			System.out.println("catch");			
		} finally {
			System.out.println("finally");
		}

	}

}
