package org.codelabor.example.transaction.services;

import java.util.Collection;

import org.codelabor.example.emp.dtos.EmpDTO;
import org.codelabor.example.transaction.services.App1Service;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import anyframe.core.query.IQueryService;

public class DeclarativeTransactionTest extends
		AbstractDependencyInjectionSpringContextTests {

	private App1Service app1Service;

	@Override
	protected void onTearDown() throws Exception {
		super.onTearDown();
		// queryService.remove(arg0, arg1);
	}

	private IQueryService queryService;

	private Collection<EmpDTO> empDTOList;

	@Override
	public void onSetUp() throws Exception {
		app1Service = (App1Service) applicationContext.getBean("app1Service");
		queryService = (IQueryService) applicationContext
				.getBean("oracleQueryService");

		// clear data
		// String queryId = "example.delete.emp.list";
		// Object[] params = new Object[] {};
		// queryService.remove(queryId, params);
	}

	@SuppressWarnings("unchecked")
	public void testMethod1011() throws Exception {
		try {
			app1Service.method1011();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// assert
				String queryId = "example.select.emp";
				Object[] params = new Object[] { 10 };
				empDTOList = queryService.find(queryId, params);
				boolean is10Commited = (empDTOList.size() > 0);

				params = new Object[] { 11 };
				empDTOList = queryService.find(queryId, params);
				boolean is11Commited = (empDTOList.size() > 0);

				assertTrue(is10Commited && is11Commited);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void testMethod1213() throws Exception {
		try {
			app1Service.method1213();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// assert
				String queryId = "example.select.emp";
				Object[] params = new Object[] { 12 };
				empDTOList = queryService.find(queryId, params);
				boolean is12Commited = (empDTOList.size() > 0);

				assertFalse(is12Commited);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void testMethod1415() throws Exception {
		try {
			app1Service.method1415();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// assert
				String queryId = "example.select.emp";
				Object[] params = new Object[] { 14 };
				empDTOList = queryService.find(queryId, params);
				boolean is14Commited = (empDTOList.size() > 0);

				assertTrue(is14Commited);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void testMethod161317() throws Exception {
		try {
			app1Service.method161317();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// assert
				String queryId = "example.select.emp";
				Object[] params = new Object[] { 12 };
				empDTOList = queryService.find(queryId, params);
				boolean is12Commited = (empDTOList.size() > 0);

				params = new Object[] { 17 };
				empDTOList = queryService.find(queryId, params);
				boolean is17Commited = (empDTOList.size() > 0);

				assertFalse(is12Commited || is17Commited);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void testMethod181519() throws Exception {
		try {
			app1Service.method181519();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// assert
				String queryId = "example.select.emp";
				Object[] params = new Object[] { 18 };
				empDTOList = queryService.find(queryId, params);
				boolean is18Commited = (empDTOList.size() > 0);

				params = new Object[] { 19 };
				empDTOList = queryService.find(queryId, params);
				boolean is19Commited = (empDTOList.size() > 0);

				assertTrue(is18Commited && is19Commited);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void testMethod2013() throws Exception {
		try {
			app1Service.method2013();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// assert
				String queryId = "example.select.emp";
				Object[] params = new Object[] { 20 };
				empDTOList = queryService.find(queryId, params);
				boolean is20Commited = (empDTOList.size() > 0);

				assertFalse(is20Commited);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void testMethod2115() throws Exception {
		try {
			app1Service.method2115();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// assert
				String queryId = "example.select.emp";
				Object[] params = new Object[] { 21 };
				empDTOList = queryService.find(queryId, params);
				boolean is21Commited = (empDTOList.size() > 0);

				assertTrue(is21Commited);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void testMethod221323() throws Exception {
		try {
			app1Service.method221323();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// assert
				String queryId = "example.select.emp";
				Object[] params = new Object[] { 22 };
				empDTOList = queryService.find(queryId, params);
				boolean is22Commited = (empDTOList.size() > 0);

				params = new Object[] { 23 };
				empDTOList = queryService.find(queryId, params);
				boolean is23Commited = (empDTOList.size() > 0);

				assertFalse(is22Commited || is23Commited);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void testMethod241525() throws Exception {
		try {
			app1Service.method241525();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// assert
				String queryId = "example.select.emp";
				Object[] params = new Object[] { 24 };
				empDTOList = queryService.find(queryId, params);
				boolean is24Commited = (empDTOList.size() > 0);

				params = new Object[] { 25 };
				empDTOList = queryService.find(queryId, params);
				boolean is25Commited = (empDTOList.size() > 0);

				assertTrue(is24Commited && is25Commited);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public void testClearData() throws Exception {
		String queryId = "example.delete.emp";
		queryService.remove(queryId, new String[] { "10" });
		queryService.remove(queryId, new String[] { "11" });
		queryService.remove(queryId, new String[] { "14" });
		queryService.remove(queryId, new String[] { "18" });
		queryService.remove(queryId, new String[] { "19" });
		queryService.remove(queryId, new String[] { "21" });
		queryService.remove(queryId, new String[] { "24" });
		queryService.remove(queryId, new String[] { "25" });
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}

}
