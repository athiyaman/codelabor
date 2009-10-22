package org.codelabor.system.remoting.http.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EchoMessageHandlerServiceImpl implements MessageHandlerService {
	Log log = LogFactory.getLog(EchoMessageHandlerServiceImpl.class);

	public String handleMessage(String message) throws Exception {
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("message: ").append(message);
			log.debug(sb.toString());
		}
		return message;
	}

}
