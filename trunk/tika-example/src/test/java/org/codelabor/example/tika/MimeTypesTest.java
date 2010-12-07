package org.codelabor.example.tika;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MimeTypesTest {
	private final Logger logger = LoggerFactory.getLogger(MimeTypesTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMediaTypeRegistry() {
		MimeTypes mimeTypes = new MimeTypes();
		Iterator iter = mimeTypes.getMediaTypeRegistry().getTypes().iterator();
		while (iter.hasNext()) {
			logger.debug("types: {}", iter.next());
		}
	}

	@Test
	public void testGetMimeTypeFile() {
		MimeTypes mimeTypes = new MimeTypes();
		File file = new File("C:/eclipse/eclipse.exe");
		MimeType mimeType = mimeTypes.getMimeType(file);
		logger.debug("mimeType: {}", mimeType);
	}

	@Test
	public void testGetMimeTypeURL() {
		MimeTypes mimeTypes = new MimeTypes();
		URL url;
		try {
			url = new URL("http://apache.org/images/feather-small.gif");
			MimeType mimeType = mimeTypes.getMimeType(url);
			logger.debug("mimeType: {}", mimeType);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetMimeTypeString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMimeTypeByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMimeTypeInputStream() {
		fail("Not yet implemented");
	}

}
