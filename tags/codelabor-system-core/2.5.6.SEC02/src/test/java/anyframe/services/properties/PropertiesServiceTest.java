package anyframe.services.properties;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

import anyframe.core.properties.IPropertiesService;

public class PropertiesServiceTest extends AbstractSingleSpringContextTests {
	private final static Logger logger = LoggerFactory
			.getLogger(PropertiesServiceTest.class);

	protected IPropertiesService propertiesService;

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-configurableCallBack.xml",
				"classpath:/**/applicationContext-messageSource.xml",
				"classpath:/**/applicationContext-propertiesService.xml" };
	}

	@Override
	protected void onSetUp() throws Exception {
		propertiesService = (IPropertiesService) applicationContext
				.getBean("propertiesService");
	}

	@SuppressWarnings("unchecked")
	public void testGetKeys() {
		try {
			// test
			Iterator<String> iter = propertiesService.getKeys();

			// debug properties
			while (iter.hasNext()) {
				String key = iter.next();
				logger.debug("{}: {}", key, propertiesService.getString(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testGetString() {
		try {
			// test
			String value = propertiesService.getString("key1");

			// assert
			assertEquals("value1", value);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
