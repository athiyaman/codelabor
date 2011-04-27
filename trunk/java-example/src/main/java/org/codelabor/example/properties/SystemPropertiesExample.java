package org.codelabor.example.properties;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemPropertiesExample {

	static final Logger logger = LoggerFactory
			.getLogger(SystemPropertiesExample.class);

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Map propertyMap = System.getProperties();
		Set keySet = propertyMap.keySet();
		Iterator iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = (String) propertyMap.get(key);
			logger.info("{}: {}", key, value);
		}

	}

}
