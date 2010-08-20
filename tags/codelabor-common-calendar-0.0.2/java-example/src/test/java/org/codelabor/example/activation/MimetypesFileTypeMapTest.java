package org.codelabor.example.activation;

import java.io.InputStream;

import javax.activation.MimetypesFileTypeMap;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MimetypesFileTypeMapTest extends TestCase {

	Logger logger = LoggerFactory.getLogger(MimetypesFileTypeMapTest.class);

	public void testMimeType() {
		MimetypesFileTypeMap mimetypesFileTypeMap;
		try {
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream("mime.types");
			mimetypesFileTypeMap = new MimetypesFileTypeMap(inputStream);
			String contentType = mimetypesFileTypeMap
					.getContentType("C:/AUTOEXEC.BAT");
			logger.debug("contentType: {}", contentType);
			contentType = mimetypesFileTypeMap.getContentType("C:/CONFIG.SYS");
			logger.debug("contentType: {}", contentType);
			contentType = mimetypesFileTypeMap.getContentType("새 텍스트 문서.txt");
			logger.debug("contentType: {}", contentType);
			contentType = mimetypesFileTypeMap.getContentType("새 비트맵 이미지.bmp");
			logger.debug("contentType: {}", contentType);
			contentType = mimetypesFileTypeMap.getContentType("SWCheck.log");
			logger.debug("contentType: {}", contentType);
			contentType = mimetypesFileTypeMap
					.getContentType("새 Microsoft Word 문서.doc");
			logger.debug("contentType: {}", contentType);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
}
