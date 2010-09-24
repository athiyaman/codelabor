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

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.dtos.StringIdArrayDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 * 파일 삭제 Controller 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class FileDeleteController extends BaseFileCommandController {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(FileDeleteController.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.AbstractCommandController#handle(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * org.springframework.validation.BindException)
	 */
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		StringIdArrayDTO springIDArrayDTO = (StringIdArrayDTO) command;
		String[] idArray = springIDArrayDTO.getId();
		logger.debug("file id: {}", Arrays.asList(idArray));
		fileManager.deleteFile(idArray);
		return new ModelAndView(getSuccessView());
	}

}
