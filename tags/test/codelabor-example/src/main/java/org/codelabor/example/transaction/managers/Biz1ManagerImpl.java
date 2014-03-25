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

package org.codelabor.example.transaction.managers;

import java.util.Calendar;

import org.apache.avalon.framework.thread.ThreadSafe;
import org.codelabor.system.exceptions.NoRollbackCommonException;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.codelabor.system.managers.BaseManagerImpl;

import anyframe.core.query.IQueryService;

/**
 * @author Sang Jae Shin
 * 
 */
public class Biz1ManagerImpl extends BaseManagerImpl implements ThreadSafe,
		Biz1Manager {

	private IQueryService queryService = null;

	public IQueryService getQueryService() {
		return queryService;
	}

	public void setQueryService(IQueryService queryService) {
		this.queryService = queryService;
	}

	public void method10() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 10, "USER10", "JOB10", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method11() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 11, "USER11", "JOB11", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method12() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 12, "USER12", "JOB12", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method13() throws Exception {
		throw new RollbackCommonException();
	}

	public void method14() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 14, "USER14", "JOB14", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method15() throws Exception {
		throw new NoRollbackCommonException();
	}

	public void method16() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 16, "USER16", "JOB16", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method17() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 17, "USER17", "JOB17", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method18() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 18, "USER18", "JOB18", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}

	public void method19() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		String queryId = "example.insert.emp";

		Object[] param = new Object[] { 19, "USER19", "JOB19", 0, calendar, 0,
				0, 0 };
		queryService.create(queryId, param);
	}
}
