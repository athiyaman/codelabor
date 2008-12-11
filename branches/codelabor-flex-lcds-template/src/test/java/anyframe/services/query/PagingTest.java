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
				.getBean("queryService");
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
			log.info("totalCount: " + totalCount);
			log.info("resultList.size(): " + resultList.size());
			log.info("resultList: " + resultList);

			// assert
			assertEquals(14, totalCount);
			assertEquals(10, resultList.size());

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
			log.info("pageIndex: " + pageIndex);
			log.info("totalCount: " + totalCount);
			log.info("resultList.size(): " + resultList.size());
			log.info("resultList: " + resultList);

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
			int pageIndex = 2;
			int pageSize = 5;
			Map resultMap = queryService.findWithRowCount(selectQueryId,
					params, pageIndex, pageSize);
			List resultList = (List) resultMap.get(IQueryService.LIST);
			int totalCount = ((Long) resultMap.get(IQueryService.COUNT))
					.intValue();
			log.info("pageIndex: " + pageIndex);
			log.info("pageSize: " + pageSize);
			log.info("totalCount: " + totalCount);
			log.info("resultList.size(): " + resultList.size());
			log.info("resultList: " + resultList);

			// assert
			assertEquals(14, totalCount);
			assertEquals(5, resultList.size());

		} catch (QueryServiceException e) {
			e.printStackTrace();
		}
	}
}
