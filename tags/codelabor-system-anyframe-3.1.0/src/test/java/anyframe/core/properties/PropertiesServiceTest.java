package anyframe.core.properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.anyframe.util.properties.PropertiesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/**/applicationContext*.xml")
public class PropertiesServiceTest {
	private final static Logger logger = LoggerFactory.getLogger(PropertiesServiceTest.class);

	@Autowired
	private ApplicationContext context;
	private PropertiesService propertiesService;

	@Before
	public void setUp() throws Exception {
		propertiesService = (PropertiesService) context.getBean("propertiesService", PropertiesService.class);
	}

	@Test
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

	@Test
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
