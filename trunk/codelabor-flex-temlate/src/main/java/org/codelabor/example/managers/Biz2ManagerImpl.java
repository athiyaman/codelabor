package org.codelabor.example.managers;

import java.util.Calendar;

import org.codelabor.system.managers.BaseManagerImpl;

import anyframe.core.query.IQueryService;

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
