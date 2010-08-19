package org.codelabor.system.file.struts.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.managers.FileManager;
import org.codelabor.system.servlets.HttpRequestHeader;
import org.codelabor.system.servlets.HttpResponseHeader;
import org.codelabor.system.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.common.util.StringUtil;

public class FileDownloadAction extends DownloadAction {

	private final Logger logger = LoggerFactory
			.getLogger(FileDownloadAction.class);

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug(paramMap.toString());

		String fileId = (String) paramMap.get("fileId");

		StringBuilder stringBuilder = null;

		StreamInfo streamInfo = null;
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");

		FileDTO fileDTO = fileManager.selectFileByFileId(fileId);
		logger.debug("fileDTO: {}", fileDTO);

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFileName = fileDTO.getUniqueFileName();
		String realFileName = fileDTO.getRealFileName();

		// FILE_SYSTEM
		if (StringUtil.isNotEmpty(repositoryPath)) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(uniqueFileName);
			File file = new File(stringBuilder.toString());
			streamInfo = new FileStreamInfo(
					org.codelabor.system.file.Constants.CONTENT_TYPE, file);
			// DATABASE
		} else {
			byte[] bytes = fileDTO.getBytes();
			streamInfo = new ByteArrayStreamInfo(
					org.codelabor.system.file.Constants.CONTENT_TYPE, bytes);
		}
		// set response contenttype, header
		String encodedRealFileName = URLEncoder.encode(realFileName, "UTF-8");
		logger.debug("realFileName: {}", realFileName);
		logger.debug("encodedRealFileName: {}", encodedRealFileName);

		response
				.setContentType(org.codelabor.system.file.Constants.CONTENT_TYPE);
		stringBuilder.setLength(0);
		if (request.getHeader(HttpRequestHeader.USER_AGENT).indexOf("MSIE5.5") > -1) {
			stringBuilder.append("filename=");
		} else {
			stringBuilder.append("attachment; filename=");
		}
		// stringBuilder.append("\"");
		stringBuilder.append(encodedRealFileName);
		// stringBuilder.append("\"");
		response.setHeader(HttpResponseHeader.CONTENT_DISPOSITION,
				stringBuilder.toString());

		logger.debug("header: {}", stringBuilder.toString());
		logger.debug("character encoding: {}", response.getCharacterEncoding());
		logger.debug("content type: {}", response.getContentType());
		logger.debug("bufferSize: {}", response.getBufferSize());
		logger.debug("locale: {}", response.getLocale());
		return streamInfo;
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
