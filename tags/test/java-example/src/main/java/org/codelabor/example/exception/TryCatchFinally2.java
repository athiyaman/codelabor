package org.codelabor.example.exception;

public class TryCatchFinally2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("try");
			throw new Exception("some exception");
		} catch (Exception ex) {
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}

	}

}
