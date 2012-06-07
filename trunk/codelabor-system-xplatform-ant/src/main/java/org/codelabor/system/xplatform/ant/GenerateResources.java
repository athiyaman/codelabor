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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

public class GenerateResources extends Task {

	protected File iniFile;
	protected File destDir;
	protected boolean mkDir = true;
	protected boolean failonerror = true;
	protected int verbosity = Project.MSG_VERBOSE;

	@Override
	public void init() throws BuildException {
		super.init();
	}

	protected String encoding = "EUC-KR";

	private final static String FILE_SEPARATOR = System
			.getProperty("file.separator");
	private final static String LINE_SEPARATOR = System
			.getProperty("line.separator");
	private final static String TAB = "\t";

	protected Vector<FileSet> fileSets = new Vector<FileSet>();

	@Override
	public void execute() throws BuildException {
		super.execute();
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
					if (mkDir) {
						StringBuilder destDirFinalStringBuilder = new StringBuilder();
						destDirFinalStringBuilder.append(destDir);
						destDirFinalStringBuilder.append(FILE_SEPARATOR);
						destDirFinalStringBuilder.append(includedFileName);
						int lastIndex = destDirFinalStringBuilder
								.lastIndexOf(FILE_SEPARATOR);
						destDirFinalStringBuilder.delete(lastIndex,
								destDirFinalStringBuilder.length());
						File destDirFinal = new File(
								destDirFinalStringBuilder.toString());
						FileUtils.forceMkdir(destDirFinal);
						log(TAB + "make dir: "
								+ destDirFinalStringBuilder.toString(),
								verbosity);
					}

				}
				writer.write(sb.toString());
				writer.flush();
			}
		} catch (FileNotFoundException e) {
			if (failonerror) {
				throw new BuildException(e);
			} else {
				log("Warning: " + getMessage(e), Project.MSG_ERR);
			}
		} catch (IOException e) {
			if (failonerror) {
				throw new BuildException(e);
			} else {
				log("Warning: " + getMessage(e), Project.MSG_ERR);
			}
		} finally {
			try {
				writer.close();
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

	public void setEncoding(String charSet) {
		this.encoding = charSet;
	}

	public void setIniFile(File destFile) {
		this.iniFile = destFile;
	}

	public void setDestDir(File destDir) {
		this.destDir = destDir;
	}

	public void setMkDir(boolean mkDir) {
		this.mkDir = mkDir;
	}

	public void setVerbose(boolean verbose) {
		this.verbosity = verbose ? Project.MSG_INFO : Project.MSG_VERBOSE;
	}

	public void setFailOnError(boolean failonerror) {
		this.failonerror = failonerror;
	}

}
