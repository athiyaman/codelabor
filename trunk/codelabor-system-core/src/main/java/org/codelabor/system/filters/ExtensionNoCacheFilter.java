package org.codelabor.system.filters;



import org.apache.commons.lang.StringUtils;
import org.codelabor.system.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtensionNoCacheFilter extends SelectiveNoCacheFilter {
	private final Logger logger = LoggerFactory
			.getLogger(ExtensionNoCacheFilter.class);

	@Override
	protected boolean isNoCacheRequired(String requestURI) {
		String extension = FileUtils.getExtension(requestURI);
		if (!StringUtils.isBlank(extension)) {
			extension = extension.toLowerCase();
		}
		logger.debug("extension: {}", extension);
		boolean noCacheRequired = false;
		if (excludePatterns != null) {
			if (excludePatterns.contains(extension)) {
				// bypass
			} else {
				if (includePatterns != null) {
					if (includePatterns.contains(extension)) {
						noCacheRequired = true;
					} else {
						noCacheRequired = false;
					}
				} else {
					noCacheRequired = true;
				}
			}
		} else {
			if (includePatterns != null) {
				if (includePatterns.contains(extension)) {
					noCacheRequired = true;
				} else {
					noCacheRequired = false;
				}
			} else {
				noCacheRequired = true;
			}
		}
		logger.debug("noCacheRequired: {}", noCacheRequired);
		return noCacheRequired;
	}
}
