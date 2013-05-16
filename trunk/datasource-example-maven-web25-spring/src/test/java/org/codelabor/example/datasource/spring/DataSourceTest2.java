package org.codelabor.example.datasource.spring;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/**/applicationContext2.xml")
@ActiveProfiles("local")
public class DataSourceTest2 {

	Logger logger = LoggerFactory.getLogger(DataSourceTest2.class);

	@Autowired
	ApplicationContext context;

	@Test
	public void test() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		logger.debug("dataSource: {}", ds);
	}

}
