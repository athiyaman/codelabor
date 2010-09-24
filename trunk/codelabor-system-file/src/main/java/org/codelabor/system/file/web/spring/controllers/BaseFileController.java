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

import org.codelabor.system.file.managers.FileManager;
import org.springframework.web.servlet.mvc.AbstractController;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

/**
 * 기본 파일 Controller 추상 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public abstract class BaseFileController extends AbstractController {

	/**
	 * 파일 매니저
	 */
	protected FileManager fileManager;
	/**
	 * 프러퍼티 서비스
	 */
	protected IPropertiesService propertiesService;
	/**
	 * 고유 파일명 제네레이션 서비스
	 */
	protected IIdGenerationService uniqueFileNameGenerationService;
	/**
	 * 성공 뷰
	 */
	protected String successView;
	/**
	 * Map Id 제네레이션 서비스
	 */
	protected IIdGenerationService mapIdGenerationService;

	/**
	 * 파일 매니저를 설정한다.
	 * 
	 * @param fileManager
	 *            파일 매니저
	 */
	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	/**
	 * 프로퍼티 서비스를 설정한다.
	 * 
	 * @param propertiesService
	 *            프로퍼티 서비스
	 */
	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

	/**
	 * 고유 파일명 제네레이션 서비스를 설정한다.
	 * 
	 * @param uniqueFileNameGenerationService
	 *            고유 파일명 제네레이션 서비스
	 */
	public void setUniqueFileNameGenerationService(
			IIdGenerationService uniqueFileNameGenerationService) {
		this.uniqueFileNameGenerationService = uniqueFileNameGenerationService;
	}

	/**
	 * 성공 뷰를 가져온다.
	 * 
	 * @return 성공 뷰
	 */
	public String getSuccessView() {
		return successView;
	}

	/**
	 * 성공 뷰를 설정한다.
	 * 
	 * @param successView
	 *            성공 뷰
	 */
	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	/**
	 * Map Id 제네레이션 서비스를 설정한다.
	 * 
	 * @param mapIdGenerationService
	 *            Map Id 제네레이션 서비스
	 */
	public void setMapIdGenerationService(
			IIdGenerationService mapIdGenerationService) {
		this.mapIdGenerationService = mapIdGenerationService;
	}

}
