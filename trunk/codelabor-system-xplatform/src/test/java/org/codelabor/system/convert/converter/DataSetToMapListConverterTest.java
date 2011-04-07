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
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.codelabor.system.convert.converter.support.xlatform.DataSetToMapListConvertor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.DataTypes;

/**
 * @author Shin Sang-jae
 * 
 */
public class DataSetToMapListConverterTest {

	private Logger logger = LoggerFactory
			.getLogger(DataSetToMapListConverterTest.class);

	private DataSetToMapListConvertor dataSetToMapListConvertor = null;
	private DataSet dataSet;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataSetToMapListConvertor = new DataSetToMapListConvertor();

		dataSet = new DataSet("testDataSet");
		dataSet.addColumn("field1", DataTypes.STRING);
		dataSet.addColumn("field2", DataTypes.INT);
		dataSet.addColumn("field3", DataTypes.BOOLEAN);
		dataSet.addColumn("field4", DataTypes.LONG);
		dataSet.addColumn("field5", DataTypes.FLOAT);
		dataSet.addColumn("field6", DataTypes.DOUBLE);
		dataSet.addColumn("field7", DataTypes.BIG_DECIMAL);
		dataSet.addColumn("field8", DataTypes.DATE);
		dataSet.addColumn("field9", DataTypes.TIME);
		dataSet.addColumn("field10", DataTypes.DATE_TIME);
		dataSet.addColumn("field11", DataTypes.BLOB);

		dataSet.newRow();
		dataSet.set(0, "field1", "value1");
		dataSet.set(0, "field2", Integer.MAX_VALUE);
		dataSet.set(0, "field3", false);
		dataSet.set(0, "field4", Long.MAX_VALUE);
		dataSet.set(0, "field5", Float.MAX_VALUE);
		dataSet.set(0, "field6", Double.MAX_VALUE);
		dataSet.set(0, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(0, "field8", Calendar.getInstance().getTime());
		dataSet.set(0, "field9", Calendar.getInstance().getTime());
		dataSet.set(0, "field10", Calendar.getInstance().getTime());
		dataSet.set(0, "field11", (new String("field11")).getBytes());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.convert.converter.support.xlatform.DataSetToMapListConvertor#convert(com.tobesoft.xplatform.data.DataSet)}
	 * .
	 */
	@Test
	public void testConvert() {
		List<Map<String, Object>> mapList = dataSetToMapListConvertor
				.convert(dataSet);
		logger.debug("mapList: {}", mapList);
	}

}
