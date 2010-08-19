package org.codelabor.system.net.ftp.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.SocketTimeoutException;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.codelabor.system.net.ftp.DataConnectionMode;
import org.codelabor.system.net.ftp.FileType;
import org.codelabor.system.net.ftp.exceptions.ChangeWorkingDirectoryFailException;
import org.codelabor.system.net.ftp.exceptions.DeleteFileFailException;
import org.codelabor.system.net.ftp.exceptions.DuplicatedFileNameException;
import org.codelabor.system.net.ftp.exceptions.FileDoesNotExistException;
import org.codelabor.system.net.ftp.exceptions.LoginFailException;
import org.codelabor.system.net.ftp.exceptions.RefusedConnectionExeption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTransferServiceImpl implements FileTransferService {

	protected String hostname;
	protected int port;

	protected String username;
	protected String password;

	protected String charsetName;
	protected int connectTimeout;

	protected DataConnectionMode dataConnectionMode;

	protected String defaultDirectory;
	protected boolean overwriteFlag = true;

	private static final Logger logger = LoggerFactory
			.getLogger(FileTransferServiceImpl.class);

	private FTPClient getFTPClient() throws Exception {
		try {
			FTPClient ftpClient = new FTPClient();
			ftpClient.setControlEncoding(charsetName);
			ftpClient.setConnectTimeout(connectTimeout);
			ftpClient.connect(hostname, port);
			int replyCode = ftpClient.getReplyCode();
			logger.debug("replyCode: {}", replyCode);
			if (FTPReply.isPositiveCompletion(replyCode)) {
				if (!ftpClient.login(username, password)) {
					logger.error("Login failure. username: {}", username);
					throw new LoginFailException();
				}
				return ftpClient;
			} else {
				logger.error("Refused connection: {}", hostname);
				throw new RefusedConnectionExeption();
			}
		} catch (SocketTimeoutException e) {
			logger.error("Connect time out: {}", connectTimeout);
			throw e;
		} catch (Exception e) {
			logger.error("Cannot ftp client initilize.");
			throw e;
		}
	}

	private void releaseFTPClient(FTPClient ftpClient) throws Exception {
		ftpClient.logout();
		ftpClient.disconnect();
		logger.debug("FTP client released.");
	}

	public void retrieve(String fileName, File outputFile) throws Exception {
		this.retrieve(defaultDirectory, fileName, outputFile);
	}

	public void retrieve(String fileName, File outputFile, FileType fileType)
			throws Exception {
		this.retrieve(defaultDirectory, fileName, outputFile, fileType);
	}

	public void retrieve(String directory, String fileName, File outputFile)
			throws Exception {
		this.retrieve(directory, fileName, outputFile, FileType.ASCII);
	}

	public void retrieve(String directory, String fileName, File outputFile,
			FileType fileType) throws Exception {
		FTPClient ftpClient = null;
		try {
			ftpClient = this.getFTPClient();
			switch (fileType) {
			case ASCII:
				ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
				break;
			case BINARY:
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				break;
			}

			logger.debug("directory: {}", directory);
			logger.debug("file name: {}", fileName);
			logger.debug("outputFile: {}", outputFile);
			logger.debug("fileType: {}", fileType);

			if (!ftpClient.changeWorkingDirectory(directory)) {
				logger.error("change working directory failure: {}", directory);
				throw new ChangeWorkingDirectoryFailException();
			}

			String[] fileNames = ftpClient.listNames();
			if (ArrayUtils.contains(fileNames, fileName)) {
				logger
						.debug("Reqeusted file exists. (file name: {})",
								fileName);

				FileOutputStream fileOutputStream = new FileOutputStream(
						outputFile);
				ftpClient.retrieveFile(fileName, fileOutputStream);
			} else {
				logger.debug("reqeusted file does not exists: {}", fileName);
				throw new FileDoesNotExistException();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (ftpClient != null) {
				this.releaseFTPClient(ftpClient);
			}
		}
	}

	public void store(String fileName, File inputFile) throws Exception {
		this.store(defaultDirectory, fileName, inputFile);
	}

	public void store(String fileName, File inputFile, FileType fileType)
			throws Exception {
		this.store(defaultDirectory, fileName, inputFile, fileType);
	}

	public void store(String directory, String fileName, File inputFile)
			throws Exception {
		this.store(directory, fileName, inputFile, FileType.ASCII);
	}

	public void store(String directory, String fileName, File inputFile,
			FileType fileType) throws Exception {
		FTPClient ftpClient = null;
		try {
			ftpClient = this.getFTPClient();
			switch (fileType) {
			case ASCII:
				ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
				break;
			case BINARY:
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				break;
			}

			logger.debug("directory: {}", directory);
			logger.debug("file name: {}", fileName);
			logger.debug("inputFile: {}", inputFile);
			logger.debug("fileType: {}", fileType);
			logger.debug("overwriteFlag: {}", overwriteFlag);

			if (!ftpClient.changeWorkingDirectory(directory)) {
				logger.error("change working directory failure: {}", directory);
				throw new ChangeWorkingDirectoryFailException();
			}

			String[] fileNames = ftpClient.listNames();
			if (ArrayUtils.contains(fileNames, fileName)) {
				logger
						.debug("Reqeusted file exists. (file name: {})",
								fileName);
				if (overwriteFlag) {
					if (!ftpClient.deleteFile(fileName)) {
						logger.error("cannot delete file: {}", fileName);
						throw new DeleteFileFailException();
					} else {
						logger.debug("Previous file deleted. (file name: {})",
								fileName);
					}
				} else {
					logger.error("file name is duplicated.");
					throw new DuplicatedFileNameException();
				}
			} else {
				logger.debug("reqeusted file does not exists: {}", fileName);
			}

			FileInputStream fileInputStream = new FileInputStream(inputFile);
			ftpClient.storeFile(fileName, fileInputStream);
		} catch (Exception e) {
			throw e;
		} finally {
			if (ftpClient != null) {
				this.releaseFTPClient(ftpClient);
			}
		}
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public void setOverwriteFlag(boolean overwriteFlag) {
		this.overwriteFlag = overwriteFlag;
	}

	public void setDataConnectionMode(String dataConnectionMode) {
		this.dataConnectionMode = DataConnectionMode.valueOf(dataConnectionMode
				.toUpperCase());
	}

	public void setDefaultDirectory(String defaultDirectory) {
		if (!StringUtils.isEmpty(defaultDirectory)) {
			this.defaultDirectory = defaultDirectory;
		}
	}

	public String getHostname() {
		return hostname;
	}

	public int getPort() {
		return port;
	}
}
