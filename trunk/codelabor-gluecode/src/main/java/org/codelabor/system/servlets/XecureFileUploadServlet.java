package org.codelabor.system.servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.RepositoryType;
import org.codelabor.system.dtos.FileDTO;
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
	@SuppressWarnings("unchecked")
	protected void upload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter writer = response.getWriter();
		try {
			XecureServlet xecureServlet = new XecureServlet(
					((XecureHttpServletRequest) request).req,
					((XecureHttpServletResponse) response).res);
			XecureFileInputStream xecureFileInputStream = new XecureFileInputStream(
					xecureServlet.getXecureSession(), xecureServlet.request);
			Map paramMap = xecureServlet.request.getParameterMap();
			log.debug(paramMap);

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
			writer.write("OK");
			writer.flush();
		} catch (XecureServletConfigException e) {
			e.printStackTrace();
			writer.write("SFE20");
		} catch (XecureServletException e) {
			e.printStackTrace();
			writer.write("SFE21");
		} catch (IOException e) {
			e.printStackTrace();
			writer.write("SFE22");
		} catch (Exception e) {
			e.printStackTrace();
			writer.write("SFE23");
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
