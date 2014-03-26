/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 파일 유틸리티 클래스
 *
 * @author Shin Sang-jae
 * @deprecated This class has been replaced by the
 *             {@link org.apache.commons.io.FilenameUtils FilenameUtils}
 */
@Deprecated
public class FileUtils {
	/**
	 * 로거
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(FileUtils.class);

	/**
	 * 확장자를 가져온다.<br/>
	 * 파일명에 확장자를 포함하고 있을 경우, 확장자만 가져온다.<br/>
	 *
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
	 *
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
