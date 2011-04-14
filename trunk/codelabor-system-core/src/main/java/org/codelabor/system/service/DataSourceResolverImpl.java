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
package org.codelabor.system.service;

import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;


/**
 * @author bomber.shin
 *
 */
public class DataSourceResolverImpl implements DataSourceResolver, InitializingBean {

	private Logger logger = LoggerFactory.getLogger(DataSourceResolverImpl.class);
	private Map<Object, DataSource> targetDataSources;

	/* (non-Javadoc)
	 * @see gscm.system.service.DataSourceResolver#resolveDataSource(java.lang.String)
	 */
	public DataSource resolveDataSource(String lookupKey) {
		return targetDataSources.get(lookupKey);
	}

	/**
	 * @param targetDataSources the targetDataSources to set
	 */
	public void setTargetDataSources(Map<Object, DataSource> targetDataSources) {
		this.targetDataSources = targetDataSources;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		logger.debug("targetDataSources: {}", targetDataSources);
	}

}
