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

package org.codelabor.system.file.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.mime.utils.TikaMimeDetectUtils;
import org.codelabor.system.utils.ChannelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 업로드 유티릴티
 * 
 * @author Shin Sangjae
 * 
 */
public class UploadUtils {
	/**
	 * 로거
	 */
	public static final Logger logger = LoggerFactory
			.getLogger(UploadUtils.class);

	/**
	 * 파일을 처리한다.</br> 파일 저장 방식이 FILE_SYSTEM인 경우, 디스크에 저장하고 DATABASE인 경우 byte[]로
	 * 변환하여 DTO에 담는다.
	 * 
	 * @param repositoryType
	 *            파일 저장 방식
	 * @param inputStream
	 *            입력 스트림
	 * @param fileDTOList
	 *            파일 DTO List
	 * @throws Exception
	 *             예외
	 */
	static public void processFile(RepositoryType repositoryType,
			InputStream inputStream, List<FileDTO> fileDTOList)
			throws Exception {
		for (int i = 0; i < fileDTOList.size(); i++) {
			FileDTO tempFileDTO = fileDTOList.get(i);
			processFile(repositoryType, inputStream, tempFileDTO);
			fileDTOList.add(i, tempFileDTO);
		}
	}

	/**
	 * 파일을 처리한다.</br> 파일 저장 방식이 FILE_SYSTEM인 경우, 디스크에 저장하고 DATABASE인 경우 byte[]로
	 * 변환하여 DTO에 담는다.
	 * 
	 * @param repositoryType
	 *            파일 저장 방식
	 * @param inputStream
	 *            입력 스트림
	 * @param fileDTO
	 *            파일 DTO
	 * @throws Exception
	 *             예외
	 */
	static public void processFile(RepositoryType repositoryType,
			InputStream inputStream, FileDTO fileDTO) throws Exception {
		// prepare io
		OutputStream outputStream = null;
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;

		int fileSize = 0;
		StringBuilder stringBuilder = new StringBuilder();
		switch (repositoryType) {
		case FILE_SYSTEM:
			// prepare repository
			File repository = new File(fileDTO.getRepositoryPath());
			String repositoryPath = fileDTO.getRepositoryPath();

			if (logger.isDebugEnabled()) {
				stringBuilder = new StringBuilder();
				stringBuilder.append("repositoryPath: ").append(repositoryPath);
				stringBuilder.append(", repositoryType: ").append(
						repositoryType);
				stringBuilder.append(", repository.exists(): ").append(
						repository.exists());
				stringBuilder.append(", repository.isDirectory(): ").append(
						repository.isDirectory());
				logger.debug(stringBuilder.toString());
			}

			// prepare directory
			File file = new File(repositoryPath);
			if (!file.exists()) {
				boolean mkdirsSuccess = file.mkdirs();
				logger.debug("mkdirs: {}, success: {}", repositoryPath,
						mkdirsSuccess);
			}

			// prepare stream
			stringBuilder = new StringBuilder();
			stringBuilder.append(fileDTO.getRepositoryPath());
			if (!fileDTO.getRepositoryPath().endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(fileDTO.getUniqueFileName());
			outputStream = new FileOutputStream(stringBuilder.toString());

			// copy channel
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			fileSize = ChannelUtils.copy(inputChannel, outputChannel);

			// set vo
			if (StringUtils.isEmpty(fileDTO.getContentType())) {
				fileDTO.setContentType(TikaMimeDetectUtils.getMimeType(file));
			}
			break;
		case DATABASE:
			// prepare steam
			outputStream = new ByteArrayOutputStream();

			// copy channel
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			fileSize = ChannelUtils.copy(inputChannel, outputChannel);

			// set vo
			byte[] bytes = ((ByteArrayOutputStream) outputStream).toByteArray();
			fileDTO.setBytes(bytes);
			fileDTO.setRepositoryPath(null);
			if (StringUtils.isEmpty(fileDTO.getContentType())) {
				fileDTO.setContentType(TikaMimeDetectUtils.getMimeType(bytes));
			}
			break;
		}
		fileDTO.setFileSize(fileSize);

		// close io
		inputChannel.close();
		outputChannel.close();
		inputStream.close();
		outputStream.close();
	}

	/**
	 * 파일명을 가져온다.
	 * 
	 * @param realFileNameWithPath
	 *            경로를 포함한 파일명
	 * @return 경로를 포함하지 않는 파일명
	 */
	static public String stripPathInfo(String realFileNameWithPath) {
		// int lastIndex = realFileNameWithPath.lastIndexOf(System
		// .getProperty("file.separator"));

		// for unix client
		int lastIndex = realFileNameWithPath.lastIndexOf("/");
		// for windows client
		if (lastIndex < 0) {
			lastIndex = realFileNameWithPath.lastIndexOf("\\");
		}

		int beginIndex = (lastIndex > 0) ? lastIndex + 1 : 0;
		String realFileName = realFileNameWithPath.substring(beginIndex);

		logger.debug("realFileNameWithPath: {}", realFileNameWithPath);
		logger.debug("realFileName: {}", realFileName);
		return realFileName;
	}
}
