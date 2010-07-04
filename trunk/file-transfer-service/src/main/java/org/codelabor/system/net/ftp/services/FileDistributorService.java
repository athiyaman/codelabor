package org.codelabor.system.net.ftp.services;

import java.io.File;

import org.codelabor.system.net.ftp.FileType;

public interface FileDistributorService {

	public int store(String fileName, File inputFile) throws Exception;

	public int store(String fileName, File inputFile, FileType fileType)
			throws Exception;

	public int store(String directory, String fileName, File inputFile)
			throws Exception;

	public int store(String directory, String fileName, File inputFile,
			FileType fileType) throws Exception;

}
