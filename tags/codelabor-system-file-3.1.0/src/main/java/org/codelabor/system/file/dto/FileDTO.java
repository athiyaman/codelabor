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

package org.codelabor.system.file.dto;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 파일DTO
 * @author Shin Sang-jae
 *
 */
/**
 * @author Shin Sang-jae
 * 
 */
public class FileDTO implements Serializable {
	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -8079212665085519859L;

	/**
	 * 파일 ID
	 */
	protected String fileId;

	/**
	 * 매핑 ID
	 */
	protected String mapId;

	/**
	 * 실제 파일명
	 */
	protected String realFilename;

	/**
	 * 파일 저장 방식</br> 파일 시스템 저장 방식(FILE_SYSTEM)과 데이터베이스 BLOB 저장 방식(DATABASE)이 있다.
	 */
	protected String repositoryPath;

	/**
	 * 파일의 컨텐트 타입
	 */
	protected String contentType;

	/**
	 * 파일 크기
	 */
	protected long fileSize;

	/**
	 * 파일 내용
	 */
	protected byte[] bytes;

	/**
	 * 고유 파일명</br> 파일을 파일 시스템에 저장할 경우, 파일명 중복으로 인한 오동작을 막기 위해 사용하는 유일한 파일명
	 */
	protected String uniqueFilename;

	/**
	 * 생성자
	 */
	public FileDTO() {
		super();
	}

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
		this.realFilename = fileDTO.realFilename;
		this.repositoryPath = fileDTO.repositoryPath;
		this.uniqueFilename = fileDTO.uniqueFilename;
	}

	/**
	 * 생성자
	 * 
	 * @param fileId
	 *            파일 ID
	 * @param mapId
	 *            매핑 ID
	 * @param realFilename
	 *            실제 파일명
	 * @param uniqueFilename
	 *            고유 파일명
	 * @param repositoryPath
	 *            저장 방식
	 * @param contentType
	 *            컨텐트 타입
	 * @param fileSize
	 *            파일 크기
	 * @param bytes
	 *            파일 내용
	 */
	public FileDTO(String fileId, String mapId, String realFilename,
			String uniqueFilename, String repositoryPath, String contentType,
			long fileSize, byte[] bytes) {
		super();
		this.fileId = fileId;
		this.mapId = mapId;
		this.realFilename = realFilename;
		this.uniqueFilename = uniqueFilename;
		this.repositoryPath = repositoryPath;
		this.contentType = contentType;
		this.fileSize = fileSize;
		this.bytes = bytes;
	}

	/**
	 * 컨텐트 타입 을 가져온다.
	 * 
	 * @return 컨텐트 타입
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * 컨텐트 타입을 설정한다.
	 * 
	 * @param contentType
	 *            컨텐트 타입
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * 매핑 ID를 가져온다.
	 * 
	 * @return 매핑 ID
	 */
	public String getMapId() {
		return mapId;
	}

	/**
	 * 매핑 ID를 설정한다.
	 * 
	 * @param mapId
	 *            매핑 ID
	 */
	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	/**
	 * 파일 크기를 가져온다.
	 * 
	 * @return 파일 크기
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * 파일 크기를 설정한다.
	 * 
	 * @param fileSize
	 *            파일 크기
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * 파일 내용을 가져온다.
	 * 
	 * @return 파일 내용
	 */
	public byte[] getBytes() {
		return bytes;
	}

	/**
	 * 파일 내용을 설정한다.
	 * 
	 * @param bytes
	 *            파일 내용
	 */
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	/**
	 * 파일 ID를 가져온다.
	 * 
	 * @return 파일 ID
	 */
	public String getFileId() {
		return fileId;
	}

	/**
	 * 파일 ID를 설정한다.
	 * 
	 * @param fileId
	 *            파일 ID
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/**
	 * 실제 파일명을 가져온다.
	 * 
	 * @return 실제 파일명
	 */
	public String getRealFilename() {
		return realFilename;
	}

	/**
	 * 실제 파일명을 설정한다.
	 * 
	 * @param realFilename
	 *            실제 파일명
	 */
	public void setRealFilename(String realFilename) {
		this.realFilename = realFilename;
	}

	/**
	 * 파일 저장 방식을 가져온다.
	 * 
	 * @return 파일 저장 방식
	 */
	public String getRepositoryPath() {
		return repositoryPath;
	}

	/**
	 * 파일 저장 방식을 설정한다.
	 * 
	 * @param repositoryPath
	 *            파일 저장 방식
	 */
	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	/**
	 * 고유 파일명을 가져온다.
	 * 
	 * @return 고유 파일명
	 */
	public String getUniqueFilename() {
		return uniqueFilename;
	}

	/**
	 * 고유 파일명을 설정한다.
	 * 
	 * @param uniqueFilename
	 *            고유 파일명
	 */
	public void setUniqueFilename(String uniqueFilename) {
		this.uniqueFilename = uniqueFilename;
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
				.append("bytes = ").append(Arrays.toString(this.bytes))
				.append(TAB).append("contentType = ").append(this.contentType)
				.append(TAB).append("fileId = ").append(this.fileId)
				.append(TAB).append("fileSize = ").append(this.fileSize)
				.append(TAB).append("mapId = ").append(this.mapId).append(TAB)
				.append("realFilename = ").append(this.realFilename)
				.append(TAB).append("repositoryPath = ")
				.append(this.repositoryPath).append(TAB)
				.append("uniqueFilename = ").append(this.uniqueFilename)
				.append(TAB).append(" )");

		return retValue.toString();
	}

}
