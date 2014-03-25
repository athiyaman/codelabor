package org.codelabor.system.remoting.tcp.services;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SocketEchoServiceImpl implements SocketInvokerService {
	private final Log log = LogFactory.getLog(SocketEchoServiceImpl.class);
	protected int port;

	public void handle() throws Exception {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);

			StringBuilder sb = new StringBuilder();
			sb.append("Waiting...");
			if (log.isDebugEnabled()) {
				log.debug(sb.toString());
			}
			while (true) {
				// wait client
				Socket socket = serverSocket.accept();
				String clientAddress = socket.getInetAddress().getHostAddress();
				sb = new StringBuilder();
				sb.append("client address: ").append(clientAddress);
				if (log.isDebugEnabled()) {
					log.debug(sb.toString());
				}

				SocketEchoServiceThread serverThread = new SocketEchoServiceThread(
						socket);
				Thread thread = new Thread(serverThread);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setPort(int port) {
		this.port = port;
	}
}
