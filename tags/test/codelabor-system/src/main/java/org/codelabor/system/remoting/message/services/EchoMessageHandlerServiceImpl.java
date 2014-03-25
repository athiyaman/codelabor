package org.codelabor.system.remoting.message.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.remoting.message.utils.MessageUtil;

public class EchoMessageHandlerServiceImpl implements MessageHandlerService {
	Log log = LogFactory.getLog(EchoMessageHandlerServiceImpl.class);

	public String handleMessage(String inputMessage) throws Exception {
		// input message
		byte[] inputMessageBytes = inputMessage.getBytes();
		byte[] inputHeaderMessageBytes = MessageUtil
				.getInputHeaderMessage(inputMessageBytes);
		byte[] inputDataMessageBytes = MessageUtil
				.getInputDataMessage(inputMessageBytes);

		// output message
		byte[] outputHeaderMessageBytes = inputHeaderMessageBytes;
		byte[] outputDataMessageBytes = inputDataMessageBytes;
		byte[] outputMessageBytes = MessageUtil.getOutputMessage(
				outputHeaderMessageBytes, outputDataMessageBytes);

		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("input header message: ").append(inputHeaderMessageBytes);
			sb.append(", ");
			sb.append("input data message: ").append(inputDataMessageBytes);
			sb.append(", ");
			sb.append("output header message: ").append(
					outputHeaderMessageBytes);
			sb.append(", ");
			sb.append("output data message: ").append(outputDataMessageBytes);
			log.debug(sb.toString());
		}

		return new String(outputMessageBytes);
	}
}
