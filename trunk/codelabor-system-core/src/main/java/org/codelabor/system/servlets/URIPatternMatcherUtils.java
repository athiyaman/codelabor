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

package org.codelabor.system.servlets;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codelabor.system.utils.FileUtils;
import org.codelabor.system.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class URIPatternMatcherUtils {
	private static Logger logger = LoggerFactory
			.getLogger(URIPatternMatcherUtils.class);

	static public boolean matchByAntStylePathPattern(
			List<String> includePatterns, List<String> excludePatterns,
			String requestURI) {
		boolean isMatched = false;

		if (excludePatterns != null) {
			if (ListUtils
					.containsByAntStylePattern(excludePatterns, requestURI)) {
				// bypass
			} else {
				if (includePatterns != null) {
					if (ListUtils.containsByAntStylePattern(includePatterns,
							requestURI)) {
						isMatched = true;
					} else {
						isMatched = false;
					}
				} else {
					isMatched = true;
				}
			}
		} else {
			if (includePatterns != null) {
				if (ListUtils.containsByAntStylePattern(includePatterns,
						requestURI)) {
					isMatched = true;
				} else {
					isMatched = false;
				}
			} else {
				isMatched = true;
			}
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}

	static public boolean matchByURI(List<String> includePatterns,
			List<String> excludePatterns, String requestURI) {
		boolean isMatched = false;

		if (excludePatterns != null) {
			if (excludePatterns.contains(requestURI)) {
				// bypass
			} else {
				if (includePatterns != null) {
					if (includePatterns.contains(requestURI)) {
						isMatched = true;
					} else {
						isMatched = false;
					}
				} else {
					isMatched = true;
				}
			}
		} else {
			if (includePatterns != null) {
				if (includePatterns.contains(requestURI)) {
					isMatched = true;
				} else {
					isMatched = false;
				}
			} else {
				isMatched = true;
			}
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}

	static public boolean matchByExtension(List<String> includePatterns,
			List<String> excludePatterns, String requestURI) {
		boolean isMatched = false;

		String extension = FileUtils.getExtension(requestURI);
		if (!StringUtils.isBlank(extension)) {
			extension = extension.toLowerCase();
		}
		logger.debug("extension: {}", extension);

		if (excludePatterns != null) {
			if (excludePatterns.contains(extension)) {
				// bypass
			} else {
				if (includePatterns != null) {
					if (includePatterns.contains(extension)) {
						isMatched = true;
					} else {
						isMatched = false;
					}
				} else {
					isMatched = true;
				}
			}
		} else {
			if (includePatterns != null) {
				if (includePatterns.contains(extension)) {
					isMatched = true;
				} else {
					isMatched = false;
				}
			} else {
				isMatched = true;
			}
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}
}
