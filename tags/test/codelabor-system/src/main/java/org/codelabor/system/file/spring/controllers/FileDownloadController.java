package org.codelabor.system.file.spring.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.file.dtos.FileDTO;
import org.springframework.web.servlet.ModelAndView;

import anyframe.common.util.StringUtil;

public class FileDownloadController extends BaseFileController {
	private final Log log = LogFactory.getLog(FileDownloadController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StringBuilder stringBuilder = null;
		String fileId = request.getParameter("fileId");

		FileDTO fileDTO;
		fileDTO = fileManager.selectFile(fileId);
		if (log.isDebugEnabled()) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(fileDTO);
			log.debug(stringBuilder.toString());
		}

		String repositoryPath = fileDTO.getRepositoryPath();
		String uniqueFileName = fileDTO.getUniqueFileName();
		String realFileName = fileDTO.getRealFileName();
		InputStream inputStream = null;
		if (StringUtil.isNotEmpty(repositoryPath)) {
			// FILE_SYSTEM
			stringBuilder = new StringBuilder();
			stringBuilder.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(uniqueFileName);
			File file = new File(stringBuilder.toString());
			inputStream = new FileInputStream(file);
		} else {
			// DATABASE
			byte[] bytes = new byte[] {};
			if (fileDTO.getFileSize() > 0) {
				bytes = fileDTO.getBytes();
			}
			inputStream = new ByteArrayInputStream(bytes);

		}
		response
				.setContentType(org.codelabor.system.file.Constants.CONTENT_TYPE);
		stringBuilder = new StringBuilder();
		stringBuilder.append("attachment; filename=").append(realFileName);
		response.setHeader(
				org.codelabor.system.file.Constants.RESPONSE_HEADER_NAME,
				stringBuilder.toString());

		BufferedInputStream bufferdInputStream = new BufferedInputStream(
				inputStream);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				servletOutputStream);
		int bytesRead;
		byte buffer[] = new byte[2048];
		while ((bytesRead = bufferdInputStream.read(buffer)) != -1) {
			bufferedOutputStream.write(buffer, 0, bytesRead);
		}
		// flush stream
		bufferedOutputStream.flush();

		// close stream
		inputStream.close();
		bufferdInputStream.close();
		servletOutputStream.close();
		bufferedOutputStream.close();
		return null;
	}
}
