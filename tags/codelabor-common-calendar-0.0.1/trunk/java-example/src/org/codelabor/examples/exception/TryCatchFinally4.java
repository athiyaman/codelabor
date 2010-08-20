package org.codelabor.examples.exception;

public class TryCatchFinally4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("try");
			throw new IllegalArgumentException("some exception");
		} catch (IllegalArgumentException ex) {
			System.out.println("catch IllegalArgumentExcption");
			ex.printStackTrace();			
		} catch (Exception ex) {
			System.out.println("catch Exception");
			ex.printStackTrace();
		} finally {
			System.out.println("finally");
		}

	}

}
