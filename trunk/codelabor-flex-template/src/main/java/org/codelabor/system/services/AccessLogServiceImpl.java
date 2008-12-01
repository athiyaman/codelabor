package org.codelabor.system.services;

import org.codelabor.system.dtos.AccessLogDTO;
import org.codelabor.system.exceptions.CommonException;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.codelabor.system.managers.AccessLogManager;

public class AccessLogServiceImpl extends BaseServiceImpl implements
		AccessLogService {

	private AccessLogManager accessLogManager;

	public void accessLog(AccessLogDTO accessLogDTO) throws Exception {
		try {
			accessLogManager.accessLog(accessLogDTO);
		} catch (Exception e) {
			String messageCode = "ERROR-ACCESS-LOG-0000";
			String messageKey = "error.access.log";
			Object[] messageParams = new Object[] {};
			CommonException commonException = new RollbackCommonException(
					messageSource, messageKey, messageParams, e);
			commonException.setMessageCode(messageCode);
			throw commonException;
		}
	}

	public AccessLogManager getAccessLogManager() {
		return accessLogManager;
	}

	public void setAccessLogManager(AccessLogManager accessLogManager) {
		this.accessLogManager = accessLogManager;
	}

}
