package org.codelabor.example.util.properties;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("key1", "value1");
		prop.setProperty("key2", "value2");
		
		Enumeration<?> enumeration = prop.propertyNames();
		while (enumeration.hasMoreElements()) {
			StringBuilder stringBuilder = new StringBuilder();
			String key = (String) enumeration.nextElement();
			stringBuilder.append(key);
			stringBuilder.append(": ");
			stringBuilder.append(prop.getProperty(key));
		
			System.out.println(stringBuilder.toString());
		}
	}
}
