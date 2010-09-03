package org.codelabor.example.net;

import java.io.IOException;
import java.net.SocketException;

import junit.framework.TestCase;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FTPClientTest extends TestCase {

	Logger logger = LoggerFactory.getLogger(FTPClientTest.class);

	@Override
	public void setUp() throws Exception {
	}

	@Override
	public void tearDown() throws Exception {
	}

	public void testStore() {
		String hostname = "localhost";
		String username = "bomber";
		String password = "wndgus2";
		String encoding = "UTF-8";
		int connectTimeout = 1000;
		String directory = "";

		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.setControlEncoding(encoding);
			ftpClient.setConnectTimeout(connectTimeout);

			ftpClient.connect(hostname);
			int replyCode = ftpClient.getReplyCode();
			logger.debug("replyCode: {}", replyCode);
			if (FTPReply.isPositiveCompletion(replyCode)) {
				ftpClient.login(username, password);

				// list files
				FTPListParseEngine parseEngine = ftpClient
						.initiateListParsing(directory);
				FTPFile[] files = parseEngine.getFiles();
				for (FTPFile file : files) {
					logger.debug("is file: {}", file.isFile());
					logger.debug("file name: {}", file.getName());
				}

				// TODO transfer file
				ftpClient.logout();
			} else {
				ftpClient.disconnect();
				logger.error("FTP Server refused connection.");
			}
		} catch (SocketException e) {
			e.printStackTrace();
			logger.error("error: {}", e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("error: {}", e.getMessage());
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("error: {}", e.getMessage());
				}
			}
		}
	}
}
