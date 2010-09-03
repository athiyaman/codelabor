package anyframe.services.query;

import java.util.Collection;
import java.util.Iterator;

import org.codelabor.example.dtos.EmpDTO;
import org.codelabor.system.test.BaseTestCase;
import org.junit.Test;

import anyframe.core.query.IQueryService;
import anyframe.core.query.QueryServiceException;

public class ResultMapperTest extends BaseTestCase {

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
		String selectQueryId = "example.select.emp.list2";
		Object[] params = new Object[] {};
		try {
			Collection result = queryService.find(selectQueryId, params);
			Iterator iterator = result.iterator();
			while (iterator.hasNext()) {
				EmpDTO empDTO = (EmpDTO) iterator.next();
				log.debug(empDTO);
			}
			// assert

		} catch (QueryServiceException e) {
			e.printStackTrace();
		}
	}
}
