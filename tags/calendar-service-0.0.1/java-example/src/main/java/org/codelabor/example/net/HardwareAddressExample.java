package org.codelabor.example.net;

import java.net.InetAddress;
import java.net.NetworkInterface;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HardwareAddressExample {

	static final Logger logger = LoggerFactory
			.getLogger(HardwareAddressExample.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();

			NetworkInterface networkInterface = NetworkInterface
					.getByInetAddress(inetAddress);

			byte[] hardwareAddress = networkInterface.getHardwareAddress();
			StringBuilder sb = new StringBuilder();
			if (hardwareAddress != null) {

				String delimiter = "";
				for (byte b : hardwareAddress) {
					sb.append(delimiter);
					delimiter = "-";
					sb.append(String.format("%02X", b));
				}
			}
			logger.info("mac: {}", sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.equals(ExceptionUtils.getStackTrace(e));
		}

	}
}
