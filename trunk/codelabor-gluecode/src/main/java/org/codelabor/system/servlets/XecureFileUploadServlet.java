package org.codelabor.system.servlets;

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
import xecure.servlet.XecureServlet;

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
		XecureServlet xecureServlet = new XecureServlet(request, response);
		XecureFileInputStream xecureFileInputStream = new XecureFileInputStream(
				xecureServlet.getXecureSession(), xecureServlet.request);
		Map paramMap = xecureServlet.request.getParameterMap();

		RepositoryType acceptedRepositoryType = repositoryType;
		String _repositoryType = (String) paramMap.get("repositoryType");
		if (_repositoryType != null) {
			acceptedRepositoryType = RepositoryType.valueOf(_repositoryType);
		}

		FileDTO fileDTO = processFile(acceptedRepositoryType,
				xecureFileInputStream);
		fileManager.insertFile(fileDTO);
		processParameters(paramMap);

		dispatch(request, response, forwardPathUpload);
	}

	/**
	 * @param xecureFileInputStream
	 * @return
	 */
	private FileDTO processFile(RepositoryType acceptedRepositoryType,
			XecureFileInputStream xecureFileInputStream) throws Exception {
		if (xecureFileInputStream.getFileName() == null
				|| xecureFileInputStream.getFileName().length() == 0)
			return null;
		// set DTO
		FileDTO fileDTO = new FileDTO();
		MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
		fileDTO.setRealFileName(xecureFileInputStream.getFileName());
		fileDTO.setUniqueFileName(getUniqueFileName());
		fileDTO.setContentType(mimetypesFileTypeMap
				.getContentType(xecureFileInputStream.getFileName()));
		if (log.isDebugEnabled()) {
			log.debug(fileDTO);
		}
		UploadUtil.processFile(repositoryType, xecureFileInputStream, fileDTO);
		return fileDTO;
	}

	@Override
	protected void download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO
	}
}
