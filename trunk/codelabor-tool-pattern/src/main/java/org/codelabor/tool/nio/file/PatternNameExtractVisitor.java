package org.codelabor.tool.nio.file;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CaseFormat;

public class PatternNameExtractVisitor<Path> implements FileVisitor<Path> {
	private static final Logger logger = LoggerFactory
			.getLogger(PatternNameExtractVisitor.class);

	@SuppressWarnings("unused")
	private XSSFWorkbook workbook = null;
	private Sheet sheet = null;
	private int rowCount = 0;

	public PatternNameExtractVisitor(XSSFWorkbook workbook) {
		super();
		this.setHeader(workbook);

	}

	private void setHeader(XSSFWorkbook workbook) {
		// prepare worksheet
		this.workbook = workbook;
		sheet = workbook.createSheet("Pattern Names");

		// create excel row header
		Row row = sheet.createRow(rowCount);
		Cell cell = row.createCell(0);
		cell.setCellValue("Pattern Name");
		cell = row.createCell(1);
		cell.setCellValue("File Name");
		cell = row.createCell(2);
		cell.setCellValue("Path");
		rowCount++;
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

			// create excel row
			Row row = sheet.createRow(rowCount);
			Cell cell = row.createCell(0);
			cell.setCellValue(patternName);
			cell = row.createCell(1);
			cell.setCellValue(fileName);
			cell = row.createCell(2);
			cell.setCellValue(file.toString());
			rowCount++;
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
