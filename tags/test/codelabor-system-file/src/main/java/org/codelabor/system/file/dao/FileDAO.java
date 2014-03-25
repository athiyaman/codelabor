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

package org.codelabor.system.file.dao;

import java.util.List;

import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dto.FileDTO;

/**
 * 파일 DAO 인터페이스
 * 
 * @author Shin Sang-jae
 * 
 */
public interface FileDAO {

	/**
	 * 파일 정보를 저장한다. 파일 저장 방식(Repository Type)이 DATABASE인 경우, 파일의 내용이 BLOB 형태로 함께
	 * 저장되나, FILE_SYSTEM인 경우, 파일 정보만 저장된다.
	 * 
	 * @param fileDTO
	 *            파일 DTO
	 * @return 등록 건수
	 * @throws Exception
	 */
	public int insertFile(FileDTO fileDTO) throws Exception;

	/**
	 * 파일 정보를 저장한다. 파일 저장 방식(Repository Type)이 DATABASE인 경우, 파일의 내용이 BLOB 형태로 함께
	 * 저장되나, FILE_SYSTEM인 경우, 파일 정보만 저장된다.
	 * 
	 * @param fileDTOList
	 *            파일 DTO의 List
	 * @return 등록 건수
	 * @throws Exception
	 */
	public int insertFile(List<FileDTO> fileDTOList) throws Exception;

	/**
	 * 현재 관리되고 있는 파일들 중 지정한 저장 방식(Repository Type)에 해당하는 파일 정보만 가져온다.
	 * 
	 * @param repositoryType
	 *            파일 저장 방식
	 * @return 파일 DTO의 List
	 * @throws Exception
	 *             예외
	 */
	public List<FileDTO> selectFileByRepositoryType(
			RepositoryType repositoryType) throws Exception;

	/**
	 * 현재 관리되고 있는 모든 파일 정보를 가져온다.
	 * 
	 * @return 파일 DTO의 List
	 * @throws Exception
	 *             예외
	 * @deprecated Replaced by {@link #selectFileAll()}
	 */
	public List<FileDTO> selectFile() throws Exception;

	/**
	 * 지정한 파일 ID에 해당하는 파일 정보를 가져온다.
	 * 
	 * @param fileId
	 *            파일 ID
	 * @return 파일 DTO
	 * @throws Exception
	 *             예외
	 */
	public FileDTO selectFileByFileId(String fileId) throws Exception;

	/**
	 * 지정한 매핑 ID와 연관된 파일들의 정보를 가져온다. 하나의 매핑 ID에 여러 파일들을 매핑할 수 있는데, 예를 들어 하나의
	 * 게시물에 여러 첨부 파일이 필요할 경우 활용된다.
	 * 
	 * @param mapId
	 *            매핑 ID
	 * @return 파일 DTO의 List
	 * @throws Exception
	 */
	public List<FileDTO> selectFileByMapId(String mapId) throws Exception;

	/**
	 * 파일 매니저에 관리되는 모든 파일 정보를 삭제한다. 파일 저장 방식(Repository Type)이 FILE_SYSTEM인 경우,
	 * 파일 시스템에 저장한 물리적 파일은 삭제하지 않고 파일 정보만 삭제된다.
	 * @return 삭제 건수
	 * @throws Exception
	 */
	public int deleteAll() throws Exception;

	/**
	 * 현재 관리되고 있는 모든 파일 정보를 가져온다.
	 * 
	 * @return 파일 DTO의 List
	 * @throws Exception
	 */
	public List<FileDTO> selectFileAll() throws Exception;

	/**
	 * 지정한 파일 ID에 해당하는 파일 정보를 삭제한다. 파일 저장 방식(Repository Type)이 FILE_SYSTEM인 경우,
	 * 파일 시스템에 저장한 물리적 파일은 삭제하지 않고 파일 정보만 삭제된다.
	 * 
	 * @param fileId
	 *            파일 ID
	 * @return 삭제 건수
	 * @throws Exception
	 * @deprecated Replaced by {@link #deleteFileByFileId(String)}
	 */
	@Deprecated
	public int deleteFile(String fileId) throws Exception;

	/**
	 * 지정한 파일 ID에 해당하는 파일 정보를 삭제한다. 파일 저장 방식(Repository Type)이 FILE_SYSTEM인 경우,
	 * 파일 시스템에 저장한 물리적 파일은 삭제하지 않고 파일 정보만 삭제된다.
	 * 
	 * @param fileIdList
	 *            파일 ID의 배열
	 * @return 삭제 건수
	 * @throws Exception
	 * @depreated Replaced by {@link #deleteFile(String[])}
	 */
	@Deprecated
	public int deleteFile(String[] fileIdList) throws Exception;

	/**
	 * 지정한 파일 ID에 해당하는 파일 정보를 삭제한다. 파일 저장 방식(Repository Type)이 FILE_SYSTEM인 경우,
	 * 파일 시스템에 저장한 물리적 파일은 삭제하지 않고 파일 정보만 삭제된다.
	 * 
	 * @param fileId
	 *            파일 ID
	 * @return 삭제 건수
	 * @throws Exception
	 */
	public int deleteFileByFileId(String fileId) throws Exception;

	/**
	 * 지정한 파일 ID에 해당하는 파일 정보를 삭제한다. 파일 저장 방식(Repository Type)이 FILE_SYSTEM인 경우,
	 * 파일 시스템에 저장한 물리적 파일은 삭제하지 않고 파일 정보만 삭제된다.
	 * 
	 * @param fileIdList
	 *            파일 ID의 배열
	 * @return 삭제 건수
	 * @throws Exception
	 */
	public int deleteFileByFileId(String[] fileIdList) throws Exception;

	/**
	 * 지정한 맵 ID에 해당하는 파일 정보를 삭제한다. 파일 저장 방식(Repository Type)이 FILE_SYSTEM인 경우,
	 * 파일 시스템에 저장한 물리적 파일은 삭제하지 않고 파일 정보만 삭제된다.
	 * 
	 * @param mapId
	 *            맵 ID
	 * @return 삭제 건수
	 * @throws Exception
	 */
	public int deleteFileByMapId(String mapId) throws Exception;

	/**
	 * 지정한 맵 ID에 해당하는 파일 정보를 삭제한다. 파일 저장 방식(Repository Type)이 FILE_SYSTEM인 경우,
	 * 파일 시스템에 저장한 물리적 파일은 삭제하지 않고 파일 정보만 삭제된다.
	 * 
	 * @param mapIdList
	 *            맵 ID의 배열
	 * @return 삭제 건수
	 * @throws Exception
	 */
	public int deleteFileByMapId(String[] mapIdList) throws Exception;

}
