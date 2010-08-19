package org.codelabor.examples.exception;

public class TryCatchFinally3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("try");
			throw new Exception("some exception");
		} catch (Exception ex) {
			System.out.println("catch");
			ex.printStackTrace();
		} finally {
			System.out.println("finally");
		}
	}

}
