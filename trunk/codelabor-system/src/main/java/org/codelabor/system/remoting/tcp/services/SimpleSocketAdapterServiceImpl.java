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
import org.codelabor.system.remoting.tcp.services.SocketAdapterService;

/**
 * @author bomber
 * 
 */
public class SimpleSocketAdapterServiceImpl implements SocketAdapterService {
	public final int MESSAGE_LENGTH_FIELD_LENGTH = 8;
	private final Log log = LogFactory.getLog(SimpleSocketAdapterServiceImpl.class);

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

			// receive messate
			StringBuilder sb = new StringBuilder();
			byte[] messageLengthBytes = new byte[MESSAGE_LENGTH_FIELD_LENGTH];
			inputStream.read(messageLengthBytes, 0, messageLengthBytes.length);
			sb.append(new String(messageLengthBytes, charsetName).trim());
			int messageLength = Integer.parseInt(sb.toString());

			byte[] messageBytes = new byte[messageLength];
			inputStream.read(messageBytes, 0, messageBytes.length);
			sb.append(new String(messageBytes, charsetName));
			receivedMessage = sb.toString();

			if (log.isDebugEnabled()) {
				sb = new StringBuilder();
				sb.append("received message: ").append(receivedMessage);
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
		return (this.send(new String(bytes, charsetName))).getBytes(charsetName);
	}
}
