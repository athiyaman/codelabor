package org.codelabor.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 파일 유틸리티 클래스
 *
 * @author Shin Sang-jae
 * @deprecated This class has been replaced by the {@link org.apache.commons.io.FilenameUtils FilenameUtils}
 */
public class FileUtils {
	/**
	 * 로거
	 */
	static Logger logger = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * 확장자를 가져온다.<br/> 파일명에 확장자를 포함하고 있을 경우, 확장자만 가져온다.<br/>
	 * @param filename
	 *            파일명
	 * @return 확장자
	 */
	static public String getExtension(String filename) {
		int lastIndex = filename.lastIndexOf(".");
		if (lastIndex < 0) {
			return null;
		} else {
			return filename.substring(lastIndex + 1);
		}
	}

	/**
	 * 파일명을 가져온다.<br/>
	 * @param fullyQualifiedFilename
	 *            경로를 포함한 파일명
	 * @return 경로를 포함하지 않는 파일명
	 */
	static public String getFilename(String fullyQualifiedFilename) {
		int lastIndex = fullyQualifiedFilename.lastIndexOf("/");
		if (lastIndex > 0) {
			logger.debug("UNIX system name-separator character is found.");
		} else if (lastIndex < 0) {
			lastIndex = fullyQualifiedFilename.lastIndexOf("\\");
			logger.debug("Microsoft Windows system name-separator character is found.");
		} else {
			logger.debug("System name-separator character is not found.");
		}

		int beginIndex = (lastIndex > 0) ? lastIndex + 1 : 0;
		String filename = fullyQualifiedFilename.substring(beginIndex);

		logger.debug("fullyQualifiedFilename: {}", fullyQualifiedFilename);
		logger.debug("filename: {}", filename);
		return filename;
	}
}
