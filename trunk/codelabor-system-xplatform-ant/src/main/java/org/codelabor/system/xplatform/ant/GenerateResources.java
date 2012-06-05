package org.codelabor.system.xplatform.ant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Vector;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

public class GenerateResources extends Task {

	protected File iniFile;
	protected File destDir;
	protected String charSet = "EUC-KR";

	protected Vector<FileSet> fileSets = new Vector<FileSet>();

	@Override
	public void execute() throws BuildException {
		super.execute();
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(iniFile),
					charSet);

			validateAttributes();
			DirectoryScanner ds = null;

			StringBuilder sb = new StringBuilder();
			for (FileSet fileSet : fileSets) {
				ds = fileSet.getDirectoryScanner(getProject());
				File baseDir = ds.getBasedir();
				log("base dir: " + baseDir.toString());
				String[] includedFileNames = ds.getIncludedFiles();

				log("  file count:" + includedFileNames.length);
				for (String includedFileName : includedFileNames) {
					log("  included file name: " + includedFileName);

					// first column
					sb.append("1,");

					// second column
					sb.append(baseDir).append(
							System.getProperty("file.separator"));
					sb.append(includedFileName).append(",");

					// third column
					if (destDir != null) {
						sb.append(destDir);
					} else {
						sb.append(baseDir);
					}
					sb.append(System.getProperty("file.separator"));
					sb.append(includedFileName);
					sb.append(System.getProperty("line.separator"));
				}
				writer.write(sb.toString());
				writer.flush();
			}
		} catch (FileNotFoundException e) {
			throw new BuildException(e);
		} catch (IOException e) {
			throw new BuildException(e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new BuildException(e);
			}
		}

	}

	public void addFileSet(FileSet fileSet) {
		if (!fileSets.contains(fileSet)) {
			fileSets.add(fileSet);
		}
	}

	protected void validateAttributes() throws BuildException {
		if (iniFile == null) {
			throw new BuildException("inifile required!");
		} else {
			if (iniFile.exists()) {
				if (iniFile.isDirectory()) {
					throw new BuildException("inifile is a directory!",
							getLocation());
				}
				if (!iniFile.canWrite()) {
					throw new BuildException(
							"Can not write to the specified inifile!",
							getLocation());
				}
			}
		}

		if (destDir != null) {
			if (destDir.exists()) {
				if (!destDir.isDirectory()) {
					throw new BuildException("destdir is not a directory!",
							getLocation());
				}
				if (!destDir.canWrite()) {
					throw new BuildException(
							"Can not write to the specified destdir!",
							getLocation());
				}
			} else {
				destDir.mkdir();
			}
		}

		if (fileSets.size() == 0) {
			throw new BuildException("fileset required!");
		}
	}

	public String getCharSet() {
		return charSet;
	}

	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}

	public File getIniFile() {
		return iniFile;
	}

	public void setIniFile(File destFile) {
		this.iniFile = destFile;
	}

	public File getDestDir() {
		return destDir;
	}

	public void setDestDir(File destDir) {
		this.destDir = destDir;
	}

}
