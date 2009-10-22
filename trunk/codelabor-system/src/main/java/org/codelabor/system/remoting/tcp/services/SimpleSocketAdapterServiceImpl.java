/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.system.remoting.tcp.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author bomber
 * 
 */
public class SimpleSocketAdapterServiceImpl implements SocketAdapterService {
	public final int MESSAGE_LENGTH_FIELD_LENGTH = 8;
	private final Log log = LogFactory
			.getLog(SimpleSocketAdapterServiceImpl.class);

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}

	private String host;
	private int port;
	private String charsetName = "EUC-KR";

	public String send(String inputMessage) throws Exception {
		Socket socket = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String receivedMessage = null;

		try {
			// connect to server
			socket = new Socket(host, port);

			// setup stream
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			// send message
			outputStream.write(inputMessage.getBytes(charsetName));
			outputStream.flush();
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("sent message: ").append(inputMessage);
				log.debug(sb.toString());
			}

			// read size part
			byte[] lengthPartBytes = new byte[MESSAGE_LENGTH_FIELD_LENGTH];
			inputStream.read(lengthPartBytes, 0, lengthPartBytes.length);
			String messageLengthBytesString = new String(lengthPartBytes,
					charsetName);
			if (messageLengthBytesString.length() == 0)
				return null;

			// get message length
			int messageLength = Integer.parseInt(messageLengthBytesString);

			// read remains part
			byte[] remainsPartBytes = new byte[messageLength
					- MESSAGE_LENGTH_FIELD_LENGTH];
			inputStream.read(remainsPartBytes, 0, remainsPartBytes.length);

			// append bytes
			byte[] receivedMessageBytes = new byte[messageLength];
			System.arraycopy(lengthPartBytes, 0, receivedMessageBytes, 0,
					MESSAGE_LENGTH_FIELD_LENGTH);
			System.arraycopy(remainsPartBytes, 0, receivedMessageBytes,
					MESSAGE_LENGTH_FIELD_LENGTH, messageLength
							- MESSAGE_LENGTH_FIELD_LENGTH);

			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("lengthpartBytes: [").append(
						new String(lengthPartBytes, charsetName)).append("]");
				sb.append(", ");
				sb.append("remainsPartBytes: [").append(
						new String(remainsPartBytes, charsetName)).append("]");
				sb.append(", ");
				sb.append("receivedMessageBytes: [").append(
						new String(receivedMessageBytes, charsetName)).append(
						"]");
				log.debug(sb.toString());
			}

			receivedMessage = new String(receivedMessageBytes, charsetName);

			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("message length: ").append(messageLength);
				sb.append(", ");
				sb.append("received message length: ").append(
						receivedMessage.getBytes(charsetName).length);
				sb.append(", ");
				sb.append("received message: [").append(receivedMessage)
						.append("]");
				log.debug(sb.toString());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null)
				inputStream.close();
			if (outputStream != null)
				outputStream.close();
			if (socket != null)
				socket.close();
		}
		return receivedMessage;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public byte[] send(byte[] bytes) throws Exception {
		return (this.send(new String(bytes, charsetName)))
				.getBytes(charsetName);
	}
}
