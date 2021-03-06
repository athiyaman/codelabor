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
 * The xml2bin task compile XPLATFORM .xfdl files. This task will work on
 * Windows using the external xml2bin executable (provided by TOBESOFT).
 * 
 * @author Shin Sang-jae
 * 
 */
public class Xml2bin extends Task {

	/**
	 * xml2bin .ini file.
	 */
	protected File iniFile;
	/**
	 * Log file fully qualified path.
	 */
	protected String logFile;
	/**
	 * Destination directory
	 */
	protected File destDir;
	/**
	 * xml2bin.exe executable file fully qualified path.
	 */
	protected String executable;
	/**
	 * Fail on error flag.
	 */
	protected boolean failonerror = true;
	/**
	 * Verbosity
	 */
	protected int verbosity = Project.MSG_VERBOSE;
	/**
	 * Exit value
	 */
	protected int exitValue = -1;
	/**
	 * Charater encoding
	 */
	protected String encoding = "EUC-KR";
	/**
	 * File sets
	 */
	protected List<FileSet> fileSets = new ArrayList<FileSet>();
	/**
	 * File separator
	 */
	private final static String FILE_SEPARATOR = System
			.getProperty("file.separator");
	/**
	 * Line separator
	 */
	private final static String LINE_SEPARATOR = System
			.getProperty("line.separator");
	/**
	 * Tab
	 */
	private final static String TAB = "\t";

	/**
	 * Maximum length of source, target path. (drive character and file
	 * extension included)
	 */
	private final int MAX_PATH_LENGTH = 192;

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

			StringBuilder row = new StringBuilder();
			for (FileSet fileSet : fileSets) {
				ds = fileSet.getDirectoryScanner(getProject());
				File baseDir = ds.getBasedir();
				if (destDir == null) {
					destDir = baseDir;
				}
				log("baseDir: " + baseDir.toString(), verbosity);
				log("destDir: " + destDir.toString(), verbosity);
				String[] includedFileNames = ds.getIncludedFiles();

				log(TAB + "file count:" + includedFileNames.length, verbosity);

				for (String includedFileName : includedFileNames) {
					log(TAB + "included file name: " + includedFileName,
							verbosity);

					// source path
					StringBuilder sourcePath = new StringBuilder();
					sourcePath.append(baseDir);
					sourcePath.append(FILE_SEPARATOR);
					sourcePath.append(includedFileName);
					validatePathLength(sourcePath.toString());

					// target path
					StringBuilder targetPath = new StringBuilder();
					targetPath.append(destDir);
					targetPath.append(FILE_SEPARATOR);
					targetPath.append(includedFileName);
					validatePathLength(targetPath.toString());

					// first column
					row.append("1");
					row.append(",");

					// second column
					row.append(sourcePath.toString());
					row.append(",");

					// third column
					row.append(targetPath.toString());
					row.append(LINE_SEPARATOR);

					// make destination directory
					StringBuilder destDirFullyQualifiedPath = new StringBuilder();
					destDirFullyQualifiedPath.append(targetPath.toString());
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
				writer.write(row.toString());
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
		String[] commandArray = null;
		if (logFile != null) {
			commandArray = new String[] { executable,
					iniFile.getAbsolutePath(), logFile };
		} else {
			commandArray = new String[] { executable, iniFile.getAbsolutePath() };
		}

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
			log("Result: " + exitValue, verbosity);

			if (exitValue != 0) {
				if (failonerror) {
					throw new BuildException("Exec returned: " + exitValue,
							getLocation());
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

	/**
	 * Add file set
	 * 
	 * @param fileSet
	 *            file set for compile
	 */
	public void addFileSet(FileSet fileSet) {
		if (!fileSets.contains(fileSet)) {
			fileSets.add(fileSet);
		}
	}

	/**
	 * Ensure source, target path length does not exceed MAX_PATH_LENGTH.
	 * 
	 * @param path
	 *            The file path (drive character and file extension included).
	 * @throws BuildException
	 *             if path length exceeded.
	 */
	protected void validatePathLength(String path) throws BuildException {
		if (path.length() > MAX_PATH_LENGTH) {
			StringBuilder msg = new StringBuilder();
			msg.append("Path length exceeded: ");
			msg.append(path.length());
			msg.append(" > ");
			msg.append(MAX_PATH_LENGTH);
			msg.append(": ");
			msg.append(path);
			if (failonerror) {
				throw new BuildException(msg.toString());
			} else {
				log("Warning: " + msg.toString(), Project.MSG_ERR);
			}
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
