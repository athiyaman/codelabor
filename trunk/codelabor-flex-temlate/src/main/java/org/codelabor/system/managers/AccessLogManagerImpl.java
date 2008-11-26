package org.codelabor.system.managers;

import org.codelabor.system.daos.AccessLogDAO;
import org.codelabor.system.dtos.AccessLogDTO;

public class AccessLogManagerImpl extends BaseManagerImpl implements
		AccessLogManager {

	private AccessLogDAO accessLogDAO;

	public AccessLogDAO getBpmDAO() {
		return accessLogDAO;
	}

	public void setAccessLogAO(AccessLogDAO accessLogDAO) {
		this.accessLogDAO = accessLogDAO;
	}

	public void accessLog(AccessLogDTO accessLogDTO) throws Exception {
		this.accessLogDAO.insert(accessLogDTO);
	}

	public AccessLogDAO getHttpAdapterDAO() {
		return accessLogDAO;
	}

	public void setAccessLogDAO(AccessLogDAO accessLogDAO) {
		this.accessLogDAO = accessLogDAO;
	}
}
