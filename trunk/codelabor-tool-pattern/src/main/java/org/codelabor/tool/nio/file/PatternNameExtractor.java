package org.codelabor.tool.nio.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PatternNameExtractor {

	private static XSSFWorkbook workbook = null;
	private static int rowCount = 0;
	private static Sheet sheet = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			usage();
		}
		workbook = new XSSFWorkbook();
		setHeader();
		OutputStream outputStream = null;
		Path start = FileSystems.getDefault().getPath(args[0]);
		String path = args[1];
		try {
			List<PatternInfo> patternInfoList = new ArrayList<PatternInfo>();
			FileVisitor<Path> visitor = new PatternNameExtractVisitor<Path>(
					patternInfoList);
			Files.walkFileTree(start, visitor);
			for (PatternInfo patternInfo : patternInfoList) {
				Row row = sheet.createRow(rowCount);
				row.createCell(0).setCellValue(patternInfo.getPatternName());
				row.createCell(1).setCellValue(patternInfo.getFileName());
				row.createCell(2).setCellValue(patternInfo.getPath());
				rowCount++;
			}
			outputStream = new FileOutputStream(path);
			workbook.write(outputStream);
			System.out.println("Pattern name extraction completed.");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(-1);
				}
			}
		}

	}

	private static void usage() {
		System.err.print("Usage: startPath excelFileName");
		System.exit(-1);
	}

	private static void setHeader() {
		// prepare worksheet
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

}
