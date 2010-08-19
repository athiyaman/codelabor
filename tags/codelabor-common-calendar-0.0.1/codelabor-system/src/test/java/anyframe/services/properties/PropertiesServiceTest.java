package anyframe.services.properties;

import java.util.Iterator;

import org.codelabor.system.test.BaseTestCase;

import anyframe.core.properties.IPropertiesService;

public class PropertiesServiceTest extends BaseTestCase {

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
				log.debug(stringBuilder);
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

	public void testGetCnDnList() {
		try {
			// test
			String cnDnList = propertiesService.getString("cadn.list");

			System.out.println(cnDnList);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
