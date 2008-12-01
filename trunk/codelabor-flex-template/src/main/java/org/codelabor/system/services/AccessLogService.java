package org.codelabor.system.services;

import org.codelabor.system.dtos.AccessLogDTO;

public interface AccessLogService {
	public void accessLog(AccessLogDTO accessLogDTO) throws Exception;
}
