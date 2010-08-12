package org.codelabor.system.utils;

public class FileUtils {
	static public String getExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		return fileName.substring(index + 1);
	}
}
