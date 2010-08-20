package org.codelabor.example.io;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class ReadFileFromURL {

	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		int size;

		try {
			String resourceAddress = "http://www.sun.com/images/l2/l2_java-ee6.gif";
			URL url = new URL(resourceAddress);
			String hostAddress = url.getHost();
			Socket socket = new Socket(hostAddress, 80);
			InputStream inputStream = socket.getInputStream();
			while ((size = inputStream.available()) > 0) {

				byte[] tempBytes = new byte[size];
				int result = inputStream.read(tempBytes);
				if (result == -1)
					break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
