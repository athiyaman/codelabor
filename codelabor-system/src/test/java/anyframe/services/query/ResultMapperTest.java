package anyframe.services.query;

import java.util.Collection;
import java.util.Iterator;

import org.codelabor.example.emp.dtos.EmpDTO;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import anyframe.core.query.IQueryService;
import anyframe.core.query.QueryServiceException;

public class ResultMapperTest extends
		AbstractDependencyInjectionSpringContextTests {

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
		String selectQueryId = "example.select.emp.list2";
		Object[] params = new Object[] {};
		try {
			Collection result = queryService.find(selectQueryId, params);
			Iterator iterator = result.iterator();
			while (iterator.hasNext()) {
				EmpDTO empDTO = (EmpDTO) iterator.next();
				logger.debug(empDTO);
			}
			// assert

		} catch (QueryServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
