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
import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class PhoneNumberToCarrierMappterTest {

	private static PhoneNumberUtil phoneNumberUtil;
	private static PhoneNumberToCarrierMapper phoneNumberToCarrierMapper;
	private Logger logger = LoggerFactory
			.getLogger(PhoneNumberToCarrierMappterTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		phoneNumberUtil = PhoneNumberUtil.getInstance();
		phoneNumberToCarrierMapper = PhoneNumberToCarrierMapper.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetNameForNumber() {
		try {
			PhoneNumber phoneNumber = phoneNumberUtil.parse("01012345678",
					Locale.KOREA.getCountry());
			logger.debug("phoneNumber: {}", phoneNumber);

			String koreanName = phoneNumberToCarrierMapper.getNameForNumber(
					phoneNumber, Locale.KOREAN);
			logger.debug("koreanName: {}", koreanName);

		} catch (NumberParseException e) {
			e.printStackTrace();
		}
	}

}
