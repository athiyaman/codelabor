package org.codelabor.system.daos;

import org.codelabor.system.dtos.AccessLogDTO;

public class AccessLogDAOImpl extends BaseDAOImpl implements AccessLogDAO {

	public int insert(AccessLogDTO accessLogDTO) throws Exception {
		accessLogDTO.setSeq(idGenerationService.getNextIntegerId());
		return this.queryService.create(accessLogDTO);
	}
}
