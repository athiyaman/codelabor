package org.codelabor.example.libphonenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

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

		phoneNumber = phoneNumberUtil.parse("(02)3706-7110",
				Locale.KOREA.getCountry());

		// phoneNumber = phoneNumberUtil.parse("07012345678",
		// Locale.KOREA.getCountry());

		// phoneNumber = phoneNumberUtil.parse("05052345678",
		// Locale.KOREA.getCountry());

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
		for (String regionCode : regionsSet) {
			int countryCode = phoneNumberUtil
					.getCountryCodeForRegion(regionCode);
			Locale locale = new Locale(Locale.KOREAN.getDisplayLanguage(),
					regionCode);
			logger.debug("region: {}, country: {}, countryCode: {}",
					regionCode, locale.getDisplayCountry(), countryCode);
		}

		logger.debug("ordered");
		List<String> regionList = new ArrayList<String>(regionsSet);
		Collections.sort(regionList);
		for (String regionCode : regionList) {
			int countryCode = phoneNumberUtil
					.getCountryCodeForRegion(regionCode);
			Locale locale = new Locale(Locale.KOREAN.getDisplayLanguage(),
					regionCode);
			logger.debug("region: {}, country: {}, countryCode: {}",
					regionCode, locale.getDisplayCountry(), countryCode);
		}
	}

	@Test
	public final void testMakeCountryCodeOrderedMap() {
		Set<String> regionsSet = phoneNumberUtil.getSupportedRegions();
		Map map = new TreeMap();
		for (String regionCode : regionsSet) {
			int countryCode = phoneNumberUtil
					.getCountryCodeForRegion(regionCode);
			Locale locale = new Locale(Locale.KOREAN.getDisplayLanguage(),
					regionCode);
			String displayCountry = locale.getDisplayCountry();
			logger.debug("region: {}, countryCode: {}, country: {}",
					regionCode, countryCode, displayCountry);
			map.put(countryCode, displayCountry);
		}
		logger.debug("map: {}", map);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void testMakeDisplayCountryOrderedMap() {
		Set<String> regionsSet = phoneNumberUtil.getSupportedRegions();
		Map<Integer, String> countryMap = new HashMap<Integer, String>();
		for (String regionCode : regionsSet) {
			int countryCode = phoneNumberUtil
					.getCountryCodeForRegion(regionCode);
			Locale locale = new Locale(Locale.KOREAN.getDisplayLanguage(),
					regionCode);
			String displayCountry = locale.getDisplayCountry();
			logger.debug("region: {}, countryCode: {}, country: {}",
					regionCode, countryCode, displayCountry);
			countryMap.put(countryCode, displayCountry);
		}
		logger.debug("countryMap: {}", countryMap);

		List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(
				countryMap.entrySet());
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// put sorted list into map again
		// LinkedHashMap make sure order in which keys were inserted
		Map<Integer, String> sortedCountryMap = new LinkedHashMap<Integer, String>();
		for (Iterator<Entry<Integer, String>> it = list.iterator(); it
				.hasNext();) {
			Entry<Integer, String> entry = it.next();
			sortedCountryMap.put(entry.getKey(), entry.getValue());
		}

		logger.debug("sortedCountryMap: {}", sortedCountryMap);

	}
}
