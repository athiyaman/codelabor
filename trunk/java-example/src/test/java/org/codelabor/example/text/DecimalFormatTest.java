/**
 * 
 */
package org.codelabor.example.text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author bomber
 *
 */
public class DecimalFormatTest {
	
	private static Logger logger = LoggerFactory.getLogger(DecimalFormatTest.class);

	/**
	 * Test method for {@link java.text.NumberFormat#format(double)}.
	 */
	@Test
	public void testFormatDouble() {
		long number = 1234567890;
		NumberFormat numberFormat = DecimalFormat.getInstance();
		String numberFormatted = numberFormat.format(number);
		logger.debug("number: {}, numberFormatted: {}", number, numberFormatted);
		
	}

}
