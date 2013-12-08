package org.codelabor.example.libphonenumber;

import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class PhoneNumberUtilTest {

	private static PhoneNumberUtil phoneNumberUtil;
	private Logger logger = LoggerFactory.getLogger(PhoneNumberUtilTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		phoneNumberUtil = PhoneNumberUtil.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testParseStringString() {
		try {
			PhoneNumber phoneNumber = phoneNumberUtil.parse("01012345678",
					Locale.KOREA.getCountry());
			logger.debug("phoneNumber: {}", phoneNumber);

			boolean isValid = phoneNumberUtil.isValidNumber(phoneNumber);
			logger.debug("isValid: {}", isValid);

			String internationalFormat = phoneNumberUtil.format(phoneNumber,
					PhoneNumberFormat.INTERNATIONAL);
			logger.debug("internationalFormat: {}", internationalFormat);
			String nationalFormat = phoneNumberUtil.format(phoneNumber,
					PhoneNumberFormat.NATIONAL);
			logger.debug("nationalFormat: {}", nationalFormat);
			String e164Format = phoneNumberUtil.format(phoneNumber,
					PhoneNumberFormat.E164);
			logger.debug("e164Format: {}", e164Format);
		} catch (NumberParseException e) {
			e.printStackTrace();
		}
	}

}
