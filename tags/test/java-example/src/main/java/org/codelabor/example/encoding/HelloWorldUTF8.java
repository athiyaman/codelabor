package org.codelabor.example.encoding;

import java.io.UnsupportedEncodingException;

public class HelloWorldUTF8 {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws Exception {
		String greeting = "1234ABCD안녕하세요?";
		System.out.print("DATA: ");
		System.out.println(greeting);
		byte[] bytes = greeting.getBytes();
		System.out.print("UTF-8 : ");
		for (int i = 0; i < bytes.length; i++) {
			System.out.format("%02X", bytes[i]);
		}
		System.out.println();
		bytes = greeting.getBytes("EUC-KR");
		System.out.print("EUC-KR: ");
		for (int i = 0; i < bytes.length; i++) {
			System.out.format("%02X", bytes[i]);
		}
	}
}
