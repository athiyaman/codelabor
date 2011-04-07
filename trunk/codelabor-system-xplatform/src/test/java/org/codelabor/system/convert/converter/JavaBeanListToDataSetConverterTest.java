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
import java.util.List;

import org.codelabor.example.dto.TestDTO;
import org.codelabor.system.convert.converter.support.xlatform.JavaBeanListToDataSetConverter;
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
public class JavaBeanListToDataSetConverterTest {

	private Logger logger = LoggerFactory
			.getLogger(JavaBeanListToDataSetConverterTest.class);

	private List<Object> javaBeanList = null;
	private JavaBeanListToDataSetConverter javaBeanListToDataSetConverter = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		javaBeanListToDataSetConverter = new JavaBeanListToDataSetConverter();

		TestDTO testDTO1 = new TestDTO();
		testDTO1.setField1("value1");
		testDTO1.setField2(Integer.MAX_VALUE);
		testDTO1.setField3(false);
		testDTO1.setField4(Long.MAX_VALUE);
		testDTO1.setField5(Float.MAX_VALUE);
		testDTO1.setField6(Double.MAX_VALUE);
		testDTO1.setField7(BigDecimal.valueOf(Double.MAX_VALUE));
		testDTO1.setField8(Calendar.getInstance().getTime());
		testDTO1.setField9(Calendar.getInstance().getTime());
		testDTO1.setField10(Calendar.getInstance().getTime());
		testDTO1.setField11((new String("field11")).getBytes());

		TestDTO testDTO2 = new TestDTO();
		testDTO2.setField1("value1");
		testDTO2.setField2(Integer.MAX_VALUE);
		testDTO2.setField3(false);
		testDTO2.setField4(Long.MAX_VALUE);
		testDTO2.setField5(Float.MAX_VALUE);
		testDTO2.setField6(Double.MAX_VALUE);
		testDTO2.setField7(BigDecimal.valueOf(Double.MAX_VALUE));
		testDTO2.setField8(Calendar.getInstance().getTime());
		testDTO2.setField9(Calendar.getInstance().getTime());
		testDTO2.setField10(Calendar.getInstance().getTime());
		testDTO2.setField11((new String("field11")).getBytes());

		javaBeanList = new ArrayList<Object>();
		javaBeanList.add(testDTO1);
		javaBeanList.add(testDTO2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.convert.converter.support.xlatform.JavaBeanListToDataSetConverter#convert(java.util.List)}
	 * .
	 */
	@Test
	public void testConvert() {
		DataSet dataSet = javaBeanListToDataSetConverter.convert(javaBeanList);
		logger.debug("dataSet: {}", dataSet);
	}
}
