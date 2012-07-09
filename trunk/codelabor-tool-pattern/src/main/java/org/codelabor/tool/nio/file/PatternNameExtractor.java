package org.codelabor.tool.nio.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PatternNameExtractor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			usage();
		}
		XSSFWorkbook workbook = new XSSFWorkbook();
		OutputStream outputStream = null;
		Path start = FileSystems.getDefault().getPath(args[0]);
		String path = args[1];
		try {
			outputStream = new FileOutputStream(path);
			FileVisitor<Path> visitor = new PatternNameExtractVisitor<Path>(
					workbook);
			Files.walkFileTree(start, visitor);
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

}
