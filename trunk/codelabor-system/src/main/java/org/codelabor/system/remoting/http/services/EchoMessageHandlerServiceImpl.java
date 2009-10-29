package org.codelabor.system.remoting.http.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EchoMessageHandlerServiceImpl implements MessageHandlerService {
	Log log = LogFactory.getLog(EchoMessageHandlerServiceImpl.class);

	public String handleMessage(String inputHeaderMessage,
			String inputDataMessage) throws Exception {
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("inputHeaderMessage: ").append(inputHeaderMessage);
			sb.append(", ");
			sb.append("inputDataMessage: ").append(inputDataMessage);
			log.debug(sb.toString());
		}
		StringBuilder sb = new StringBuilder();
		sb.append(inputHeaderMessage).append(inputDataMessage);
		return sb.toString();
	}

}
