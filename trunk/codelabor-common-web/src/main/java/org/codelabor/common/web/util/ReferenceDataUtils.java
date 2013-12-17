package org.codelabor.common.web.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReferenceDataUtils {
	public static Map<String, String> getHourMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("00", "00");
		map.put("01", "01");
		map.put("02", "02");
		map.put("03", "03");
		map.put("04", "04");
		map.put("05", "05");
		map.put("06", "06");
		map.put("07", "07");
		map.put("08", "08");
		map.put("09", "09");
		map.put("10", "10");
		map.put("11", "11");
		map.put("12", "12");
		map.put("13", "13");
		map.put("14", "14");
		map.put("15", "15");
		map.put("16", "16");
		map.put("17", "17");
		map.put("18", "18");
		map.put("19", "19");
		map.put("20", "20");
		map.put("21", "21");
		map.put("22", "22");
		map.put("23", "23");
		return map;
	}

	public static Map<String, String> getMinuteMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("00", "00");
		map.put("05", "05");
		map.put("10", "10");
		map.put("15", "15");
		map.put("20", "20");
		map.put("25", "25");
		map.put("30", "30");
		map.put("35", "35");
		map.put("40", "40");
		map.put("45", "45");
		map.put("50", "50");
		map.put("55", "55");
		return map;
	}

	public static Map<String, String> getSecondMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("00", "00");
		map.put("05", "05");
		map.put("10", "10");
		map.put("15", "15");
		map.put("20", "20");
		map.put("25", "25");
		map.put("30", "30");
		map.put("35", "35");
		map.put("40", "40");
		map.put("45", "45");
		map.put("50", "50");
		map.put("55", "55");
		return map;
	}
}
