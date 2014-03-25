package org.codelabor.system.remoting.message.utils;

public class MessageUtil {

	public static byte[] getInputDataMessage(byte[] inputMessage)
			throws Exception {
		byte[] inputDataMessage = new byte[inputMessage.length - 900];
		System.arraycopy(inputMessage, 900, inputDataMessage, 0,
				inputDataMessage.length);
		return inputDataMessage;
	}

	public static byte[] getInputHeaderMessage(byte[] inputMessage)
			throws Exception {
		byte[] inputHeaderMessage = new byte[900];
		System.arraycopy(inputMessage, 0, inputHeaderMessage, 0,
				inputHeaderMessage.length);
		return inputHeaderMessage;
	}

	public static byte[] getOutputMessage(byte[] outputHeaderMessageBytes,
			byte[] outputDataMessageBytes) throws Exception {
		byte[] outputMessageBytes = new byte[outputHeaderMessageBytes.length
				+ outputDataMessageBytes.length];
		System.arraycopy(outputHeaderMessageBytes, 0, outputMessageBytes, 0,
				outputHeaderMessageBytes.length);
		System.arraycopy(outputDataMessageBytes, 0, outputMessageBytes,
				outputHeaderMessageBytes.length, outputDataMessageBytes.length);
		return outputMessageBytes;
	}

	public static String getServiceName(String inputMessage) throws Exception {
		return inputMessage.substring(12, 23);
	}
}
