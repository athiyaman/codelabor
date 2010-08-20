package org.codelabor.system.net.ftp;

import java.io.File;

import org.apache.log4j.Logger;
import org.codelabor.system.net.ftp.services.FileTransferService;
import org.springframework.test.AbstractSingleSpringContextTests;

public class FileTransferServiceTest extends AbstractSingleSpringContextTests {

	private final static Logger logger = Logger
			.getLogger(FileTransferServiceTest.class);
	private FileTransferService fileTransferService;

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:**/*.xml" };
	}

	@Override
	protected void onSetUp() throws Exception {
		fileTransferService = (FileTransferService) applicationContext
				.getBean("fileTransferService1");
	}

	public void testAsciiStore() {
		File inputFile = new File("C:/temp/upload/새 텍스트 문서.txt");
		try {
			fileTransferService.store("upload", "새 텍스트 문서.txt", inputFile);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testAsciiRetrieve() {
		File outputFile = new File("C:/temp/download/새 텍스트 문서.txt");
		try {
			fileTransferService.retrieve("upload", "새 텍스트 문서.txt", outputFile);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testBinaryStore() {
		File inputFile = new File("C:/temp/upload/새 Microsoft Word 문서.doc");
		try {
			fileTransferService.store("upload", "새 Microsoft Word 문서.doc",
					inputFile, FileType.BINARY);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testBinaryRetrieve() {
		File outputFile = new File("C:/temp/download/새 Microsoft Word 문서.doc");
		try {
			fileTransferService.retrieve("upload", "새 Microsoft Word 문서.doc",
					outputFile, FileType.BINARY);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
