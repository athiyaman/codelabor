package net.sf.log4jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * Anyframe Java용 데이터 소스 스파이
 * 
 * @author Shin Sangjae
 * 
 */
public class AnyframeDataSourceSpy implements DataSource {
	/**
	 * 데이터 소스
	 */
	private DataSource dataSource = null;

	/**
	 * 로거
	 */
	static final SpyLogDelegator log = SpyLogFactory.getSpyLogDelegator();

	/**
	 * RDBMS Specifics
	 */
	static RdbmsSpecifics defaultRdbmsSpecifics = new RdbmsSpecifics();

	/**
	 * 생성자
	 */
	public AnyframeDataSourceSpy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#getConnection()
	 */
	public Connection getConnection() throws SQLException {
		return getWrappedConnection(dataSource.getConnection());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#getConnection(java.lang.String,
	 * java.lang.String)
	 */
	public Connection getConnection(String username, String password)
			throws SQLException {
		return getWrappedConnection(dataSource
				.getConnection(username, password));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#getLogWriter()
	 */
	public PrintWriter getLogWriter() throws SQLException {
		return dataSource.getLogWriter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#getLoginTimeout()
	 */
	public int getLoginTimeout() throws SQLException {
		return dataSource.getLoginTimeout();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
	 */
	public void setLogWriter(PrintWriter out) throws SQLException {
		dataSource.setLogWriter(out);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#setLoginTimeout(int)
	 */
	public void setLoginTimeout(int seconds) throws SQLException {
		dataSource.setLoginTimeout(seconds);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	/**
	 * 래핑된 커넥션을 가져온다.
	 * 
	 * @param connection
	 *            커넥션
	 * @return
	 */
	private Connection getWrappedConnection(Connection connection) {
		if (log.isJdbcLoggingEnabled()) {
			ConnectionSpy connectionSpy = new ConnectionSpy(connection);
			connectionSpy.setRdbmsSpecifics(defaultRdbmsSpecifics);
			return connectionSpy;
		} else {
			return connection;
		}
	}

	/**
	 * 데이터 소스를 설정한다.
	 * 
	 * @param dataSource
	 *            데이터 소스
	 */
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
	}
}
