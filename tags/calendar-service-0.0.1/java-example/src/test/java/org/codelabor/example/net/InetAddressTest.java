package org.codelabor.example.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InetAddressTest extends TestCase {

	Logger logger = LoggerFactory.getLogger(InetAddressTest.class);

	public void testGetLocalHost() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			logger.debug("inet address: {}", localHost);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testGetAddress() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			byte[] address = localHost.getAddress();
			logger.debug("address: {}", address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testGetHostName() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			String hostName = localHost.getHostName();
			logger.debug("host name: {}", hostName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testGetHostAddress() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			String hostAddress = localHost.getHostAddress();
			logger.debug("host address: {}", hostAddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testGetCannonicalHostName() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			String cannonicalHostName = address.getCanonicalHostName();
			logger.debug("cannonical host name: {}", cannonicalHostName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testGetByName() {
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			logger.debug("address: {}", address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testGetByAddress() {
		try {
			InetAddress address = InetAddress.getByAddress(new byte[] { 127, 0,
					0, 1 });
			logger.debug("address: {}", address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testConvertToDotPresentation() {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			byte[] address = localHost.getAddress();
			StringBuilder sb = new StringBuilder();
			for (byte addressByte : address) {
				sb.append(addressByte & 0xFF);
				sb.append(".");
			}
			sb.deleteCharAt(sb.length() - 1);
			logger.debug("address: {}", sb.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testIsLinkLocalAddress() {
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			logger
					.debug("isLinkLocalAddress: {}", address
							.isLinkLocalAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testIsAnyLocalAddress() {
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			logger.debug("isAnyLocalAddress: {}", address.isAnyLocalAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testIsSiteLocalAddress() {
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			logger
					.debug("isSiteLocalAddress: {}", address
							.isSiteLocalAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void testIsLocalAddress() {
		try {
			InetAddress address = InetAddress.getByName("10.0.0.1");
			String hostName = address.getHostName();
			logger.debug("host name: {}", hostName);

			String localHostName = InetAddress.getLocalHost().getHostName();
			logger.debug("local host name: {}", localHostName);

			logger.debug("is local address: {}", hostName.toLowerCase().equals(
					localHostName.toLowerCase()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
