package org.codelabor.system.daos;

import org.codelabor.system.dtos.AccessLogDTO;

public interface AccessLogDAO {
	public int insert(AccessLogDTO accessLogDTO) throws Exception;
}
