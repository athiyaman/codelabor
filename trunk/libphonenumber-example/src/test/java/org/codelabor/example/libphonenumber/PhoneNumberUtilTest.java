package org.codelabor.example.libphonenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class PhoneNumberUtilTest {

	private static PhoneNumberUtil phoneNumberUtil;
	private static PhoneNumber phoneNumber;
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
		// phoneNumber = phoneNumberUtil.parse("01012345678",
		// Locale.KOREA.getCountry());

		// phoneNumber = phoneNumberUtil.parse("0237067110",
		// Locale.KOREA.getCountry());

		// phoneNumber = phoneNumberUtil.parse("07012345678",
		// Locale.KOREA.getCountry());

		phoneNumber = phoneNumberUtil.parse("05052345678",
				Locale.KOREA.getCountry());

		logger.debug("phoneNumber: {}", phoneNumber);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testParseStringString() {
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

		String nationalSignificantNumber = phoneNumberUtil
				.getNationalSignificantNumber(phoneNumber);
		logger.debug("nationalSignificantNumber: {}", nationalSignificantNumber);

		String regionCode = phoneNumberUtil.getRegionCodeForNumber(phoneNumber);
		logger.debug("regionCode: {}", regionCode);
	}

	@Test
	public final void testGetSupportedRegions() {
		logger.debug("unordered");
		Set<String> regionsSet = phoneNumberUtil.getSupportedRegions();
		for (String region : regionsSet) {
			int countryCode = phoneNumberUtil.getCountryCodeForRegion(region);
			logger.debug("region: {}, countryCode: {}", region, countryCode);
		}

		logger.debug("ordered");
		List<String> regionList = new ArrayList<String>(regionsSet);
		Collections.sort(regionList);
		for (String region : regionList) {
			int countryCode = phoneNumberUtil.getCountryCodeForRegion(region);
			logger.debug("region: {}, countryCode: {}", region, countryCode);
		}
	}
}
