package org.codelabor.example.oxm.xstream;

import org.codelabor.example.oxm.xstream.dto.Person;
import org.codelabor.example.oxm.xstream.dto.PhoneNumber;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;

public class XStreamTest {
	Logger logger = LoggerFactory.getLogger(XStreamTest.class);
	String xml = null;
	XStream xstream = null;

	@Before
	public void setUp() throws Exception {
		xstream = new XStream();
		xstream.alias("person", Person.class);
		xstream.alias("phonenumber", PhoneNumber.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToXMLObject() {
		Person joe = new Person("Joe", "Walnes");
		joe.setPhone(new PhoneNumber(123, "1234-456"));
		joe.setFax(new PhoneNumber(123, "9999-999"));

		xml = xstream.toXML(joe);
		logger.debug("xml: {}", xml);

	}

	@Test
	public void testFromXMLString() {
		Person joe = new Person("Joe", "Walnes");
		joe.setPhone(new PhoneNumber(123, "1234-456"));
		joe.setFax(new PhoneNumber(123, "9999-999"));

		xml = xstream.toXML(joe);
		logger.debug("xml: {}", xml);

		Person newJoe = (Person) xstream.fromXML(xml);
		logger.debug("newJoe: {}", newJoe);
	}

}
