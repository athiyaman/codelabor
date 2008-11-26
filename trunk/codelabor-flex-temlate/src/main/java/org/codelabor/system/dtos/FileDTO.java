package org.codelabor.system.dtos;

import java.io.Serializable;

public class FileDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8079212665085519859L;

	protected int fileId;

	protected String realFileName;

	protected String uniqueFileName;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	protected String repositoryPath;

	protected String contentType;

	protected int fileSize;

	protected byte[] bytes;

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getRealFileName() {
		return realFileName;
	}

	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}

	public String getRepositoryPath() {
		return repositoryPath;
	}

	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	public String getUniqueFileName() {
		return uniqueFileName;
	}

	public void setUniqueFileName(String uniqueFileName) {
		this.uniqueFileName = uniqueFileName;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("FileDTO ( ")
	        .append(super.toString()).append(TAB)
	        .append("bytes = ").append(this.bytes).append(TAB)
	        .append("contentType = ").append(this.contentType).append(TAB)
	        .append("fileId = ").append(this.fileId).append(TAB)
	        .append("fileSize = ").append(this.fileSize).append(TAB)
	        .append("realFileName = ").append(this.realFileName).append(TAB)
	        .append("repositoryPath = ").append(this.repositoryPath).append(TAB)
	        .append("uniqueFileName = ").append(this.uniqueFileName).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}

}
