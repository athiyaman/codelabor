package org.codelabor.example.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaFileFilter implements FileFilter {

	Logger logger = LoggerFactory.getLogger(JavaFileFilter.class);

	public boolean accept(File pathname) {
		if (pathname != null && !pathname.exists()) {
			logger.error("{} does not exist.", pathname);
			return false;
		} else {
			if (pathname.isFile()) {
				try {
					String canonicalPath = pathname.getCanonicalPath();
					logger.debug("canonicalPath: {}", canonicalPath);
					if (canonicalPath.endsWith(".java")) {
						return true;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
	}

}
