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

package org.codelabor.system.file.web.struts.form;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.codelabor.system.web.struts.form.BaseForm;

/**
 * 파일 업로드 Form
 *
 * @author Shin Sang-jae
 *
 */
public class FileUploadForm extends BaseForm {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -163569058243568483L;
	/**
	 * 파일 Id 배열
	 */
	protected String[] fileId = {};
	/**
	 * Form File List
	 */
	protected List<FormFile> formFileList = new Vector<FormFile>();
	/**
	 * Map Id
	 */
	protected String mapId;

	/**
	 * 생성자
	 */
	public FileUploadForm() {
	}

	/**
	 * 파일 Id를 가져온다.
	 *
	 * @return 파일 Id 배열
	 */
	public String[] getFileId() {
		return fileId;
	}

	/**
	 * 파일 배열을 설정한다.
	 *
	 * @param fileId
	 *            파일 Id 배열
	 */
	public void setFileId(String[] fileId) {
		this.fileId = fileId;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @seeorg.apache.struts.action.ActionForm#reset(org.apache.struts.action.
	 * ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.formFileList.clear();
	}

	/**
	 * Form File을 설정한다.
	 *
	 * @param index
	 *            인덱스
	 * @param formFile
	 *            Form File
	 */
	public void setFile(int index, FormFile formFile) {
		String filename = null;
		if (formFile != null) {
			filename = formFile.getFilename();
			this.formFileList.add(formFile);
		}
		logger.debug("index: {}, filename: {}", index, filename);
	}

	/**
	 * Form File을 가져온다.
	 *
	 * @param index
	 *            인덱스
	 * @return Form File
	 */
	public FormFile getFile(int index) {
		FormFile formFile = this.formFileList.get(index);
		String filename = null;
		if (formFile != null) {
			filename = formFile.getFilename();
		}
		logger.debug("index: {}, filename: {}", index, filename);
		return formFile;
	}

	/**
	 * Form File List를 가져온다.
	 *
	 * @return Form File List
	 */
	public List<FormFile> getFormFileList() {
		return formFileList;
	}

	/**
	 * Map Id를 가져온다.
	 *
	 * @return Map Id
	 */
	public String getMapId() {
		return mapId;
	}

	/**
	 * Map Id를 설정한다.
	 *
	 * @param mapId
	 *            Map Id
	 */
	public void setMapId(String mapId) {
		this.mapId = mapId;
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

		retValue.append("FileUploadForm ( ").append(super.toString()).append(
				TAB).append("fileId = ").append(this.fileId).append(TAB)
				.append("formFileList = ").append(this.formFileList)
				.append(TAB).append("mapId = ").append(this.mapId).append(TAB)
				.append(" )");

		return retValue.toString();
	}
}
