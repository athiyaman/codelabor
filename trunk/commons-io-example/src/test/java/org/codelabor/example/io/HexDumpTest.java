package org.codelabor.example.io;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.HexDump;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HexDumpTest {
	Logger logger = LoggerFactory.getLogger(HexDumpTest.class);

	@Test
	public void testDump() {
		String before = "가나다라마바사아자차카타파하1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		byte[] data = null;
		long offset = 0;
		int index = 0;

		try {
			data = before.getBytes("EUC-KR");
			HexDump.dump(data, offset, System.out, index);

			data = before.getBytes("UTF-8");
			HexDump.dump(data, offset, System.out, index);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			fail();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
}
