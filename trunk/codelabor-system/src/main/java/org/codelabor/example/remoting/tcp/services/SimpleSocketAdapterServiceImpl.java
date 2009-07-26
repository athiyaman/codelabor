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
package org.codelabor.example.remoting.tcp.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
	private final Log log = LogFactory
			.getLog(SimpleSocketAdapterServiceImpl.class);
	private String host;
	private int port;

	public String send(String inputMessage) throws Exception {
		Socket socket = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		String receivedMessage = null;

		try {
			// connect to server
			socket = new Socket(host, port);

			// setup stream
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			outputStreamWriter = new OutputStreamWriter(outputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			bufferedWriter = new BufferedWriter(outputStreamWriter);

			// send message
			bufferedWriter.write(inputMessage);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("sent message: ").append(inputMessage);
				log.debug(sb.toString());
			}

			// receive messate
			receivedMessage = bufferedReader.readLine();
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("received message: ").append(receivedMessage);
				log.debug(sb.toString());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedWriter != null)
				bufferedWriter.close();
			if (bufferedReader != null)
				bufferedReader.close();
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
}
