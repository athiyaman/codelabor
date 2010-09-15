package org.codelabor.example.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HostNameExample {

	static final Logger logger = LoggerFactory.getLogger(HostNameExample.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String hostName = InetAddress.getLocalHost().getHostName();
			logger.info("hostName: {}", hostName);
			String canonicalHostName = InetAddress.getLocalHost()
					.getCanonicalHostName();
			logger.info("canonicalHostName: {}", canonicalHostName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
