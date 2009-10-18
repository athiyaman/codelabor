/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.system.file.dtos;

import java.io.Serializable;

/**
 * @author Sang Jae Shin
 * 
 */
public class FileDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8079212665085519859L;

	protected String fileId;

	protected String mapId;

	protected String realFileName;

	protected String uniqueFileName;

	/**
	 * Copy Constructor
	 * 
	 * @param fileDTO
	 *            a <code>FileDTO</code> object
	 */
	public FileDTO(FileDTO fileDTO) {
		this.bytes = fileDTO.bytes;
		this.contentType = fileDTO.contentType;
		this.fileId = fileDTO.fileId;
		this.fileSize = fileDTO.fileSize;
		this.mapId = fileDTO.mapId;
		this.realFileName = fileDTO.realFileName;
		this.repositoryPath = fileDTO.repositoryPath;
		this.uniqueFileName = fileDTO.uniqueFileName;
	}

	public FileDTO() {
		super();
	}

	public FileDTO(String fileId, String mapId, String realFileName,
			String uniqueFileName, String repositoryPath, String contentType,
			long fileSize, byte[] bytes) {
		super();
		this.fileId = fileId;
		this.mapId = mapId;
		this.realFileName = realFileName;
		this.uniqueFileName = uniqueFileName;
		this.repositoryPath = repositoryPath;
		this.contentType = contentType;
		this.fileSize = fileSize;
		this.bytes = bytes;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	protected String repositoryPath;

	protected String contentType;

	protected long fileSize;

	protected byte[] bytes;

	public String getMapId() {
		return mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
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
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("FileDTO ( ").append(super.toString()).append(TAB)
				.append("bytes = ").append(this.bytes).append(TAB).append(
						"contentType = ").append(this.contentType).append(TAB)
				.append("fileId = ").append(this.fileId).append(TAB).append(
						"fileSize = ").append(this.fileSize).append(TAB)
				.append("mapId = ").append(this.mapId).append(TAB).append(
						"realFileName = ").append(this.realFileName)
				.append(TAB).append("repositoryPath = ").append(
						this.repositoryPath).append(TAB).append(
						"uniqueFileName = ").append(this.uniqueFileName)
				.append(TAB).append(" )");

		return retValue.toString();
	}

}
