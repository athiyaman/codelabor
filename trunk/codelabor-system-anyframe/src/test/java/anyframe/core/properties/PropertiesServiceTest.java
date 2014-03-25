package anyframe.core.properties;

import java.util.Iterator;

import org.anyframe.util.properties.PropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/**/applicationContext*.xml")
public class PropertiesServiceTest {
	private final static Logger logger = LoggerFactory
			.getLogger(PropertiesServiceTest.class);

	@Autowired
	private ApplicationContext context;
	private PropertiesService propertiesService;

	@Before
	public void setUp() throws Exception {
		propertiesService = (PropertiesService) context.getBean(
				"propertiesService", PropertiesService.class);
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
