package org.codelabor.example.util.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesExample2 {
	public static void main(String[] args) {
		File propertiesFile = new File("example3.properties");
		try {
			InputStream inputStream = new FileInputStream(propertiesFile);
			Properties prop = new Properties();
			prop.load(inputStream);
			
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
