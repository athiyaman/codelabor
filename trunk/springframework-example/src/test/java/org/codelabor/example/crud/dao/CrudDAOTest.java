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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/**/applicationContext*.xml")
public class CrudDAOTest {
	private final static Logger logger = LoggerFactory.getLogger(CrudDAOTest.class);
	@Autowired
	private ApplicationContext ctx;
	private CrudDAO crudDAO1;
	private CrudDTO crudDTO;

	@Before
	public void setUp() {
		crudDAO1 = ctx.getBean("crudDAO1", CrudDAO.class);
		crudDTO = new CrudDTO();
		crudDTO.setId("1");
		crudDTO.setData("value1");
	}

	@Test
	public void testInsert() {
		try {
			// test
			int affectedRowCount = crudDAO1.create(crudDTO);
			assertEquals(1, affectedRowCount);
			logger.debug("affectedRowCount: {}", affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
