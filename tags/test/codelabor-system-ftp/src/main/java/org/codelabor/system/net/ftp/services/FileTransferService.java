package org.codelabor.system.net.ftp.services;

import java.io.File;

import org.codelabor.system.net.ftp.FileType;

public interface FileTransferService {
	public void store(String fileName, File inputFile) throws Exception;

	public void retrieve(String fileName, File outputFile) throws Exception;

	public void store(String fileName, File inputFile, FileType fileType)
			throws Exception;

	public void retrieve(String fileName, File outputFile, FileType fileType)
			throws Exception;

	public void store(String directory, String fileName, File inputFile)
			throws Exception;

	public void retrieve(String directory, String fileName, File outputFile)
			throws Exception;

	public void store(String directory, String fileName, File inputFile,
			FileType fileType) throws Exception;

	public void retrieve(String directory, String fileName, File outputFile,
			FileType fileType) throws Exception;

	public String getHostname();

	public int getPort();

}
