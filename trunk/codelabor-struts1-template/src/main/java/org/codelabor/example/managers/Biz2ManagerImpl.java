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

package org.codelabor.example.managers;

import java.util.Calendar;

import org.codelabor.system.managers.BaseManagerImpl;

import anyframe.core.query.IQueryService;

/**
 * @author Sang Jae Shin
 * 
 */
public class Biz2ManagerImpl extends BaseManagerImpl implements Biz2Manager {

	private IQueryService queryService = null;

	public IQueryService getQueryService() {
		return queryService;
	}

	public void setQueryService(IQueryService queryService) {
		this.queryService = queryService;
	}

	public void method20() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 20, "USER20", "JOB20", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);

	}

	public void method21() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 21, "USER21", "JOB21", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method22() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 22, "USER22", "JOB22", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method23() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 23, "USER23", "JOB23", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method24() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 24, "USER24", "JOB24", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method25() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 25, "USER25", "JOB25", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}
}
