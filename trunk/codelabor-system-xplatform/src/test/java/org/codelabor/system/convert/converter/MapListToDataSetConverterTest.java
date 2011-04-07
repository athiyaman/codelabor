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
package org.codelabor.system.convert.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codelabor.system.convert.converter.support.xlatform.MapListToDataSetConverter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tobesoft.xplatform.data.DataSet;

/**
 * @author Administrator
 * 
 */
public class MapListToDataSetConverterTest {

	private Logger logger = LoggerFactory
			.getLogger(MapListToDataSetConverterTest.class);
	private List<Map<String, Object>> mapList = null;
	private MapListToDataSetConverter mapListToDataSetConverter;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mapListToDataSetConverter = new MapListToDataSetConverter();

		Map<String, Object> dataMap1 = new LinkedHashMap<String, Object>();
		dataMap1.put("field1", "value1");
		dataMap1.put("field2", Integer.MAX_VALUE);
		dataMap1.put("field3", false);
		dataMap1.put("field4", Long.MAX_VALUE);
		dataMap1.put("field5", Float.MAX_VALUE);
		dataMap1.put("field6", Double.MAX_VALUE);
		dataMap1.put("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataMap1.put("field8", Calendar.getInstance().getTime());
		dataMap1.put("field9", Calendar.getInstance().getTime());
		dataMap1.put("field10", Calendar.getInstance().getTime());
		dataMap1.put("field11", (new String("field11")).getBytes());

		Map<String, Object> dataMap2 = new LinkedHashMap<String, Object>();
		dataMap2.put("field1", "value1");
		dataMap2.put("field2", Integer.MAX_VALUE);
		dataMap2.put("field3", false);
		dataMap2.put("field4", Long.MAX_VALUE);
		dataMap2.put("field5", Float.MAX_VALUE);
		dataMap2.put("field6", Double.MAX_VALUE);
		dataMap2.put("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataMap2.put("field8", Calendar.getInstance().getTime());
		dataMap2.put("field9", Calendar.getInstance().getTime());
		dataMap2.put("field10", Calendar.getInstance().getTime());
		dataMap2.put("field11", (new String("field11")).getBytes());

		mapList = new ArrayList<Map<String, Object>>();
		mapList.add(dataMap1);
		mapList.add(dataMap2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.convert.converter.support.xlatform.MapListToDataSetConverter#convert(java.util.List)}
	 * .
	 */
	@Test
	public void testConvert() {
		DataSet dataSet = mapListToDataSetConverter.convert(mapList);
		logger.debug("dataSet: {}", dataSet);
	}

}
