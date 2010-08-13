package org.codelabor.system.utils;

public class FileUtils {
	static public String getExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index < 0) {
			return null;
		} else {
			return fileName.substring(index + 1);
		}
	}
}
