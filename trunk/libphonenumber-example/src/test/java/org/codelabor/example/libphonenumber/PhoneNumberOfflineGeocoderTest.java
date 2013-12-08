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
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

public class PhoneNumberOfflineGeocoderTest {

	private static PhoneNumberUtil phoneNumberUtil;
	private static PhoneNumberOfflineGeocoder geocoder;
	private Logger logger = LoggerFactory
			.getLogger(PhoneNumberOfflineGeocoderTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		phoneNumberUtil = PhoneNumberUtil.getInstance();
		geocoder = PhoneNumberOfflineGeocoder.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetDescriptionForNumber() {
		try {
			PhoneNumber phoneNumber = phoneNumberUtil
					.parse("01012345678", "KR");
			logger.debug("phoneNumber: {}", phoneNumber);
			String englishDescription = geocoder.getDescriptionForNumber(
					phoneNumber, Locale.ENGLISH);
			logger.debug("englishDescription: {}", englishDescription);
			String chineseDescription = geocoder.getDescriptionForNumber(
					phoneNumber, Locale.CHINESE);
			logger.debug("chineseDescription: {}", chineseDescription);
			String japaneseDescription = geocoder.getDescriptionForNumber(
					phoneNumber, Locale.JAPANESE);
			logger.debug("japaneseDescription: {}", japaneseDescription);
			String koreanDescription = geocoder.getDescriptionForNumber(
					phoneNumber, Locale.KOREAN);
			logger.debug("koreanDescription: {}", koreanDescription);

		} catch (NumberParseException e) {
			e.printStackTrace();
		}
	}

}
