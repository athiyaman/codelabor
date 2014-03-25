package org.codelabor.example.nio.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class FilesTest {

	// @Test
	// public void
	// testWalkFileTreePathSetOfFileVisitOptionIntFileVisitorOfQsuperPath() {
	// fail("Not yet implemented");
	// }

	@Test
	public void testWalkFileTreePathFileVisitorOfQsuperPath() {
		Path start = FileSystems.getDefault().getPath("C:/Users/bomber/git");
		FileVisitor<Path> visitor = new PatternNameExtractor<Path>();
		try {
			Files.walkFileTree(start, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
