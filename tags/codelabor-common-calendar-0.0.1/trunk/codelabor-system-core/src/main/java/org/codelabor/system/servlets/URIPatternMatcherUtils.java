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
