package javax.sql;

import java.sql.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.AbstractSingleSpringContextTests;

public class DbcpDataSourceTest extends AbstractSingleSpringContextTests {
	private final static Logger logger = LoggerFactory
			.getLogger(DbcpDataSourceTest.class);
	private DataSource dataSource;

	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext-dataSource-dbcp.xml" };
	}

	public void onSetUp() throws Exception {
		this.dataSource = (DataSource) applicationContext
				.getBean("dbcpDataSource");
	}

	public void testGetConnection() {
		Connection connection = null;
		try {
			connection = DataSourceUtils.getConnection(dataSource);
			logger.debug("connection: {}", connection);
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}

	public void testGetMetaData() {
		Connection connection = null;
		try {
			connection = DataSourceUtils.getConnection(dataSource);
			logger.debug("product name: {}", connection.getMetaData()
					.getDatabaseProductName());
			logger.debug("product version: {}", connection.getMetaData()
					.getDatabaseProductVersion());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}
}
