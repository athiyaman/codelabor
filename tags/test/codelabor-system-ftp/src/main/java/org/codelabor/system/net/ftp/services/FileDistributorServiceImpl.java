package org.codelabor.system.net.ftp.services;

import java.io.File;
import java.util.List;

import org.codelabor.system.net.ftp.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDistributorServiceImpl implements FileDistributorService {

	private Logger logger = LoggerFactory
			.getLogger(FileDistributorServiceImpl.class);

	private String successLogStringFormat = "Store file success. (host name: {}, port: {}, file name: {}";
	private String failureLogStringFormat = "Store file failure. (host name: {}, port: {}, file name: {}";

	protected List<FileTransferService> fileTransferServices;

	public int store(String fileName, File inputFile) throws Exception {
		int successCount = 0;
		int failureCount = 0;
		for (FileTransferService fileTransferService : fileTransferServices) {
			Object[] logParams = new Object[] {
					fileTransferService.getHostname(),
					String.valueOf(fileTransferService.getPort()), fileName };
			try {
				fileTransferService.store(fileName, inputFile);
				successCount++;
				logger.debug(successLogStringFormat, logParams);
			} catch (Exception e) {
				failureCount++;
				logger.error(failureLogStringFormat, logParams);
			}
		}
		logger.info("File distrubution completed. (success: {}, failure: {})",
				successCount, failureCount);
		return successCount;
	}

	public int store(String fileName, File inputFile, FileType fileType)
			throws Exception {
		int successCount = 0;
		int failureCount = 0;
		for (FileTransferService fileTransferService : fileTransferServices) {
			Object[] logParams = new Object[] {
					fileTransferService.getHostname(),
					String.valueOf(fileTransferService.getPort()), fileName };
			try {
				fileTransferService.store(fileName, inputFile, fileType);
				successCount++;
				logger.debug(successLogStringFormat, logParams);
			} catch (Exception e) {
				failureCount++;
				logger.error(failureLogStringFormat, logParams);
			}
		}
		logger.info("File distrubution completed. (success: {}, failure: {})",
				successCount, failureCount);
		return successCount;
	}

	public int store(String directory, String fileName, File inputFile)
			throws Exception {
		int successCount = 0;
		int failureCount = 0;
		for (FileTransferService fileTransferService : fileTransferServices) {
			Object[] logParams = new Object[] {
					fileTransferService.getHostname(),
					String.valueOf(fileTransferService.getPort()), fileName };
			try {
				fileTransferService.store(directory, fileName, inputFile);
				successCount++;
				logger.debug(successLogStringFormat, logParams);
			} catch (Exception e) {
				failureCount++;
				logger.error(failureLogStringFormat, logParams);
			}
		}
		logger.info("File distrubution completed. (success: {}, failure: {})",
				successCount, failureCount);
		return successCount;
	}

	public int store(String directory, String fileName, File inputFile,
			FileType fileType) throws Exception {
		int successCount = 0;
		int failureCount = 0;
		for (FileTransferService fileTransferService : fileTransferServices) {
			Object[] logParams = new Object[] {
					fileTransferService.getHostname(),
					String.valueOf(fileTransferService.getPort()), fileName };
			try {
				fileTransferService.store(directory, fileName, inputFile,
						fileType);
				successCount++;
				logger.debug(successLogStringFormat, logParams);
			} catch (Exception e) {
				failureCount++;
				logger.error(failureLogStringFormat, logParams);
			}
		}
		logger.info("File distrubution completed. (success: {}, failure: {})",
				successCount, failureCount);
		return successCount;
	}

	public void setFileTransferServices(
			List<FileTransferService> fileTransferServices) {
		this.fileTransferServices = fileTransferServices;
	}
}
