package org.codelabor.system.file.xecure.servlets;

import static org.codelabor.system.Constants.AFFECTED_ROW_COUNT_KEY;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.servlets.FileUploadServlet;
import org.codelabor.system.file.utils.UploadUtil;

import xecure.file.XecureFileInputStream;
import xecure.file.XecureFileOutputStream;
import xecure.servlet.XecureHttpServletRequest;
import xecure.servlet.XecureHttpServletResponse;
import xecure.servlet.XecureServlet;
import xecure.servlet.XecureServletConfigException;
import xecure.servlet.XecureServletException;
import anyframe.common.util.StringUtil;

public class XecureFileUploadServlet extends FileUploadServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 3747959585667212375L;
	private final Log log = LogFactory.getLog(XecureFileUploadServlet.class);

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String qValue = request.getParameter("q");
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("q: ").append(qValue);
				log.debug(sb.toString());
			}
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
		}
	}

	@SuppressWarnings("unchecked")
	protected void upload(HttpServletRequest request,
			HttpServletResponse response, XecureServlet xecureServlet)
			throws Exception {
		PrintWriter writer = response.getWriter();
		try {
			XecureFileInputStream xecureFileInputStream = new XecureFileInputStream(
					xecureServlet.getXecureSession(), xecureServlet.request);
			Map paramMap = xecureServlet.request.getParameterMap();
			if (log.isDebugEnabled()) {
				log.debug(paramMap);
			}

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
		} catch (XecureServletException e) {
			e.printStackTrace();
			writer.println("SFE21");
		} catch (IOException e) {
			e.printStackTrace();
			writer.println("SFE22");
		} catch (Exception e) {
			e.printStackTrace();
			writer.println("SFE23");
		} finally {
			writer.flush();
			writer.close();
		}
	}

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

			xecureFileOutputStream.writeHeader((int) fileDTO.getFileSize());

			response
					.setContentType(org.codelabor.system.file.Constants.CONTENT_TYPE);
			stringBuilder = new StringBuilder();
			stringBuilder.append("attachment; filename=").append(realFileName);
			response.setHeader(
					org.codelabor.system.file.Constants.RESPONSE_HEADER_NAME,
					stringBuilder.toString());

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
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XecureServletConfigException e) {
			e.printStackTrace();
		} catch (XecureServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param xecureFileInputStream
	 * @return
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
		if (log.isDebugEnabled()) {
			log.debug(fileDTO);
		}
		UploadUtil.processFile(repositoryType, xecureFileInputStream, fileDTO);
		return fileDTO;
	}

	@Override
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int affectedRowCount = 0;
		String[] fileIdList = request.getParameterValues("fileId");
		try {
			affectedRowCount = fileManager.deleteFile(fileIdList);
			request.setAttribute(AFFECTED_ROW_COUNT_KEY, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispatch(request, response, forwardPathDelete);
	}
}
