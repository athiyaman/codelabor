package org.codelabor.example.util.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesExample3 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("key1", "value1");
		prop.setProperty("key2", "value2");

		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("example2.properties");
			prop.store(outputStream, "example2 properties");
			
			Enumeration<?> enumeration = prop.propertyNames();
			while (enumeration.hasMoreElements()) {
				StringBuilder stringBuilder = new StringBuilder();
				String key = (String) enumeration.nextElement();
				stringBuilder.append(key);
				stringBuilder.append(": ");
				stringBuilder.append(prop.getProperty(key));
			
				System.out.println(stringBuilder.toString());
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
