package org.codelabor.example.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.codelabor.example.dtos.CrudDTO;
import org.codelabor.system.test.BaseTestCase;

public class CrudServiceTest extends BaseTestCase {

	private CrudService crudService;

	@Override
	public void onSetUp() throws Exception {
		crudService = (CrudService) applicationContext.getBean("example.crudService");
	}

	public void testRead() {
		try {
			String crudId = "0";
			Map crudMap = crudService.read(crudId);
			assertNotNull(crudMap);
			assertEquals("0", ((BigDecimal) crudMap.get("id")).toString());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testList1() {
		try {
			List crudList = crudService.list();
			assertNotNull(crudList);
			assertTrue(crudList.size() > 0);
		} catch (Exception e) {
			fail();
		}
	}

	@SuppressWarnings("unchecked")
	public void testList2() {
		try {
			List crudList = crudService.list("V%");
			assertNotNull(crudList);
			assertTrue(crudList.size() > 0);
		} catch (Exception e) {
			fail();
		}
	}

	public void testCreate() {
		try {
			CrudDTO crudDTO = new CrudDTO();
			crudDTO.setField1("TEST VALUE (C)");
			crudDTO.setField2("TEST VALUE (C)");
			int affectedRowCount = crudService.create(crudDTO);
			assertTrue(affectedRowCount == 1);
		} catch (Exception e) {
			fail();
		}
	}

	public void testUpdate() {
		try {
			CrudDTO crudDTO = new CrudDTO();
			crudDTO.setId("0");
			crudDTO.setField1("TEST VALUE (U)");
			crudDTO.setField2("TEST VALUE (U)");
			int affectedRowCount = crudService.update(crudDTO);
			assertTrue(affectedRowCount == 1);
		} catch (Exception e) {
			fail();
		}
	}

	public void testDelete() {
		try {
			String[] crudIdList = new String[] { "1", "2", "3" };
			int affectedRowCount = crudService.delete(crudIdList);
			assertTrue(affectedRowCount == 3);
		} catch (Exception e) {
			fail();
		}
	}
}
