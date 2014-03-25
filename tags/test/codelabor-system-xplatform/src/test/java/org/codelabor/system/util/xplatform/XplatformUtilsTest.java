package org.codelabor.system.util.xplatform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codelabor.example.dto.TestDTO;
import org.codelabor.system.dto.xinternet.BatchUpdateDataDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tobesoft.xplatform.data.ColumnHeader;
import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.DataTypes;
import com.tobesoft.xplatform.data.Variable;
import com.tobesoft.xplatform.data.VariableList;

/**
 * XplatformUtils 테스트 케이스
 * 
 * @author bomber.shin
 * 
 */
public class XplatformUtilsTest {

	Logger logger = LoggerFactory.getLogger(XplatformUtilsTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetXplatformDataTypesByInstance() {
		assertEquals(DataTypes.STRING,
				XplatformUtils.getXplatformDataTypes("value1"));
		assertEquals(DataTypes.INT,
				XplatformUtils.getXplatformDataTypes(Integer.MAX_VALUE));
		assertEquals(DataTypes.BOOLEAN,
				XplatformUtils.getXplatformDataTypes(false));
		assertEquals(DataTypes.LONG,
				XplatformUtils.getXplatformDataTypes(Long.MAX_VALUE));
		assertEquals(DataTypes.FLOAT,
				XplatformUtils.getXplatformDataTypes(Float.MAX_VALUE));
		assertEquals(DataTypes.DOUBLE,
				XplatformUtils.getXplatformDataTypes(Double.MAX_VALUE));
		assertEquals(DataTypes.BIG_DECIMAL,
				XplatformUtils.getXplatformDataTypes(BigDecimal
						.valueOf(Double.MAX_VALUE)));
		assertEquals(DataTypes.DATE_TIME,
				XplatformUtils.getXplatformDataTypes(Calendar.getInstance()
						.getTime()));
		assertEquals(DataTypes.BLOB,
				XplatformUtils.getXplatformDataTypes((new String("field11"))
						.getBytes()));
	}

	@Test
	public void testGetXplatformDataTypesByClass() {
		assertEquals(DataTypes.STRING,
				XplatformUtils.getXplatformDataTypes(java.lang.String.class));
		assertEquals(DataTypes.INT,
				XplatformUtils.getXplatformDataTypes(java.lang.Integer.class));
		assertEquals(DataTypes.BOOLEAN,
				XplatformUtils.getXplatformDataTypes(java.lang.Boolean.class));
		assertEquals(DataTypes.LONG,
				XplatformUtils.getXplatformDataTypes(java.lang.Long.class));
		assertEquals(DataTypes.FLOAT,
				XplatformUtils.getXplatformDataTypes(java.lang.Float.class));
		assertEquals(DataTypes.DOUBLE,
				XplatformUtils.getXplatformDataTypes(java.lang.Double.class));
		assertEquals(DataTypes.BIG_DECIMAL,
				XplatformUtils
						.getXplatformDataTypes(java.math.BigDecimal.class));
		assertEquals(DataTypes.DATE_TIME,
				XplatformUtils.getXplatformDataTypes(java.util.Date.class));
		assertEquals(DataTypes.BLOB,
				XplatformUtils.getXplatformDataTypes(byte[].class));
	}

	@Test
	public void testSetHeader() {
		Map<String, Object> testMap = new LinkedHashMap<String, Object>();
		testMap.put("field1", "value1");
		testMap.put("field2", Integer.MAX_VALUE);
		testMap.put("field3", false);
		testMap.put("field4", Long.MAX_VALUE);
		testMap.put("field5", Float.MAX_VALUE);
		testMap.put("field6", Double.MAX_VALUE);
		testMap.put("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		testMap.put("field8", Calendar.getInstance().getTime());
		testMap.put("field9", Calendar.getInstance().getTime());
		testMap.put("field10", Calendar.getInstance().getTime());
		testMap.put("field11", (new String("field11")).getBytes());

		DataSet dataSet = new DataSet("testDataSet");
		XplatformUtils.setColumnHeaderByMap(testMap, dataSet);
		int columnCount = dataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
			logger.debug("name: {}, tyle: {}", columnHeader.getName(),
					columnHeader.getDataType());
		}
	}

	@Test
	public void testConvertJavaBeanToDataSetRow() {
		TestDTO testDTO = new TestDTO();
		testDTO.setField1("value1");
		testDTO.setField2(Integer.MAX_VALUE);
		testDTO.setField3(false);
		testDTO.setField4(Long.MAX_VALUE);
		testDTO.setField5(Float.MAX_VALUE);
		testDTO.setField6(Double.MAX_VALUE);
		testDTO.setField7(BigDecimal.valueOf(Double.MAX_VALUE));
		testDTO.setField8(Calendar.getInstance().getTime());
		testDTO.setField9(Calendar.getInstance().getTime());
		testDTO.setField10(Calendar.getInstance().getTime());
		testDTO.setField11((new String("field11")).getBytes());

		try {
			// set data set header
			DataSet dataSet = new DataSet("testDataSet");
			XplatformUtils.setColumnHeaderByJavaBeanClass(TestDTO.class,
					dataSet);
			int columnCount = dataSet.getColumnCount();
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
				logger.debug("name: {}, type: {}", columnHeader.getName(),
						columnHeader.getDataType());
			}

			// add data set row
			XplatformUtils.convertJavaBeanToDataSetRow(testDTO, dataSet, 0);
			XplatformUtils.convertJavaBeanToDataSetRow(testDTO, dataSet, 1);

			// check data set
			int rowCount = dataSet.getRowCount();
			logger.debug("rowCount: {}", rowCount);
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				columnCount = dataSet.getColumnCount();
				for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
					ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
					logger.debug("name: {}, value: {}", columnHeader.getName(),
							dataSet.getObject(rowIndex, columnIndex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertJavaBeanToDataSet() {
		TestDTO testDTO = new TestDTO();
		testDTO.setField1("value1");
		testDTO.setField2(Integer.MAX_VALUE);
		testDTO.setField3(false);
		testDTO.setField4(Long.MAX_VALUE);
		testDTO.setField5(Float.MAX_VALUE);
		testDTO.setField6(Double.MAX_VALUE);
		testDTO.setField7(BigDecimal.valueOf(Double.MAX_VALUE));
		testDTO.setField8(Calendar.getInstance().getTime());
		testDTO.setField9(Calendar.getInstance().getTime());
		testDTO.setField10(Calendar.getInstance().getTime());
		testDTO.setField11((new String("field11")).getBytes());

		try {
			DataSet dataSet = XplatformUtils.convertJavaBeanToDataSet(testDTO);

			// check data set
			int rowCount = dataSet.getRowCount();
			logger.debug("rowCount: {}", rowCount);
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				int columnCount = dataSet.getColumnCount();
				for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
					ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
					logger.debug("name: {}, value: {}", columnHeader.getName(),
							dataSet.getObject(rowIndex, columnIndex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertJavaBeanListToDataSet() {
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

		List<Object> beanList = new ArrayList<Object>();
		beanList.add(testDTO1);
		beanList.add(testDTO2);

		try {
			DataSet dataSet = new DataSet("testDataSet");
			XplatformUtils.setColumnHeaderByJavaBeanClass(TestDTO.class,
					dataSet);
			XplatformUtils.convertJavaBeanListToDataSet(beanList, dataSet);

			// check data set
			int rowCount = dataSet.getRowCount();
			logger.debug("rowCount: {}", rowCount);
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				int columnCount = dataSet.getColumnCount();
				for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
					ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
					logger.debug("name: {}, value: {}", columnHeader.getName(),
							dataSet.getObject(rowIndex, columnIndex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertJavaBeanListToDataSetReturn() {
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

		List<TestDTO> beanList = new ArrayList<TestDTO>();
		beanList.add(testDTO1);
		beanList.add(testDTO2);

		try {
			DataSet dataSet = XplatformUtils
					.convertJavaBeanListToDataSet(beanList);

			// check data set
			int rowCount = dataSet.getRowCount();
			logger.debug("rowCount: {}", rowCount);
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				int columnCount = dataSet.getColumnCount();
				for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
					ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
					logger.debug("name: {}, value: {}", columnHeader.getName(),
							dataSet.getObject(rowIndex, columnIndex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertJavaBeanListToDataSetReturnWithName() {
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

		List<Object> beanList = new ArrayList<Object>();
		beanList.add(testDTO1);
		beanList.add(testDTO2);

		try {
			DataSet dataSet = XplatformUtils.convertJavaBeanListToDataSet(
					beanList, "testDataSet");
			assertEquals("testDataSet", dataSet.getName());
			logger.debug("dataSet name: {}", dataSet.getName());

			// check data set
			int rowCount = dataSet.getRowCount();
			logger.debug("rowCount: {}", rowCount);
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				int columnCount = dataSet.getColumnCount();
				for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
					ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
					logger.debug("name: {}, value: {}", columnHeader.getName(),
							dataSet.getObject(rowIndex, columnIndex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertJavaBeanToDataSetWithName() {
		TestDTO testDTO = new TestDTO();
		testDTO.setField1("value1");
		testDTO.setField2(Integer.MAX_VALUE);
		testDTO.setField3(false);
		testDTO.setField4(Long.MAX_VALUE);
		testDTO.setField5(Float.MAX_VALUE);
		testDTO.setField6(Double.MAX_VALUE);
		testDTO.setField7(BigDecimal.valueOf(Double.MAX_VALUE));
		testDTO.setField8(Calendar.getInstance().getTime());
		testDTO.setField9(Calendar.getInstance().getTime());
		testDTO.setField10(Calendar.getInstance().getTime());
		testDTO.setField11((new String("field11")).getBytes());

		try {
			DataSet dataSet = XplatformUtils.convertJavaBeanToDataSet(testDTO,
					"testDataSet");
			assertEquals("testDataSet", dataSet.getName());
			logger.debug("dataSet name: {}", dataSet.getName());

			// check data set
			int rowCount = dataSet.getRowCount();
			logger.debug("rowCount: {}", rowCount);
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				int columnCount = dataSet.getColumnCount();
				for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
					ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
					logger.debug("name: {}, value: {}", columnHeader.getName(),
							dataSet.getObject(rowIndex, columnIndex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testAddJavaBeanToVariableList() {
		TestDTO testDTO = new TestDTO();
		testDTO.setField1("value1");
		testDTO.setField2(Integer.MAX_VALUE);
		testDTO.setField3(false);
		testDTO.setField4(Long.MAX_VALUE);
		testDTO.setField5(Float.MAX_VALUE);
		testDTO.setField6(Double.MAX_VALUE);
		testDTO.setField7(BigDecimal.valueOf(Double.MAX_VALUE));
		testDTO.setField8(Calendar.getInstance().getTime());
		testDTO.setField9(Calendar.getInstance().getTime());
		testDTO.setField10(Calendar.getInstance().getTime());
		testDTO.setField11((new String("field11")).getBytes());

		try {
			VariableList variableList = new VariableList();
			XplatformUtils.addJavaBeanToVariableList(testDTO, variableList);

			// check variable list
			int variableCount = variableList.size();
			logger.debug("variableCount: {}", variableCount);
			for (int variableIndex = 0; variableIndex < variableCount; variableIndex++) {
				Variable variable = variableList.get(variableIndex);
				logger.debug("variable: {}", variable);
				String variableName = variable.getName();
				Object variableValue = variable.getObject();
				logger.debug("variableName: {}, variableValue: {}",
						variableName, variableValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertJavaBeanToVariableListReturn() {
		TestDTO testDTO = new TestDTO();
		testDTO.setField1("value1");
		testDTO.setField2(Integer.MAX_VALUE);
		testDTO.setField3(false);
		testDTO.setField4(Long.MAX_VALUE);
		testDTO.setField5(Float.MAX_VALUE);
		testDTO.setField6(Double.MAX_VALUE);
		testDTO.setField7(BigDecimal.valueOf(Double.MAX_VALUE));
		testDTO.setField8(Calendar.getInstance().getTime());
		testDTO.setField9(Calendar.getInstance().getTime());
		testDTO.setField10(Calendar.getInstance().getTime());
		testDTO.setField11((new String("field11")).getBytes());

		try {
			VariableList variableList = XplatformUtils
					.convertJavaBeanToVariableList(testDTO);

			// check variable list
			int variableCount = variableList.size();
			logger.debug("variableCount: {}", variableCount);
			for (int variableIndex = 0; variableIndex < variableCount; variableIndex++) {
				Variable variable = variableList.get(variableIndex);
				logger.debug("variable: {}", variable);
				String variableName = variable.getName();
				Object variableValue = variable.getObject();
				logger.debug("variableName: {}, variableValue: {}",
						variableName, variableValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertMapToDataSetRow() {
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("field1", "value1");
		dataMap.put("field2", Integer.MAX_VALUE);
		dataMap.put("field3", false);
		dataMap.put("field4", Long.MAX_VALUE);
		dataMap.put("field5", Float.MAX_VALUE);
		dataMap.put("field6", Double.MAX_VALUE);
		dataMap.put("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataMap.put("field8", Calendar.getInstance().getTime());
		dataMap.put("field9", Calendar.getInstance().getTime());
		dataMap.put("field10", Calendar.getInstance().getTime());
		dataMap.put("field11", (new String("field11")).getBytes());

		// set data set header
		DataSet dataSet = new DataSet("testDataSet");
		XplatformUtils.setColumnHeaderByMap(dataMap, dataSet);
		int columnCount = dataSet.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
			logger.debug("name: {}, type: {}", columnHeader.getName(),
					columnHeader.getDataType());
		}

		// add data set row
		XplatformUtils.convertMapToDataSetRow(dataMap, dataSet, 0);
		XplatformUtils.convertMapToDataSetRow(dataMap, dataSet, 1);

		// check data set
		int rowCount = dataSet.getRowCount();
		logger.debug("rowCount: {}", rowCount);
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			columnCount = dataSet.getColumnCount();
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
				logger.debug("name: {}, value: {}", columnHeader.getName(),
						dataSet.getObject(rowIndex, columnIndex));
			}
		}
	}

	@Test
	public void testConvertMapToDataSetWithName() {
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("field1", "value1");
		dataMap.put("field2", Integer.MAX_VALUE);
		dataMap.put("field3", false);
		dataMap.put("field4", Long.MAX_VALUE);
		dataMap.put("field5", Float.MAX_VALUE);
		dataMap.put("field6", Double.MAX_VALUE);
		dataMap.put("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataMap.put("field8", Calendar.getInstance().getTime());
		dataMap.put("field9", Calendar.getInstance().getTime());
		dataMap.put("field10", Calendar.getInstance().getTime());
		dataMap.put("field11", (new String("field11")).getBytes());

		// add data set row
		DataSet dataSet = XplatformUtils.convertMapToDataSet(dataMap,
				"testDataSet");
		assertEquals("testDataSet", dataSet.getName());
		logger.debug("dataSet name: {}", dataSet.getName());

		// check data set
		int rowCount = dataSet.getRowCount();
		logger.debug("rowCount: {}", rowCount);
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int columnCount = dataSet.getColumnCount();
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
				logger.debug("name: {}, value: {}", columnHeader.getName(),
						dataSet.getObject(rowIndex, columnIndex));
			}
		}
	}

	@Test
	public void testConvertMapToDataSet() {
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("field1", "value1");
		dataMap.put("field2", Integer.MAX_VALUE);
		dataMap.put("field3", false);
		dataMap.put("field4", Long.MAX_VALUE);
		dataMap.put("field5", Float.MAX_VALUE);
		dataMap.put("field6", Double.MAX_VALUE);
		dataMap.put("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataMap.put("field8", Calendar.getInstance().getTime());
		dataMap.put("field9", Calendar.getInstance().getTime());
		dataMap.put("field10", Calendar.getInstance().getTime());
		dataMap.put("field11", (new String("field11")).getBytes());

		// add data set row
		DataSet dataSet = XplatformUtils.convertMapToDataSet(dataMap);

		// check data set
		int rowCount = dataSet.getRowCount();
		logger.debug("rowCount: {}", rowCount);
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int columnCount = dataSet.getColumnCount();
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
				logger.debug("name: {}, value: {}", columnHeader.getName(),
						dataSet.getObject(rowIndex, columnIndex));
			}
		}
	}

	@Test
	public void testConvertMapListToDataSet() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
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

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		mapList.add(dataMap1);
		mapList.add(dataMap2);

		// add data set row
		DataSet dataSet = new DataSet("testDataSet");
		XplatformUtils.setColumnHeaderByMap(dataMap1, dataSet);
		XplatformUtils.convertMapListToDataSet(mapList, dataSet);

		// check data set
		int rowCount = dataSet.getRowCount();
		logger.debug("rowCount: {}", rowCount);
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int columnCount = dataSet.getColumnCount();
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
				logger.debug("name: {}, value: {}", columnHeader.getName(),
						dataSet.getObject(rowIndex, columnIndex));
			}
		}
	}

	@Test
	public void testConvertMapListToDataSetReturn() {
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

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		mapList.add(dataMap1);
		mapList.add(dataMap2);

		// add data set row
		DataSet dataSet = XplatformUtils.convertMapListToDataSet(mapList);

		// check data set
		int rowCount = dataSet.getRowCount();
		logger.debug("rowCount: {}", rowCount);
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int columnCount = dataSet.getColumnCount();
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
				logger.debug("name: {}, value: {}", columnHeader.getName(),
						dataSet.getObject(rowIndex, columnIndex));
			}
		}
	}

	@Test
	public void testConvertMapListToDataSetReturnWithName() {
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

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		mapList.add(dataMap1);
		mapList.add(dataMap2);

		// add data set row
		DataSet dataSet = XplatformUtils.convertMapListToDataSet(mapList,
				"testDataSet");
		assertEquals("testDataSet", dataSet.getName());
		logger.debug("dataSet name: {}", dataSet.getName());

		// check data set
		int rowCount = dataSet.getRowCount();
		logger.debug("rowCount: {}", rowCount);
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int columnCount = dataSet.getColumnCount();
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				ColumnHeader columnHeader = dataSet.getColumn(columnIndex);
				logger.debug("name: {}, value: {}", columnHeader.getName(),
						dataSet.getObject(rowIndex, columnIndex));
			}
		}
	}

	@Test
	public void testConvertDataSetRowToJavaBeanPrimitive() {
		DataSet dataSet = new DataSet("testDataSet");
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

		TestDTO testDTO = new TestDTO();
		try {
			XplatformUtils.convertDataSetRowToJavaBean(dataSet, testDTO, 0);
			logger.debug("testDTO: {}", testDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertDeletedDataSetRowToJavaBeanPrimitive() {
		DataSet dataSet = new DataSet("testDataSet");
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

		dataSet.startStoreDataChanges();
		dataSet.removeRow(0);

		TestDTO testDTO = new TestDTO();
		try {
			XplatformUtils.convertDeletedDataSetRowToJavaBean(dataSet, testDTO,
					0);
			logger.debug("testDTO: {}", testDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertDataSetRowToJavaBeanReturn() {
		DataSet dataSet = new DataSet("testDataSet");
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

		try {
			TestDTO testDTO = (TestDTO) XplatformUtils
					.convertDataSetRowToJavaBean(dataSet, TestDTO.class, 0);
			logger.debug("testDTO: {}", testDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertDataSetRowToJavaBeanClass() {
		DataSet dataSet = new DataSet("testDataSet");
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

		TestDTO testDTO = new TestDTO();
		try {
			XplatformUtils.convertDataSetRowToJavaBean(dataSet, testDTO, 0);
			logger.debug("testDTO2: {}", testDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertDataSetRowToMap() {
		DataSet dataSet = new DataSet("testDataSet");
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

		Map<String, Object> testMap = new LinkedHashMap<String, Object>();
		try {
			XplatformUtils.convertDataSetRowToMap(dataSet, testMap, 0);
			logger.debug("testMap: {}", testMap);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertDeletedDataSetRowToMap() {
		DataSet dataSet = new DataSet("testDataSet");
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

		dataSet.startStoreDataChanges();
		dataSet.removeRow(0);

		Map<String, Object> testMap = new LinkedHashMap<String, Object>();
		try {
			XplatformUtils.convertDeletedDataSetRowToMap(dataSet, testMap, 0);
			logger.debug("testMap: {}", testMap);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertDataSetRowToMapReturn() {
		DataSet dataSet = new DataSet("testDataSet");
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

		try {
			Map<String, Object> testMap = XplatformUtils
					.convertDataSetRowToMap(dataSet, 0);
			logger.debug("testMap: {}", testMap);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertDataSetToJavaBeanList() throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		DataSet dataSet = new DataSet("testDataSet");
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

		dataSet.newRow();
		dataSet.set(1, "field1", "value1");
		dataSet.set(1, "field2", Integer.MAX_VALUE);
		dataSet.set(1, "field3", false);
		dataSet.set(1, "field4", Long.MAX_VALUE);
		dataSet.set(1, "field5", Float.MAX_VALUE);
		dataSet.set(1, "field6", Double.MAX_VALUE);
		dataSet.set(1, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(1, "field8", Calendar.getInstance().getTime());
		dataSet.set(1, "field9", Calendar.getInstance().getTime());
		dataSet.set(1, "field10", Calendar.getInstance().getTime());
		dataSet.set(1, "field11", (new String("field11")).getBytes());

		List<Object> testDTOList = new ArrayList<Object>();
		XplatformUtils.convertDataSetToJavaBeanList(dataSet, testDTOList,
				TestDTO.class);

		logger.debug("list size: {}", testDTOList.size());

		for (Object testDTO : testDTOList) {
			logger.debug("testDTO: {}", testDTO);
		}
	}

	@Test
	public void testConvertDataSetToJavaBeanListReturn()
			throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		DataSet dataSet = new DataSet("testDataSet");
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

		dataSet.newRow();
		dataSet.set(1, "field1", "value1");
		dataSet.set(1, "field2", Integer.MAX_VALUE);
		dataSet.set(1, "field3", false);
		dataSet.set(1, "field4", Long.MAX_VALUE);
		dataSet.set(1, "field5", Float.MAX_VALUE);
		dataSet.set(1, "field6", Double.MAX_VALUE);
		dataSet.set(1, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(1, "field8", Calendar.getInstance().getTime());
		dataSet.set(1, "field9", Calendar.getInstance().getTime());
		dataSet.set(1, "field10", Calendar.getInstance().getTime());
		dataSet.set(1, "field11", (new String("field11")).getBytes());

		List<Object> testDTOList = XplatformUtils.convertDataSetToJavaBeanList(
				dataSet, TestDTO.class);

		logger.debug("list size: {}", testDTOList.size());

		for (Object testDTO : testDTOList) {
			logger.debug("testDTO: {}", testDTO);
		}
	}

	@Test
	public void testConvertDataSetToMapList() throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		DataSet dataSet = new DataSet("testDataSet");
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

		dataSet.newRow();
		dataSet.set(1, "field1", "value1");
		dataSet.set(1, "field2", Integer.MAX_VALUE);
		dataSet.set(1, "field3", false);
		dataSet.set(1, "field4", Long.MAX_VALUE);
		dataSet.set(1, "field5", Float.MAX_VALUE);
		dataSet.set(1, "field6", Double.MAX_VALUE);
		dataSet.set(1, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(1, "field8", Calendar.getInstance().getTime());
		dataSet.set(1, "field9", Calendar.getInstance().getTime());
		dataSet.set(1, "field10", Calendar.getInstance().getTime());
		dataSet.set(1, "field11", (new String("field11")).getBytes());

		List<Map<String, Object>> dataMapList = new ArrayList<Map<String, Object>>();
		XplatformUtils.convertDataSetToMapList(dataSet, dataMapList);

		logger.debug("list size: {}", dataMapList.size());

		for (Map<String, Object> dataMap : dataMapList) {
			logger.debug("dataMap: {}", dataMap);
		}
	}

	@Test
	public void testConvertDataSetToMapListReturn() throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		DataSet dataSet = new DataSet("testDataSet");
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

		dataSet.newRow();
		dataSet.set(1, "field1", "value1");
		dataSet.set(1, "field2", Integer.MAX_VALUE);
		dataSet.set(1, "field3", false);
		dataSet.set(1, "field4", Long.MAX_VALUE);
		dataSet.set(1, "field5", Float.MAX_VALUE);
		dataSet.set(1, "field6", Double.MAX_VALUE);
		dataSet.set(1, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(1, "field8", Calendar.getInstance().getTime());
		dataSet.set(1, "field9", Calendar.getInstance().getTime());
		dataSet.set(1, "field10", Calendar.getInstance().getTime());
		dataSet.set(1, "field11", (new String("field11")).getBytes());

		List<Map<String, Object>> dataMapList = XplatformUtils
				.convertDataSetToMapList(dataSet);

		logger.debug("list size: {}", dataMapList.size());

		for (Map<String, Object> dataMap : dataMapList) {
			logger.debug("dataMap: {}", dataMap);
		}
	}

	@Test
	public void testConvertVariableListToJavaBean() {
		VariableList variableList = new VariableList();
		variableList.add("field1", "value1");
		variableList.add("field2", Integer.MAX_VALUE);
		variableList.add("field3", false);
		variableList.add("field4", Long.MAX_VALUE);
		variableList.add("field5", Float.MAX_VALUE);
		variableList.add("field6", Double.MAX_VALUE);
		variableList.add("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		variableList.add("field8", Calendar.getInstance().getTime());
		variableList.add("field9", Calendar.getInstance().getTime());
		variableList.add("field10", Calendar.getInstance().getTime());
		variableList.add("field11", (new String("field11")).getBytes());
		variableList.add("field12", new Object());

		TestDTO testDTO = new TestDTO();
		try {
			XplatformUtils.convertVariableListToJavaBean(variableList, testDTO);
			logger.debug("testDTO: {}", testDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertVariableListToJavaBeanReturn() {
		VariableList variableList = new VariableList();
		variableList.add("field1", "value1");
		variableList.add("field2", Integer.MAX_VALUE);
		variableList.add("field3", false);
		variableList.add("field4", Long.MAX_VALUE);
		variableList.add("field5", Float.MAX_VALUE);
		variableList.add("field6", Double.MAX_VALUE);
		variableList.add("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		variableList.add("field8", Calendar.getInstance().getTime());
		variableList.add("field9", Calendar.getInstance().getTime());
		variableList.add("field10", Calendar.getInstance().getTime());
		variableList.add("field11", (new String("field11")).getBytes());
		variableList.add("field12", new Object());

		TestDTO testDTO = null;
		try {
			testDTO = (TestDTO) XplatformUtils.convertVariableListToJavaBean(
					variableList, TestDTO.class);
			logger.debug("testDTO: {}", testDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertVariableListToMap() {
		VariableList variableList = new VariableList();
		variableList.add("field1", "value1");
		variableList.add("field2", Integer.MAX_VALUE);
		variableList.add("field3", false);
		variableList.add("field4", Long.MAX_VALUE);
		variableList.add("field5", Float.MAX_VALUE);
		variableList.add("field6", Double.MAX_VALUE);
		variableList.add("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		variableList.add("field8", Calendar.getInstance().getTime());
		variableList.add("field9", Calendar.getInstance().getTime());
		variableList.add("field10", Calendar.getInstance().getTime());
		variableList.add("field11", (new String("field11")).getBytes());
		variableList.add("field12", new Object());

		Map<String, Object> testMap = new LinkedHashMap<String, Object>();
		try {
			XplatformUtils.convertVariableListToMap(variableList, testMap);
			logger.debug("testMap: {}", testMap);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConvertVariableListToMapReturn() {
		VariableList variableList = new VariableList();
		variableList.add("field1", "value1");
		variableList.add("field2", Integer.MAX_VALUE);
		variableList.add("field3", false);
		variableList.add("field4", Long.MAX_VALUE);
		variableList.add("field5", Float.MAX_VALUE);
		variableList.add("field6", Double.MAX_VALUE);
		variableList.add("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		variableList.add("field8", Calendar.getInstance().getTime());
		variableList.add("field9", Calendar.getInstance().getTime());
		variableList.add("field10", Calendar.getInstance().getTime());
		variableList.add("field11", (new String("field11")).getBytes());
		variableList.add("field12", new Object());

		Map<String, Object> testMap = null;
		try {
			testMap = XplatformUtils.convertVariableListToMap(variableList);
			logger.debug("testMap: {}", testMap);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testAddMapToVariableList() {
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("field1", "value1");
		dataMap.put("field2", Integer.MAX_VALUE);
		dataMap.put("field3", false);
		dataMap.put("field4", Long.MAX_VALUE);
		dataMap.put("field5", Float.MAX_VALUE);
		dataMap.put("field6", Double.MAX_VALUE);
		dataMap.put("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataMap.put("field8", Calendar.getInstance().getTime());
		dataMap.put("field9", Calendar.getInstance().getTime());
		dataMap.put("field10", Calendar.getInstance().getTime());
		dataMap.put("field11", (new String("field11")).getBytes());

		VariableList variableList = new VariableList();
		XplatformUtils.addMapToVariableList(dataMap, variableList);

		// check variable list
		int variableCount = variableList.size();
		logger.debug("variableCount: {}", variableCount);
		for (int variableIndex = 0; variableIndex < variableCount; variableIndex++) {
			Variable variable = variableList.get(variableIndex);
			logger.debug("variable: {}", variable);
			String variableName = variable.getName();
			Object variableValue = variable.getObject();
			logger.debug("variableName: {}, variableValue: {}", variableName,
					variableValue);
		}
	}

	@Test
	public void testConvertMapToVariableListReturn() {
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("field1", "value1");
		dataMap.put("field2", Integer.MAX_VALUE);
		dataMap.put("field3", false);
		dataMap.put("field4", Long.MAX_VALUE);
		dataMap.put("field5", Float.MAX_VALUE);
		dataMap.put("field6", Double.MAX_VALUE);
		dataMap.put("field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataMap.put("field8", Calendar.getInstance().getTime());
		dataMap.put("field9", Calendar.getInstance().getTime());
		dataMap.put("field10", Calendar.getInstance().getTime());
		dataMap.put("field11", (new String("field11")).getBytes());

		VariableList variableList = XplatformUtils
				.convertMapToVariableList(dataMap);

		// check variable list
		int variableCount = variableList.size();
		logger.debug("variableCount: {}", variableCount);
		for (int variableIndex = 0; variableIndex < variableCount; variableIndex++) {
			Variable variable = variableList.get(variableIndex);
			logger.debug("variable: {}", variable);
			String variableName = variable.getName();
			Object variableValue = variable.getObject();
			logger.debug("variableName: {}, variableValue: {}", variableName,
					variableValue);
		}
	}

	@Test
	public void testConvertDataSetToBatchUpdateDataDTO() {
		DataSet dataSet = new DataSet("testDataSet");
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
		dataSet.set(0, "field1", "insert1");
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

		dataSet.newRow();
		dataSet.set(1, "field1", "insert2");
		dataSet.set(1, "field2", Integer.MAX_VALUE);
		dataSet.set(1, "field3", false);
		dataSet.set(1, "field4", Long.MAX_VALUE);
		dataSet.set(1, "field5", Float.MAX_VALUE);
		dataSet.set(1, "field6", Double.MAX_VALUE);
		dataSet.set(1, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(1, "field8", Calendar.getInstance().getTime());
		dataSet.set(1, "field9", Calendar.getInstance().getTime());
		dataSet.set(1, "field10", Calendar.getInstance().getTime());
		dataSet.set(1, "field11", (new String("field11")).getBytes());

		dataSet.newRow();
		dataSet.set(2, "field1", "update1");
		dataSet.set(2, "field2", Integer.MAX_VALUE);
		dataSet.set(2, "field3", false);
		dataSet.set(2, "field4", Long.MAX_VALUE);
		dataSet.set(2, "field5", Float.MAX_VALUE);
		dataSet.set(2, "field6", Double.MAX_VALUE);
		dataSet.set(2, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(2, "field8", Calendar.getInstance().getTime());
		dataSet.set(2, "field9", Calendar.getInstance().getTime());
		dataSet.set(2, "field10", Calendar.getInstance().getTime());
		dataSet.set(2, "field11", (new String("field11")).getBytes());

		dataSet.newRow();
		dataSet.set(3, "field1", "update2");
		dataSet.set(3, "field2", Integer.MAX_VALUE);
		dataSet.set(3, "field3", false);
		dataSet.set(3, "field4", Long.MAX_VALUE);
		dataSet.set(3, "field5", Float.MAX_VALUE);
		dataSet.set(3, "field6", Double.MAX_VALUE);
		dataSet.set(3, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(3, "field8", Calendar.getInstance().getTime());
		dataSet.set(3, "field9", Calendar.getInstance().getTime());
		dataSet.set(3, "field10", Calendar.getInstance().getTime());
		dataSet.set(3, "field11", (new String("field11")).getBytes());

		dataSet.newRow();
		dataSet.set(4, "field1", "delete1");
		dataSet.set(4, "field2", Integer.MAX_VALUE);
		dataSet.set(4, "field3", false);
		dataSet.set(4, "field4", Long.MAX_VALUE);
		dataSet.set(4, "field5", Float.MAX_VALUE);
		dataSet.set(4, "field6", Double.MAX_VALUE);
		dataSet.set(4, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(4, "field8", Calendar.getInstance().getTime());
		dataSet.set(4, "field9", Calendar.getInstance().getTime());
		dataSet.set(4, "field10", Calendar.getInstance().getTime());
		dataSet.set(4, "field11", (new String("field11")).getBytes());

		dataSet.newRow();
		dataSet.set(5, "field1", "delete2");
		dataSet.set(5, "field2", Integer.MAX_VALUE);
		dataSet.set(5, "field3", false);
		dataSet.set(5, "field4", Long.MAX_VALUE);
		dataSet.set(5, "field5", Float.MAX_VALUE);
		dataSet.set(5, "field6", Double.MAX_VALUE);
		dataSet.set(5, "field7", BigDecimal.valueOf(Double.MAX_VALUE));
		dataSet.set(5, "field8", Calendar.getInstance().getTime());
		dataSet.set(5, "field9", Calendar.getInstance().getTime());
		dataSet.set(5, "field10", Calendar.getInstance().getTime());
		dataSet.set(5, "field11", (new String("field11")).getBytes());

		dataSet.startStoreDataChanges();
		dataSet.setRowType(0, DataSet.ROW_TYPE_INSERTED);
		dataSet.setRowType(1, DataSet.ROW_TYPE_INSERTED);
		dataSet.setRowType(2, DataSet.ROW_TYPE_UPDATED);
		dataSet.setRowType(3, DataSet.ROW_TYPE_UPDATED);
		dataSet.removeRow(5);
		dataSet.removeRow(4);

		try {
			BatchUpdateDataDTO batchUpdateDataDTO = XplatformUtils
					.convertDataSetToBatchUpdateDataDTO(dataSet, TestDTO.class);
			logger.debug("batchUpdateDataDTO: {}", batchUpdateDataDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
