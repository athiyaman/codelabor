package org.codelabor.example.io;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.codelabor.example.io.JavaFileFilter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileFilterTest {

	Logger logger = LoggerFactory.getLogger(FileFilterTest.class);

	@Test
	public void testAccept() {

		File currentPath = new File(".");
		try {
			String currentCannonicalPath = currentPath.getCanonicalPath();
			logger.debug("current cannonical path: {}", currentCannonicalPath);

			FileFilter javaFileFilter = new JavaFileFilter();
			File pathname = new File(
					currentCannonicalPath
							+ "/src/main/java/org/codelabor/system/extractor/JavaFileFilter.java");
			boolean isAccepted = javaFileFilter.accept(pathname);
			logger.debug("isAccepted: {}", isAccepted);

		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

	}

}
