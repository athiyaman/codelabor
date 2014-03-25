/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.example.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.codelabor.example.crud.dto.CrudDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * 
 */
@Repository("crudDAO")
public class CrudDAOImpl implements CrudDAO {
	private Logger logger = LoggerFactory.getLogger(CrudDAOImpl.class);

	@Inject
	@Named("dataSource")
	private DataSource dataSource;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.crud.dao.CrudDAO#create(org.codelabor.example.crud
	 * .dto.CrudDTO)
	 */
	public int insert(CrudDTO crudDTO) throws Exception {
		Connection connection = DataSourceUtils.getConnection(dataSource);
		PreparedStatement preparedStatement = null;
		try {
			String sql = "INSERT INTO EXAMPLE_CRUD VALUES (?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, crudDTO.getId());
			preparedStatement.setString(2, crudDTO.getData());
			logger.debug("preparedStatement: {}", preparedStatement);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.crud.dao.CrudDAO#read(java.lang.String)
	 */
	public CrudDTO select(String id) throws Exception {
		Connection connection = DataSourceUtils.getConnection(dataSource);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT ID, DATA FROM EXAMPLE_CRUD WHERE ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			logger.debug("preparedStatement: {}", preparedStatement);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				CrudDTO crudDTO = new CrudDTO();
				crudDTO.setId(resultSet.getString(1));
				crudDTO.setData(resultSet.getString(2));
				return crudDTO;
			} else {
				throw new Exception("No such data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.crud.dao.CrudDAO#update(org.codelabor.example.crud
	 * .dto.CrudDTO)
	 */
	public int update(CrudDTO crudDTO) throws Exception {
		Connection connection = DataSourceUtils.getConnection(dataSource);
		PreparedStatement preparedStatement = null;
		try {
			String sql = "UPDATE EXAMPLE_CRUD SET DATA = ? WHERE ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, crudDTO.getData());
			preparedStatement.setString(2, crudDTO.getId());
			logger.debug("preparedStatement: {}", preparedStatement);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codelabor.example.crud.dao.CrudDAO#delete(java.lang.String)
	 */
	public int delete(String id) throws Exception {
		Connection connection = DataSourceUtils.getConnection(dataSource);
		PreparedStatement preparedStatement = null;
		try {
			String sql = "DELETE EXAMPLE_CRUD WHERE ID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			logger.debug("preparedStatement: {}", preparedStatement);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}

}
