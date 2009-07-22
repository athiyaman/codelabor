package anyframe.services.properties;

import java.util.Iterator;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import anyframe.core.properties.IPropertiesService;

public class PropertiesServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	protected IPropertiesService propertiesService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		propertiesService = (IPropertiesService) applicationContext
				.getBean("propertiesService");
	}

	@SuppressWarnings("unchecked")
	public void testGetKeys() {
		try {
			// test
			Iterator<String> iter = propertiesService.getKeys();

			// assert
			assertTrue(iter.hasNext());

			// debug properties
			while (iter.hasNext()) {
				String key = iter.next();
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(key).append(": ").append(
						propertiesService.getString(key));
				logger.debug(stringBuilder);
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

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
