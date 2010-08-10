package org.codelabor.system.file.struts.forms;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.codelabor.system.struts.forms.BaseForm;

public class FileUploadForm extends BaseForm {

	/**
	 *
	 */
	private static final long serialVersionUID = -163569058243568483L;
	protected String[] fileId = {};
	protected List<FormFile> formFileList = new Vector<FormFile>();
	private String mapId;

	public FileUploadForm() {
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
		logger.debug("index: {}, fileName: {}", index, fileName);
	}

	public FormFile getFile(int index) {
		FormFile formFile = this.formFileList.get(index);
		String fileName = null;
		if (formFile != null) {
			fileName = formFile.getFileName();
		}
		logger.debug("index: {}, fileName: {}", index, fileName);
		return formFile;
	}

	public List<FormFile> getFormFileList() {
		return formFileList;
	}

	public String getMapId() {
		return mapId;
	}

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
