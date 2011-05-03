package javax.sql;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/**/applicationContext*.xml")
public class DataSourceTest {
	private Logger logger = LoggerFactory.getLogger(DataSourceTest.class);
	@Autowired
	private ApplicationContext ctx;
	private DataSource dataSource;

	@Before
	public void setUp() {
		dataSource = (DataSource) ctx.getBean("dataSource", DataSource.class);
	}

	@Test
	public void testGetConnection() {
		Connection connection = null;
		try {
			connection = DataSourceUtils.getConnection(dataSource);
			logger.debug("connection: {}", connection);
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}

	@Test
	public void testGetMetaData() {
		Connection connection = null;
		try {
			connection = DataSourceUtils.getConnection(dataSource);
			logger.debug("product name: {}", connection.getMetaData().getDatabaseProductName());
			logger.debug("product version: {}", connection.getMetaData().getDatabaseProductVersion());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}
}
