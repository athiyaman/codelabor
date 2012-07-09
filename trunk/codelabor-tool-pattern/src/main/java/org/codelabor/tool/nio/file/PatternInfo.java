package org.codelabor.tool.nio.file;

import java.io.Serializable;

public class PatternInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3941686102064282175L;
	private String patternName;
	private String fileName;
	private String path;

	/**
	 * @return the patternName
	 */
	public String getPatternName() {
		return patternName;
	}

	/**
	 * @param patternName
	 *            the patternName to set
	 */
	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

}
