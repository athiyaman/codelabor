package org.codelabor.system.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.UnknownHostException;

import org.junit.Test;

public class NetUtilsTest {

	@Test
	public void testIsLocalhostByRawIpAddress() {
		try {
			assertTrue(!NetUtils.isLocalhostByRawIpAddress("256.256.256.256"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsLocalhostByHostName() {
		try {
			assertTrue(!NetUtils.isLocalhostByHostName("dummyhost"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
			fail();
		}
	}

}
