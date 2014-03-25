package org.codelabor.example.crud.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.codelabor.example.crud.dto.CrudDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/**/applicationContext*.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CrudDAOTest {
	private final static Logger logger = LoggerFactory.getLogger(CrudDAOTest.class);
	@Autowired
	private ApplicationContext ctx;
	private CrudDAO crudDAO;
	private CrudDTO crudDTO;

	@Before
	public void setUp() {
		crudDAO = ctx.getBean("crudDAO", CrudDAO.class);
		crudDTO = new CrudDTO();
		crudDTO.setId("1");
		crudDTO.setData("value1");
	}

	@Test
	public void testInsert() {
		try {
			int affectedRowCount = crudDAO.insert(crudDTO);
			assertEquals(1, affectedRowCount);
			logger.debug("affectedRowCount: {}", affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testUpdate() {
		try {
			// insert
			int affectedRowCount = crudDAO.insert(crudDTO);
			assertEquals(1, affectedRowCount);
			logger.debug("affectedRowCount: {}", affectedRowCount);

			// update
			crudDTO = new CrudDTO();
			crudDTO.setId("1");
			crudDTO.setData("value1 (modified)");
			affectedRowCount = crudDAO.update(crudDTO);
			assertEquals(1, affectedRowCount);
			logger.debug("affectedRowCount: {}", affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSelect() {
		try {
			// insert
			int affectedRowCount = crudDAO.insert(crudDTO);
			assertEquals(1, affectedRowCount);
			logger.debug("affectedRowCount: {}", affectedRowCount);

			// select
			CrudDTO crudDTO = crudDAO.select("1");
			logger.debug("crudDTO: {}", crudDTO);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testDelete() {
		try {
			// insert
			int affectedRowCount = crudDAO.insert(crudDTO);
			assertEquals(1, affectedRowCount);
			logger.debug("affectedRowCount: {}", affectedRowCount);

			// delete
			affectedRowCount = crudDAO.delete("1");
			assertEquals(1, affectedRowCount);
			logger.debug("affectedRowCount: {}", affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
