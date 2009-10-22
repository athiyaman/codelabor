package org.codelabor.example.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.services.StringHandlerService;

public class DefaultStringHandleServiceImpl implements StringHandlerService {
	Log log = LogFactory.getLog(DefaultStringHandleServiceImpl.class);

	public String handleString(String message) throws Exception {
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("message: ").append(message);
			log.debug(sb.toString());
		}
		return message;
	}

}
