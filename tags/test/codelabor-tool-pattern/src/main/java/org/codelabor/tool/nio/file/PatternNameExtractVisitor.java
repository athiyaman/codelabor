package org.codelabor.tool.nio.file;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CaseFormat;

public class PatternNameExtractVisitor<Path> implements FileVisitor<Path> {
	private static final Logger logger = LoggerFactory
			.getLogger(PatternNameExtractVisitor.class);

	private List<PatternInfo> patternInfoList = null;

	public PatternNameExtractVisitor(List<PatternInfo> patternInfoList) {
		super();
		this.patternInfoList = patternInfoList;
	}

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
		patternName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL,
				patternName);
		logger.debug("pattern name: {}", patternName);
		return patternName;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		return CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		String fileName = FilenameUtils.getName(file.toString());
		String patternName = null;
		if (isJavaSource(fileName)) {
			patternName = getPatternName(fileName);
			logger.debug("pattern name: {}", patternName);
			logger.debug("file name: {}", fileName);
			logger.debug("path: {}", file.toString());

			PatternInfo patternInfo = new PatternInfo();
			patternInfo.setPatternName(patternName);
			patternInfo.setFileName(fileName);
			patternInfo.setPath(file.toString());
			patternInfoList.add(patternInfo);
		}
		return CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		logger.error(exc.getMessage());
		return TERMINATE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		return CONTINUE;
	}

}
