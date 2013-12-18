/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.common.web.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * This class provides map for HTML &lt;select&gt; form attribute.
 * </p>
 * <p>
 * Map can be used with Spring Framework taglib &lt;form:select /&gt;,
 * &lt;form:option /&gt; or &lt;form:optinos /&gt;.
 * </p>
 * 
 * <b>Example:</b> <br/>
 * <p>
 * Map is added to Map, Model, ModelMap or ModelAndView as follows:
 * </p>
 * <code>
 * new ModelAndView().addObject("hourMap", getHourMap());
 * </code> <br/>
 * <p>
 * &lt;select&gt; form attribute is marked up in a JSP file with Spring
 * Framework taglib as follows:
 * </p>
 * <code>
 * &lt;form:select path=&quot;hour&quot; items=&quot;${hourMap}&quot;
 * /&gt;
 * </code>
 * 
 * 
 * @author Shin Sang-Jae
 * 
 */
public class ReferenceDataUtils {

	/**
	 * <p>
	 * Produces a new map containing hours.
	 * </p>
	 * <p>
	 * Key and value is same.
	 * </p>
	 * 
	 * @return a new map containing hours from 00 to 23.
	 */
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

	/**
	 * <p>
	 * Produces a new map containing minute.
	 * </p>
	 * <p>
	 * Key and value is same.
	 * </p>
	 * 
	 * @return a new map containing minute from 00 to 55 increased by 5.
	 */
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

	/**
	 * <p>
	 * Produces a new map containing second.
	 * </p>
	 * <p>
	 * Key and value is same.
	 * </p>
	 * 
	 * @return a new map containing second from 00 to 55 increased by 5.
	 */
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
