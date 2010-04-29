package anyframe.services.query;

import java.util.List;
import java.util.Map;

import org.codelabor.system.test.BaseTestCase;
import org.junit.Test;

import anyframe.core.query.IQueryService;
import anyframe.core.query.QueryServiceException;

public class PagingTest extends BaseTestCase {

	protected IQueryService queryService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();

		queryService = (IQueryService) applicationContext
				.getBean("oracleQueryService");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindWithRowCountStringObjectArray() {
		String selectQueryId = "example.select.emp.list";
		Object[] params = new Object[] {};
		try {
			Map resultMap = queryService
					.findWithRowCount(selectQueryId, params);
			List resultList = (List) resultMap.get(IQueryService.LIST);
			int totalCount = ((Long) resultMap.get(IQueryService.COUNT))
					.intValue();
			logger.info("totalCount: " + totalCount);
			logger.info("resultList.size(): " + resultList.size());
			logger.info("resultList: " + resultList);

			// assert
			assertEquals(14, totalCount);
			assertEquals(14, resultList.size());

		} catch (QueryServiceException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindWithRowCountStringObjectArrayInt() {
		String selectQueryId = "example.select.emp.list";
		Object[] params = new Object[] {};
		try {
			int pageIndex = 1;
			Map resultMap = queryService.findWithRowCount(selectQueryId,
					params, pageIndex);
			List resultList = (List) resultMap.get(IQueryService.LIST);
			int totalCount = ((Long) resultMap.get(IQueryService.COUNT))
					.intValue();
			logger.info("pageIndex: " + pageIndex);
			logger.info("totalCount: " + totalCount);
			logger.info("resultList.size(): " + resultList.size());
			logger.info("resultList: " + resultList);

			// assert
			assertEquals(14, totalCount);
			assertEquals(10, resultList.size());

		} catch (QueryServiceException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindWithRowCountStringObjectArrayIntInt() {
		String selectQueryId = "example.select.emp.list";
		Object[] params = new Object[] {};
		try {
			// last page - 1
			int pageIndex = 2;
			int pageSize = 5;
			Map resultMap = queryService.findWithRowCount(selectQueryId,
					params, pageIndex, pageSize);
			List resultList = (List) resultMap.get(IQueryService.LIST);
			int totalCount = ((Long) resultMap.get(IQueryService.COUNT))
					.intValue();
			logger.info("pageIndex: " + pageIndex);
			logger.info("pageSize: " + pageSize);
			logger.info("totalCount: " + totalCount);
			logger.info("resultList.size(): " + resultList.size());
			logger.info("resultList: " + resultList);

			// assert
			assertEquals(14, totalCount);
			assertEquals(5, resultList.size());

			// last page
			pageIndex = 3;
			resultMap = queryService.findWithRowCount(selectQueryId, params,
					pageIndex, pageSize);
			resultList = (List) resultMap.get(IQueryService.LIST);
			totalCount = ((Long) resultMap.get(IQueryService.COUNT)).intValue();
			logger.info("pageIndex: " + pageIndex);
			logger.info("pageSize: " + pageSize);
			logger.info("totalCount: " + totalCount);
			logger.info("resultList.size(): " + resultList.size());
			logger.info("resultList: " + resultList);

			// assert
			assertEquals(14, totalCount);
			assertEquals(4, resultList.size());

		} catch (QueryServiceException e) {
			e.printStackTrace();
		}
	}
}
