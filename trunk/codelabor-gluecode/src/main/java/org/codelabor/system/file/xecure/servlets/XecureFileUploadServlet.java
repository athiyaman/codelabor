package org.codelabor.system.file.xecure.servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.codelabor.system.file.servlets.FileUploadServlet.Parameter;
import org.codelabor.system.utils.UploadUtil;

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
		XecureServlet xecureServlet;
		try {
			xecureServlet = new XecureServlet(request, response);
			request = xecureServlet.request;
			response = xecureServlet.response;

			String parameterValue = request.getParameter(parameterName);
			switch (Parameter.valueOf(parameterValue)) {
			case upload:
				this.upload(request, response, xecureServlet);
				break;
			case download:
				this.download(request, response);
				break;
			case list:
				this.list(request, response);
				break;
			case delete:
				this.delete(request, response);
				break;
			case read:
				this.read(request, response);
				break;
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

			RepositoryType acceptedRepositoryType = repositoryType;
			String tempRepositoryType = request.getParameter("repositoryType");
			if (StringUtil.isNotEmpty(tempRepositoryType)) {
				acceptedRepositoryType = RepositoryType
						.valueOf(tempRepositoryType);
			}

			FileDTO fileDTO = processFile(acceptedRepositoryType,
					xecureFileInputStream);
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
			xecureFileOutputStream.fileDownload();
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
	private FileDTO processFile(RepositoryType repositoryType,
			XecureFileInputStream xecureFileInputStream) throws Exception {
		String fileName = xecureFileInputStream.getFileName();
		if (StringUtil.isEmpty(fileName))
			return null;
		// set DTO
		FileDTO fileDTO = new FileDTO();
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
}
