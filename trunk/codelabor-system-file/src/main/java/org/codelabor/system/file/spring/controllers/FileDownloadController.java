package org.codelabor.system.file.spring.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import anyframe.common.util.StringUtil;

public class FileDownloadController extends BaseFileController {
	private final Logger logger = LoggerFactory
			.getLogger(FileDownloadController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> paramMap = RequestUtil.getParameterMap(request);
		logger.debug(paramMap.toString());

		String fileId = (String) paramMap.get("fileId");

		StringBuilder stringBuilder = null;

		FileDTO fileDTO;
		fileDTO = fileManager.selectFile(fileId);
		logger.debug("fileDTO: {}", fileDTO);

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
		// set response contenttype, header
		String encodedRealFileName = URLEncoder.encode(realFileName, "UTF-8");
		logger.debug("realFileName: {}", realFileName);
		logger.debug("encodedRealFileName: {}", encodedRealFileName);

		response
				.setContentType(org.codelabor.system.file.Constants.CONTENT_TYPE);
		stringBuilder.setLength(0);
		if (request.getHeader("User-Agent").indexOf("MSIE5.5") > -1) {
			stringBuilder.append("filename=");
		} else {
			stringBuilder.append("attachment; filename=");
		}
		stringBuilder.append("\"");
		stringBuilder.append(encodedRealFileName);
		stringBuilder.append("\"");
		response.setHeader(
				org.codelabor.system.file.Constants.RESPONSE_HEADER_NAME,
				stringBuilder.toString());

		logger.debug("header: {}", stringBuilder.toString());
		logger.debug("character encoding: {}", response.getCharacterEncoding());
		logger.debug("content type: {}", response.getContentType());
		logger.debug("bufferSize: {}", response.getBufferSize());
		logger.debug("locale: {}", response.getLocale());

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
