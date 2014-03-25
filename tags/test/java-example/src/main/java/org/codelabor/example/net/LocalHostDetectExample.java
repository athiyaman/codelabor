package org.codelabor.example.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalHostDetectExample {

	static final Logger logger = LoggerFactory
			.getLogger(LocalHostDetectExample.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String hostName = InetAddress.getLocalHost().getHostName();
			logger.info("hostName: {}", hostName);

			InetAddress[] inetAddressArray = InetAddress.getAllByName(hostName);
			for (InetAddress inetAddress : inetAddressArray) {
				logger.info("hostAddress: {}", inetAddress.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
