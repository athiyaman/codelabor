package org.codelabor.example.nio.file;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CaseFormat;

public class PatternNameExtractor<Path> implements FileVisitor<Path> {
	private static final Logger logger = LoggerFactory
			.getLogger(PatternNameExtractor.class);

	private boolean isJavaSource(String fileName) {
		return fileName.endsWith(".java");
	}

	private String getPatternName(String fileName) {
		String patternName = null;
		String lowerHypenFileName = CaseFormat.LOWER_CAMEL.to(
				CaseFormat.LOWER_HYPHEN, fileName);
		logger.debug("hypen file name: {}", lowerHypenFileName);
		int lastIndexOfHypen = lowerHypenFileName.lastIndexOf("-");
		int lastIndexOfDot = lowerHypenFileName.lastIndexOf(".");

		if (lastIndexOfDot >= 0) {
			patternName = lowerHypenFileName.substring(lastIndexOfHypen + 1,
					lastIndexOfDot);
		}
		logger.debug("pattern name: {}", patternName);
		return patternName;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		logger.debug("preVisitDirectory");
		return CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		logger.debug("visitFile");
		String fileName = FilenameUtils.getName(file.toString());
		String patternName = null;
		if (isJavaSource(fileName)) {
			patternName = getPatternName(fileName);
			logger.info("path: {}", file);
			logger.info("file name: {}", fileName);
			logger.info("pattern name: {}", patternName);
		}
		return CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		logger.debug("visitFileFailed");
		return CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		logger.debug("postVisitDirectory");
		return CONTINUE;
	}

}
