package org.codelabor.system.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetUtils {
	static final Logger logger = LoggerFactory.getLogger(NetUtils.class);

	static public boolean isLocalhost(InetAddress inetAddress)
			throws UnknownHostException {
		boolean isLocalhost = false;
		String hostName = InetAddress.getLocalHost().getHostName();
		logger.info("hostName: {}", hostName);

		InetAddress[] inetAddressArray = InetAddress.getAllByName(hostName);
		for (InetAddress tmpInetAddress : inetAddressArray) {
			logger.info("hostAddress: {}", tmpInetAddress.getHostAddress());
			if (inetAddress.equals(tmpInetAddress)) {
				isLocalhost = true;
			}
		}
		return isLocalhost;
	}

	static public boolean isLocalhostByRawIpAddress(String rawIpAddress)
			throws UnknownHostException {
		boolean isLocalhost = false;
		String hostName = InetAddress.getLocalHost().getHostName();
		logger.info("hostName: {}", hostName);

		InetAddress[] inetAddressArray = InetAddress.getAllByName(hostName);
		for (InetAddress tmpInetAddress : inetAddressArray) {
			logger.info("hostAddress: {}", tmpInetAddress.getHostAddress());
			if (rawIpAddress.equals(tmpInetAddress.toString())) {
				isLocalhost = true;
			}
		}
		return isLocalhost;
	}

	static public boolean isLocalhostByHostName(String hostName)
			throws UnknownHostException {
		boolean isLocalhost = false;
		String localhostName = InetAddress.getLocalHost().getHostName();
		logger.info("hostName: {}", localhostName);

		InetAddress[] inetAddressArray = InetAddress
				.getAllByName(localhostName);
		for (InetAddress tmpInetAddress : inetAddressArray) {
			logger.info("hostAddress: {}", tmpInetAddress.getHostAddress());
			if (hostName.equals(tmpInetAddress.getHostName())) {
				isLocalhost = true;
			}
		}
		return isLocalhost;
	}

}
