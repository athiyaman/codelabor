package org.codelabor.tool.nio.file;

import static org.junit.Assert.fail;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class FilesTest {

	@Test
	public void testWalkFileTreePathFileVisitorOfQsuperPath() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		OutputStream outputStream = null;
		Path start = FileSystems.getDefault().getPath("C:/Users/bomber/git");
		String path = "pattern.xlsx";
		try {
			outputStream = new FileOutputStream(path);
			FileVisitor<Path> visitor = new PatternNameExtractVisitor<Path>(
					workbook);
			Files.walkFileTree(start, visitor);
			workbook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					fail();
				}
			}
		}

	}
}
