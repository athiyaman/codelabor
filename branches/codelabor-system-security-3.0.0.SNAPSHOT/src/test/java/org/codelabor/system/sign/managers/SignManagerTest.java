package org.codelabor.system.sign.managers;

import java.util.List;

import org.codelabor.system.sign.dtos.SignDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractSingleSpringContextTests;

import anyframe.core.query.IQueryService;

@SuppressWarnings("deprecation")
public class SignManagerTest extends AbstractSingleSpringContextTests {

	private SignManager signManager;
	private IQueryService queryService;
	private final Logger logger = LoggerFactory
			.getLogger(SignManagerTest.class);

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:/**/applicationContext-configurableCallBack.xml",
				"classpath:/**/applicationContext-baseManager.xml",
				"classpath:/**/applicationContext-baseDAO.xml",
				"classpath:/**/applicationContext-applicationContext-signManager.xml",
				"classpath:/**/applicationContext-queryService-oracle.xml",
				"classpath:/**/applicationContext-dataSourceService-oracle.xml",
				"classpath:/**/applicationContext-lobHandler.xml",
				"classpath:/**/applicationContext-nativeJdbcExtractor.xml" };
	}

	@Override
	public void onSetUp() throws Exception {
		signManager = (SignManager) applicationContext.getBean("signManager");
		queryService = (IQueryService) applicationContext
				.getBean("oracleQueryService");

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
			List<SignDTO> signDTOList = (List<SignDTO>) queryService.find(
					queryId, param);
			assertTrue(signDTOList.size() > 0);

			// log
			logger.debug("signDTO {}", signDTO);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
