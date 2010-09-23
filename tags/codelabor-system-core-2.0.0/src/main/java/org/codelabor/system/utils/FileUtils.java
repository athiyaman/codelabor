package org.codelabor.system.utils;

/**
 * 파일 유틸
 * 
 * @author Shin Sangjae
 * 
 */
public class FileUtils {
	/**
	 * 확장자를 가져온다.
	 * 
	 * @param fileName
	 *            파일명
	 * @return 확장자
	 */
	static public String getExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index < 0) {
			return null;
		} else {
			return fileName.substring(index + 1);
		}
	}
}
