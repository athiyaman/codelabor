/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.codelabor.system.xplatform.ant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

/**
 * Compiles XPLATFORM files.
 *
 * @author Shin Sang-jae
 *
 */
public class Xml2bin extends Task {

	protected File iniFile;
	protected String logFile;
	protected File destDir;
	protected String executable;
	protected boolean failonerror = true;
	protected int verbosity = Project.MSG_VERBOSE;
	protected int exitValue = -1;
	protected String encoding = "EUC-KR";
	protected List<FileSet> fileSets = new ArrayList<FileSet>();
	private final static String FILE_SEPARATOR = System
			.getProperty("file.separator");
	private final static String LINE_SEPARATOR = System
			.getProperty("line.separator");
	private final static String TAB = "\t";

	@Override
	public void init() throws BuildException {
		super.init();
	}

	@Override
	public void execute() throws BuildException {
		super.execute();

		generateIni();
		xml2bin();
	}

	/**
	 * Generates .ini file.
	 */
	protected void generateIni() {
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(iniFile),
					encoding);
			validateAttributes();
			DirectoryScanner ds = null;

			StringBuilder sb = new StringBuilder();
			for (FileSet fileSet : fileSets) {
				ds = fileSet.getDirectoryScanner(getProject());
				File baseDir = ds.getBasedir();
				if (destDir == null)
					destDir = baseDir;
				log("baseDir: " + baseDir.toString(), verbosity);
				log("destDir: " + destDir.toString(), verbosity);
				String[] includedFileNames = ds.getIncludedFiles();

				log(TAB + "file count:" + includedFileNames.length, verbosity);

				for (String includedFileName : includedFileNames) {
					log(TAB + "included file name: " + includedFileName,
							verbosity);

					// first column
					sb.append("1,");

					// second column
					sb.append(baseDir).append(FILE_SEPARATOR);
					sb.append(includedFileName).append(",");

					// third column
					sb.append(destDir);
					sb.append(FILE_SEPARATOR);
					sb.append(includedFileName);
					sb.append(LINE_SEPARATOR);

					// make destination directory
					StringBuilder destDirFullyQualifiedPath = new StringBuilder();
					destDirFullyQualifiedPath.append(destDir);
					destDirFullyQualifiedPath.append(FILE_SEPARATOR);
					destDirFullyQualifiedPath.append(includedFileName);
					int lastIndex = destDirFullyQualifiedPath
							.lastIndexOf(FILE_SEPARATOR);
					destDirFullyQualifiedPath.delete(lastIndex,
							destDirFullyQualifiedPath.length());
					File destDirFinal = new File(
							destDirFullyQualifiedPath.toString());

					FileUtils.forceMkdir(destDirFinal);

					log(TAB + "make dir: "
							+ destDirFullyQualifiedPath.toString(), verbosity);

				}
				writer.write(sb.toString());
				writer.flush();
			}
		} catch (IOException e) {
			if (failonerror) {
				throw new BuildException(e);
			} else {
				log("Warning: " + getMessage(e), Project.MSG_ERR);
			}
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				if (failonerror) {
					throw new BuildException(e);
				} else {
					log("Warning: " + getMessage(e), Project.MSG_ERR);
				}
			}
		}
	}

	/**
	 * Compiles XPLATFORM files.
	 */
	protected void xml2bin() {
		String[] commandArray = new String[] { executable,
				iniFile.getAbsolutePath(), logFile };
		Process proc = null;
		BufferedReader stdOut = null;
		BufferedReader stdError = null;
		try {
			proc = new ProcessBuilder(commandArray).start();
			stdOut = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			stdError = new BufferedReader(new InputStreamReader(
					proc.getErrorStream()));

			String lineOfText = null;
			while (true) {
				lineOfText = stdOut.readLine();
				if (lineOfText == null) {
					break;
				} else {
					log(lineOfText, verbosity);
				}
			}
			while (true) {
				lineOfText = stdError.readLine();
				if (lineOfText == null) {
					break;
				} else {
					log(lineOfText, Project.MSG_ERR);
				}
			}

			exitValue = proc.exitValue();

			if (exitValue != 0) {
				if (failonerror) {
					throw new BuildException("Exec returned: " + exitValue,
							getLocation());
				} else {
					log("Result: " + exitValue, Project.MSG_ERR);
				}
			}
		} catch (IOException e) {
			if (failonerror) {
				throw new BuildException(e);
			} else {
				log("Warning: " + getMessage(e), Project.MSG_ERR);
			}
		} finally {
			try {
				if (stdOut != null) {
					stdOut.close();
				}
				if (stdError != null) {
					stdError.close();
				}
			} catch (IOException e) {
				if (failonerror) {
					throw new BuildException(e);
				} else {
					log("Warning: " + getMessage(e), Project.MSG_ERR);
				}
			}

		}
	}

	public void addFileSet(FileSet fileSet) {
		if (!fileSets.contains(fileSet)) {
			fileSets.add(fileSet);
		}
	}

	/**
	 * Ensure we have a consistent and legal set of attributes, and set any
	 * internal flags necessary based on different combinations of attributes.
	 *
	 * @exception BuildException
	 *                if an error occurs.
	 */
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

		if (fileSets.isEmpty()) {
			throw new BuildException("fileset required!");
		}
	}

	/**
	 * Handle getMessage() for exceptions.
	 *
	 * @param ex
	 *            the exception to handle
	 * @return ex.getMessage() if ex.getMessage() is not null otherwise return
	 *         ex.toString()
	 */
	protected String getMessage(Exception ex) {
		return ex.getMessage() == null ? ex.toString() : ex.getMessage();
	}

	/**
	 * Set the character encoding.
	 *
	 * @param encoding
	 *            the character encoding.
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Set .ini file to generate.
	 *
	 * @param iniFile
	 *            fully qualified path
	 */
	public void setIniFile(File iniFile) {
		this.iniFile = iniFile;
	}

	/**
	 * Set destination directory.
	 *
	 * @param destDir
	 *            destination directory.
	 */
	public void setDestDir(File destDir) {
		this.destDir = destDir;
	}

	/**
	 * Set verbose mode.
	 *
	 * @param verbose
	 *            where to output log messages. Default is false.
	 */
	public void setVerbose(boolean verbose) {
		this.verbosity = verbose ? Project.MSG_INFO : Project.MSG_VERBOSE;
	}

	/**
	 * Set whether to fail when errors are encountered. If false, note errors to
	 * the output but keep going. Default is true.
	 *
	 * @param failonerror
	 *            true or false.
	 */
	public void setFailOnError(boolean failonerror) {
		this.failonerror = failonerror;
	}

	/**
	 * Set XPLATFORM xml2bin.exe.
	 *
	 * @param executable
	 *            fully qualified path.
	 */
	public void setExecutable(String executable) {
		this.executable = executable;
	}

	/**
	 * Set log file to generate.
	 *
	 * @param logFile
	 *            fully qualified path.
	 */
	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}

}
