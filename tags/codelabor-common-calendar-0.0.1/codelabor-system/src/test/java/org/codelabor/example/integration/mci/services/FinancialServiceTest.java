package org.codelabor.example.integration.mci.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.codelabor.example.integration.mci.services.FinancialService;
import org.codelabor.example.remoting.message.dtos.Saaa001001rOutputDTO.Saaa001001rOutstrSub;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class FinancialServiceTest extends AbstractDependencyInjectionSpringContextTests {

	private FinancialService financialService;

	@Override
	public void onSetUp() throws Exception {
		financialService = (FinancialService) applicationContext.getBean("exampleIntegrationMciFinancialService");
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext-*.xml" };
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testListUser() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
		try {
			Date fromDate = dateFormat.parse("20090701");
			Date toDate = dateFormat.parse("20090901");
			List list = financialService.search(fromDate, toDate);
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Saaa001001rOutstrSub sub = (Saaa001001rOutstrSub) iter.next();
				System.out.println(sub);
			}
			assertEquals(2, list.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
