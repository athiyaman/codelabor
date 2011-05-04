package org.codelabor.example.crud.service;

import static org.junit.Assert.fail;

import org.codelabor.example.crud.dto.CrudDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/**/applicationContext*.xml")
// @TransactionConfiguration(transactionManager = "transactionManager",
// defaultRollback = true)
// @Transactional
public class CrudServiceTest {

	@Autowired
	private ApplicationContext ctx;
	private CrudService crudService;
	private CrudDTO crudDTO;

	@Before
	public void setUp() {
		crudService = ctx.getBean("crudService", CrudService.class);
		crudDTO = new CrudDTO();
		crudDTO.setId("1");
		crudDTO.setData("value1");
	}

	@Test
	public void testInsert() {
		try {
			crudService.register(crudDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
