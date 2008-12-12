package org.codelabor.system.struts.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.MessageSource;

import anyframe.core.properties.IPropertiesService;
import org.codelabor.system.dtos.FileDTO;
import org.codelabor.system.exceptions.ParameterNotFoundException;
import org.codelabor.system.managers.FileManager;

public class DownloadAction extends org.apache.struts.actions.DownloadAction {

	protected Log log = LogFactory.getLog(this.getClass());

	protected FileManager fileManager;

	protected MessageSource messageSource;

	protected IPropertiesService propertiesService;

	private static final String contentType = "Application/octet-stream";

	private static final String responseHeaderName = "Content-Disposition";

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StringBuilder stringBuilder = null;
		int fileId = 0;
		String _fileId = request.getParameter("fileId");
		if (_fileId != null) {
			fileId = Integer.parseInt(_fileId);
		} else {
			throw new ParameterNotFoundException();
		}

		StreamInfo streamInfo = null;

		FileDTO fileDTO = fileManager.selectFile(fileId);
		if (log.isDebugEnabled()) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(fileDTO);
			log.debug(stringBuilder.toString());
		}

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFileName = fileDTO.getUniqueFileName();
		String realFileName = fileDTO.getRealFileName();

		// FILE_SYSTEM
		if (repositoryPath != null && repositoryPath.length() > 0) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(uniqueFileName);
			File file = new File(stringBuilder.toString());
			streamInfo = new DownloadAction.FileStreamInfo(contentType, file);
			// DATABASE
		} else {
			byte[] bytes = fileDTO.getBytes();
			streamInfo = new ByteArrayStreamInfo(contentType, bytes);
		}
		stringBuilder = new StringBuilder();
		stringBuilder.append("attachment; filename=").append(realFileName);
		response.setHeader(responseHeaderName, stringBuilder.toString());
		return streamInfo;
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public IPropertiesService getPropertiesService() {
		return propertiesService;
	}

	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

	public class ByteArrayStreamInfo implements StreamInfo {
		protected String contentType;

		protected byte[] bytes;

		public ByteArrayStreamInfo(String contentType, byte[] bytes) {
			this.contentType = contentType;
			this.bytes = bytes;
		}

		public String getContentType() {
			return contentType;
		}

		public InputStream getInputStream() throws IOException {
			return new ByteArrayInputStream(bytes);
		}

	}
}
