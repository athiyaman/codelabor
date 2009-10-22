package org.codelabor.example.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.services.StringHandlerService;

public class EchoServiceImpl implements StringHandlerService {
	Log log = LogFactory.getLog(EchoServiceImpl.class);

	public String handleString(String message) throws Exception {
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("message: ").append(message);
			log.debug(sb.toString());
		}
		return message;
	}

}
