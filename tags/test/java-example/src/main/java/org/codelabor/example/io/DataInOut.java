package org.codelabor.example.io;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInOut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(args[0]);
			DataInputStream dis = new DataInputStream(fis);

			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readDouble());
			System.out.println(dis.readFloat());
			System.out.println(dis.readLong());
			System.out.println(dis.readShort());
			dis.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
