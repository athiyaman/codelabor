package org.codelabor.system.sign.daos;

import java.util.ArrayList;
import java.util.List;

import org.codelabor.system.daos.BaseDAOImpl;
import org.codelabor.system.sign.dtos.SignDTO;

public class SignDAOImpl extends BaseDAOImpl implements SignDAO {

	public int insert(SignDTO signDTO) throws Exception {
		String insertQueryId = "system.insert.sign";
		List<Object> params = new ArrayList<Object>();
		params.add(idGenerationService.getNextIntegerId());
		params.add(signDTO.getSubject());
		params.add(signDTO.getSignedMessage());
		params.add(signDTO.getCertType());
		params.add(signDTO.getCertPem());
		return queryService.create(insertQueryId, params.toArray());
	}

	@SuppressWarnings("unchecked")
	public List<SignDTO> select() throws Exception {
		String selectQueryId = "system.select.sign.list";
		Object[] params = new Object[] {};
		return new ArrayList<SignDTO>(queryService.find(selectQueryId, params));
	}

}
