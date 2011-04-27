package org.apache.commons.beanutils;

import static org.junit.Assert.fail;

import java.beans.PropertyDescriptor;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtilsTest {

	private Logger logger = LoggerFactory.getLogger(PropertyUtilsTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDescribe() {
		TestDTO testDTO = new TestDTO();
		try {
			Map<String, Object> propertiesMap = PropertyUtils.describe(testDTO);
			logger.debug("propertiesMap: {}", propertiesMap);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testGetPropertyDescriptors() {
		try {
			PropertyDescriptor[] propertyDescriptors = PropertyUtils
					.getPropertyDescriptors(TestDTO.class);
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				String propertyName = propertyDescriptor.getName();
				Class propertyType = propertyDescriptor.getPropertyType();
				logger.debug("name(): {}, type: {}", propertyName, propertyType);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
}
