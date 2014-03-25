package org.codelabor.system.sign.managers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.sign.dtos.SignDTO;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import anyframe.core.query.IQueryService;

public class SignManagerTest extends AbstractDependencyInjectionSpringContextTests {

	private SignManager signManager;
	private IQueryService queryService;
	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	public void onSetUp() throws Exception {
		signManager = (SignManager) applicationContext.getBean("signManager");
		queryService = (IQueryService) applicationContext.getBean("oracleQueryService");

		// clear data
		// queryService.remove("system.delete.sign.list", new Object[] {});

	}

	@SuppressWarnings("unchecked")
	public void testSign() {
		// test
		SignDTO signDTO = new SignDTO();
		signDTO.setSubject("subject");
		signDTO.setSignedMessage("signedMessage");
		signDTO.setCertPem("certPem");
		signDTO.setCertType("certType");

		try {
			// sign test
			signManager.insert(signDTO);

			// assert
			String queryId = "system.select.sign.list";
			Object[] param = new Object[] {};
			List<SignDTO> signDTOList = (List<SignDTO>) queryService.find(queryId, param);
			assertTrue(signDTOList.size() > 0);

			// log
			if (log.isDebugEnabled()) {
				log.debug(signDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext*.xml" };
	}
}
