package org.codelabor.example.encoding;

public class HelloWorldEUCKR {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String greeting = "1234ABCDæ»≥Á«œººø‰?";
		System.out.print("DATA: ");
		System.out.println(greeting);
		byte[] bytes = greeting.getBytes();
		System.out.print("EUC-KR: ");
		for (int i = 0; i < bytes.length; i++) {
			System.out.format("%02X", bytes[i]);
		}
		System.out.println();
		bytes = greeting.getBytes("UTF-8");
		System.out.print("UTF-8 : ");
		for (int i = 0; i < bytes.length; i++) {
			System.out.format("%02X", bytes[i]);
		}
	}
}
