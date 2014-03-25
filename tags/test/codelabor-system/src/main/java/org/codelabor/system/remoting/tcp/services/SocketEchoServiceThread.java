package org.codelabor.system.remoting.tcp.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SocketEchoServiceThread implements Runnable {
	private final Log log = LogFactory.getLog(SocketEchoServiceThread.class);
	private Socket socket = null;
	private InputStream inputStream = null;
	private OutputStream outputStream = null;
	private InputStreamReader inputStreamReader = null;
	private OutputStreamWriter outputStreamWriter = null;
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	private String receivedMessage = null;

	public SocketEchoServiceThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			// setup stream
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			outputStreamWriter = new OutputStreamWriter(outputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			bufferedWriter = new BufferedWriter(outputStreamWriter);

			while (true) {
				// receive messate
				receivedMessage = bufferedReader.readLine();

				if (receivedMessage == null) {
					continue;
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append("received message: ").append(receivedMessage);
					if (log.isDebugEnabled()) {
						log.debug(sb.toString());
					}

					// send messate
					String sentMessage = receivedMessage;
					bufferedWriter.write(sentMessage);
					bufferedWriter.newLine();
					bufferedWriter.flush();

					sb = new StringBuilder();
					sb.append("sent message: ").append(sentMessage);
					if (log.isDebugEnabled()) {
						log.debug(sb.toString());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
