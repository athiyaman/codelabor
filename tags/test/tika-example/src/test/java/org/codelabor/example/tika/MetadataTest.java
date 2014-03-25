package org.codelabor.example.tika;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class MetadataTest {
	private final Logger logger = LoggerFactory.getLogger(MetadataTest.class);
	private File file;
	private InputStream inputStream;
	ContentHandler contentHandler;

	@Before
	public void setUp() throws Exception {
		file = new File(
				"H:/Download/Framework/Spring/reference/spring-framework-reference.pdf");
		inputStream = new FileInputStream(file);
		contentHandler = new BodyContentHandler();
	}

	@Test
	public void testGetString() {
		Metadata metadata = new Metadata();
		metadata.set(Metadata.RESOURCE_NAME_KEY, file.getName());
		Parser parser = new AutoDetectParser();
		ParseContext parseContext = new ParseContext();
		try {
			parser.parse(inputStream, contentHandler, metadata, parseContext);
			logger.debug("content type: {}",
					metadata.get(Metadata.CONTENT_TYPE));
			logger.debug("title: {}", metadata.get(Metadata.TITLE));
			logger.debug("author: {}", metadata.get(Metadata.AUTHOR));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} catch (SAXException e) {
			e.printStackTrace();
			fail();
		} catch (TikaException e) {
			e.printStackTrace();
			fail();
		}
	}

}
