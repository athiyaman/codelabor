package org.codelabor.example.daos;

import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class HelloWorldDAOImpl implements HelloWorldDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldDAOImpl.class);
	protected String greeting;
	protected DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String sayHello() throws Exception {
		Connection connection = null;
		try {
			logger.debug("sayHello()");
			connection = DataSourceUtils.getConnection(dataSource);
			logger.debug("connection: {}", connection);
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
		return greeting;
	}
}
