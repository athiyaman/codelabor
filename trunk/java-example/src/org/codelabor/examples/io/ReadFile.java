package org.codelabor.examples.io;

import java.io.FileInputStream;

public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size;
		try {
			FileInputStream fis = new FileInputStream(args[0]);
			while ((size = fis.available()) > 0) {
				
				byte[] tempBytes = new byte[size];
				int result = fis.read(tempBytes);
				if (result == -1) break;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
