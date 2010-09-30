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

package org.codelabor.system.file.web.spring.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.codelabor.system.file.FileConstants;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.exceptions.InvalidRepositoryTypeException;
import org.codelabor.system.web.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * 파일 목록 조회 Controller
 * 
 * @author Shin Sangjae
 * 
 */
public class FileListController extends BaseFileController {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(FileListController.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap", paramMap.toString());

		String mapId = (String) paramMap.get("mapId");
		String repositoryType = (String) paramMap.get("repositoryType");

		List<FileDTO> fileDTOList = null;
		ModelAndView mav = null;
		try {
			if (StringUtils.isEmpty(repositoryType)) {
				if (StringUtils.isEmpty(mapId)) {
					fileDTOList = fileManager.selectFile();
				} else {
					fileDTOList = fileManager.selectFileByMapId(mapId);
				}
			} else {
				switch (RepositoryType.valueOf(repositoryType)) {
				case DATABASE:
					fileDTOList = fileManager
							.selectFileByRepositoryType(RepositoryType.DATABASE);
					break;
				case FILE_SYSTEM:
					fileDTOList = fileManager
							.selectFileByRepositoryType(RepositoryType.FILE_SYSTEM);
					break;
				default:
					throw new InvalidRepositoryTypeException(repositoryType);
				}

			}
			mav = new ModelAndView(getSuccessView());
			mav.addObject(FileConstants.FILE_LIST_KEY, fileDTOList);
			mav.addObject(FileConstants.MAP_ID, mapIdGenerationService
					.getNextStringId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
