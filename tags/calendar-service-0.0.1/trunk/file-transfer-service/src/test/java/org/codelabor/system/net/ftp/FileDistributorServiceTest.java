package org.codelabor.system.net.ftp;

import java.io.File;

import org.codelabor.system.net.ftp.services.FileDistributorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class FileDistributorServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private final static Logger logger = LoggerFactory
			.getLogger(FileDistributorServiceTest.class);
	private FileDistributorService fileDistributorService;

	public void setFileDistributorService(
			FileDistributorService fileDistributorService) {
		this.fileDistributorService = fileDistributorService;
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:**/*.xml" };
	}

	public void testAsciiStore() {
		File inputFile = new File("C:/temp/upload/새 텍스트 문서.txt");
		try {
			int successCount = fileDistributorService.store("upload",
					"새 텍스트 문서.txt", inputFile);
			logger.info("Success Count: {}", successCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testBinaryStore() {
		File inputFile = new File("C:/temp/upload/새 Microsoft Word 문서.doc");
		try {
			int successCount = fileDistributorService.store("upload",
					"새 Microsoft Word 문서.doc", inputFile, FileType.BINARY);
			logger.info("Success Count: {}", successCount);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
