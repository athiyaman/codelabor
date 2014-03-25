package org.codelabor.example.crud.services;

import java.util.List;

import junit.framework.Assert;

import org.codelabor.example.crud.dtos.CrudDTO;
import org.codelabor.system.test.BaseTestCase;

public class CrudServiceTest extends BaseTestCase {

	private CrudService crudService;

	@Override
	public void onSetUp() throws Exception {
		crudService = (CrudService) applicationContext
				.getBean("exampleCrudCrudService");
	}

	public void testRead() {
		try {
			int crudId = 0;
			CrudDTO crudDTO = crudService.read(crudId);
			assertNotNull(crudDTO);
			assertEquals(0, crudDTO.getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testList1() {
		try {
			List<CrudDTO> crudDTOList = crudService.list();
			assertNotNull(crudDTOList);
			assertTrue(crudDTOList.size() > 0);
		} catch (Exception e) {
			fail();
		}
	}

	@SuppressWarnings("unchecked")
	public void testList2() {
		try {
			List crudDTOList = crudService.list("V%");
			assertNotNull(crudDTOList);
			assertTrue(crudDTOList.size() > 0);
		} catch (Exception e) {
			fail();
		}
	}

	public void testCreate() {
		try {
			CrudDTO crudDTO = new CrudDTO();
			crudDTO.setField1("VALUE(C)");
			crudDTO.setField2("VALUE(C)");
			int affectedRowCount = crudService.create(crudDTO);
			assertTrue(affectedRowCount == 1);
		} catch (Exception e) {
			fail();
		}
	}

	public void testUpdate() {
		try {
			CrudDTO crudDTO = new CrudDTO();
			crudDTO.setId(0);
			crudDTO.setField1("VALUE(U)");
			crudDTO.setField2("VALUE(U)");
			int affectedRowCount = crudService.update(crudDTO);
			assertTrue(affectedRowCount == 1);
		} catch (Exception e) {
			fail();
		}
	}

	public void testDelete() {
		try {
			int[] crudIdList = new int[] { 1, 2, 3 };
			int affectedRowCount = crudService.delete(crudIdList);
			Assert.assertEquals(3, affectedRowCount);
		} catch (Exception e) {
			fail();
		}
	}
}
