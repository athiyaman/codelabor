package org.codelabor.system.struts.forms;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class UploadForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -163569058243568483L;
	protected String[] fileId = {};
	protected List<FormFile> formFileList = new Vector<FormFile>();

	public UploadForm() {
	}

	public String[] getFileId() {
		return fileId;
	}

	public void setFileId(String[] fileId) {
		this.fileId = fileId;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.formFileList.clear();
	}

	public void setFile(int index, FormFile formFile) {
		String fileName = null;
		if (formFile != null) {
			fileName = formFile.getFileName();
			this.formFileList.add(formFile);
		}
		if (logger.isDebugEnabled()) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("index: ").append(index);
			stringBuilder.append("fileName: ").append(fileName);
			logger.debug(stringBuilder.toString());
		}
	}

	public FormFile getFile(int index) {
		FormFile formFile = this.formFileList.get(index);
		String fileName = null;
		if (formFile != null) {
			fileName = formFile.getFileName();
		}
		if (logger.isDebugEnabled()) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("index: ").append(index);
			stringBuilder.append("fileName: ").append(fileName);
			logger.debug(stringBuilder.toString());
		}
		return formFile;
	}

	public List<FormFile> getFormFileList() {
		return formFileList;
	}
}
