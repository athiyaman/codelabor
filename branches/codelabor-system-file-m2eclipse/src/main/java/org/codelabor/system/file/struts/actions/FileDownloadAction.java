package org.codelabor.system.file.struts.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.managers.FileManager;
import org.codelabor.system.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.common.util.StringUtil;

public class FileDownloadAction extends DownloadAction {

	private static final String contentType = "Application/octet-stream";

	private static final String responseHeaderName = "Content-Disposition";

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> paramMap = RequestUtil.getParameterMap(request);
		logger.debug(paramMap.toString());

		String fileId = (String) paramMap.get("fileId");

		StringBuilder stringBuilder = null;

		StreamInfo streamInfo = null;
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");

		FileDTO fileDTO = fileManager.selectFile(fileId);
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
			streamInfo = new FileStreamInfo(contentType, file);
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
