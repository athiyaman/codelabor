package org.codelabor.system.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 파일 유틸리티 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class FileUtils {
	/**
	 * 로거
	 */
	static Logger logger = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * 확장자를 가져온다.</br> 파일명에 확장자를 포함하고 있을 경우, 확장자만 가져온다.
	 * 
	 * @param fileName
	 *            파일명
	 * @return 확장자
	 */
	static public String getExtension(String fileName) {
		int lastIndex = fileName.lastIndexOf(".");
		if (lastIndex < 0) {
			return null;
		} else {
			return fileName.substring(lastIndex + 1);
		}
	}

	/**
	 * 파일명을 가져온다.</br> 파일명에 경로명을 포함하고 있을 경우, 경로명을 제외한 파일명만 가져온다.
	 * 
	 * @param fileNameWithPath
	 * @return 파일명
	 */
	static public String getFileName(String fileNameWithPath) {
		int lastIndex = fileNameWithPath.lastIndexOf(System
				.getProperty("file.separator"));
		int beginIndex = (lastIndex > 0) ? lastIndex + 1 : 0;
		String fileName = fileNameWithPath.substring(beginIndex);
		logger.debug("fileNameWithPath: {}", fileNameWithPath);
		logger.debug("realFileName: {}", fileName);
		return fileName;
	}
}
