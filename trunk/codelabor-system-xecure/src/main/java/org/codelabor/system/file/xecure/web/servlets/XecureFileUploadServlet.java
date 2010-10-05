package org.codelabor.system.file.xecure.web.servlets;

import static org.codelabor.system.daos.DAOConstants.AFFECTED_ROW_COUNT;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.utils.UploadUtils;
import org.codelabor.system.file.web.servlets.FileUploadServlet;
import org.codelabor.system.web.servlets.HttpRequestHeader;
import org.codelabor.system.web.servlets.HttpResponseHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xecure.file.XecureFileInputStream;
import xecure.file.XecureFileOutputStream;
import xecure.servlet.XecureHttpServletRequest;
import xecure.servlet.XecureHttpServletResponse;
import xecure.servlet.XecureServlet;
import xecure.servlet.XecureServletConfigException;
import xecure.servlet.XecureServletException;
import anyframe.common.util.StringUtil;

/**
 * Xecure 파일 업로드 서블릿
 * 
 * @author Shin Sangjae
 * 
 */
public class XecureFileUploadServlet extends FileUploadServlet {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = 3747959585667212375L;
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory
			.getLogger(XecureFileUploadServlet.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.web.servlets.FileUploadServlet#service(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String qValue = request.getParameter("q");
			logger.debug("q: {}", qValue);

			if (StringUtil.isEmpty(qValue)) {
				String parameterValue = request.getParameter(parameterName);
				switch (Parameter.valueOf(parameterValue)) {
				case list:
					list(request, response);
					break;
				case delete:
					delete(request, response);
					break;
				case read:
					read(request, response);
					break;
				}
			} else {
				XecureServlet xecureServlet = new XecureServlet(request,
						response);
				request = xecureServlet.request;
				response = xecureServlet.response;
				String parameterValue = request.getParameter(parameterName);
				switch (Parameter.valueOf(parameterValue)) {
				case upload:
					upload(request, response, xecureServlet);
					break;
				case download:
					download(request, response);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.web.servlets.FileUploadServlet#download(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			XecureServlet xservlet = new XecureServlet(
					((XecureHttpServletRequest) request).req,
					((XecureHttpServletResponse) response).res);
			XecureFileOutputStream xecureFileOutputStream = new XecureFileOutputStream(
					xservlet.getXecureSession(), xservlet.request,
					xservlet.response, response.getOutputStream());

			String fileId = request.getParameter("fileId");

			StringBuilder sb = new StringBuilder();

			FileDTO fileDTO;
			fileDTO = fileManager.selectFileByFileId(fileId);
			logger.debug("fileDTO: {}", fileDTO);

			String repositoryPath = fileDTO.getRepositoryPath();
			String uniqueFileName = fileDTO.getUniqueFileName();
			String realFileName = fileDTO.getRealFileName();
			InputStream inputStream = null;
			if (StringUtil.isNotEmpty(repositoryPath)) {
				// FILE_SYSTEM
				sb.setLength(0);
				sb.append(repositoryPath);
				if (!repositoryPath.endsWith(File.separator)) {
					sb.append(File.separator);
				}
				sb.append(uniqueFileName);
				File file = new File(sb.toString());
				inputStream = new FileInputStream(file);
			} else {
				// DATABASE
				byte[] bytes = new byte[] {};
				if (fileDTO.getFileSize() > 0) {
					bytes = fileDTO.getBytes();
				}
				inputStream = new ByteArrayInputStream(bytes);

			}

			xecureFileOutputStream.writeHeader((int) fileDTO.getFileSize());

			// set response contenttype, header
			String encodedRealFileName = URLEncoder.encode(realFileName,
					"UTF-8");
			logger.debug("realFileName: {}", realFileName);
			logger.debug("encodedRealFileName: {}", encodedRealFileName);

			response
					.setContentType(org.codelabor.system.file.FileConstants.CONTENT_TYPE);
			sb.setLength(0);
			if (request.getHeader(HttpRequestHeader.USER_AGENT).indexOf(
					"MSIE5.5") > -1) {
				sb.append("filename=");
			} else {
				sb.append("attachment; filename=");
			}
			sb.append(encodedRealFileName);
			response.setHeader(HttpResponseHeader.CONTENT_DISPOSITION, sb
					.toString());

			logger.debug("header: {}", sb.toString());
			logger.debug("character encoding: {}", response
					.getCharacterEncoding());
			logger.debug("content type: {}", response.getContentType());
			logger.debug("bufferSize: {}", response.getBufferSize());
			logger.debug("locale: {}", response.getLocale());

			BufferedInputStream bufferdInputStream = new BufferedInputStream(
					inputStream);

			int bytesRead;
			byte buffer[] = new byte[2048];
			while ((bytesRead = bufferdInputStream.read(buffer)) != -1) {
				xecureFileOutputStream.write(buffer, 0, bytesRead);
			}
			// flush
			xecureFileOutputStream.flush();

			// close stream
			inputStream.close();
			bufferdInputStream.close();
			xecureFileOutputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (XecureServletConfigException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (XecureServletException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.file.web.servlets.FileUploadServlet#delete(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int affectedRowCount = 0;
		String[] fileIdList = request.getParameterValues("fileId");
		try {
			affectedRowCount = fileManager.deleteFile(fileIdList);
			request.setAttribute(AFFECTED_ROW_COUNT, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		dispatch(request, response, forwardPathDelete);
	}

	/**
	 * 파일을 업로드한다.
	 * 
	 * @param request
	 *            요청
	 * @param response
	 *            응답
	 * @param xecureServlet
	 *            Xecure 서블릿
	 * @throws Exception
	 *             예외
	 */
	@SuppressWarnings("unchecked")
	protected void upload(HttpServletRequest request,
			HttpServletResponse response, XecureServlet xecureServlet)
			throws Exception {
		PrintWriter writer = response.getWriter();
		try {
			XecureFileInputStream xecureFileInputStream = new XecureFileInputStream(
					xecureServlet.getXecureSession(), xecureServlet.request);
			Map paramMap = xecureServlet.request.getParameterMap();
			logger.debug("paramMap: {}", paramMap.toString());

			String mapId = ((String[]) paramMap.get("mapId"))[0];
			RepositoryType acceptedRepositoryType = repositoryType;
			String requestedRepositoryType = ((String[]) paramMap
					.get("repositoryType"))[0];

			if (StringUtil.isNotEmpty(requestedRepositoryType)) {
				acceptedRepositoryType = RepositoryType
						.valueOf(requestedRepositoryType);
			}

			FileDTO fileDTO = processFile(acceptedRepositoryType,
					xecureFileInputStream, mapId);
			fileManager.insertFile(fileDTO);
			processParameters(paramMap);
			writer.println("OK");
			writer.flush();
		} catch (XecureServletConfigException e) {
			e.printStackTrace();
			writer.println("SFE20");
			logger.error("error code: SFE20");
		} catch (XecureServletException e) {
			e.printStackTrace();
			writer.println("SFE21");
			logger.error("error code: SFE21");
		} catch (IOException e) {
			e.printStackTrace();
			writer.println("SFE22");
			logger.error("error code: SFE22");
		} catch (Exception e) {
			e.printStackTrace();
			writer.println("SFE23");
			logger.error("error code: SFE23");
		} finally {
			writer.flush();
			writer.close();
		}
	}

	/**
	 * 파일을 처리한다.
	 * 
	 * @param xecureFileInputStream
	 *            Xecure 파일 입력 스트림
	 * @return 파일 DTO
	 */
	protected FileDTO processFile(RepositoryType repositoryType,
			XecureFileInputStream xecureFileInputStream, String mapId)
			throws Exception {
		String fileName = xecureFileInputStream.getFileName();
		if (StringUtil.isEmpty(fileName))
			return null;
		// set DTO
		FileDTO fileDTO = new FileDTO();
		fileDTO.setMapId(mapId);
		MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
		fileDTO.setRealFileName(fileName);
		fileDTO.setUniqueFileName(getUniqueFileName());
		fileDTO.setContentType(mimetypesFileTypeMap.getContentType(fileName));
		fileDTO.setRepositoryPath(realRepositoryPath);

		logger.debug("fileDTO:{}", fileDTO.toString());

		UploadUtils.processFile(repositoryType, xecureFileInputStream, fileDTO);
		return fileDTO;
	}

}
