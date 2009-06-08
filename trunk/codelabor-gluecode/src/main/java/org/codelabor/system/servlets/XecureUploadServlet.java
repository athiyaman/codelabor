package org.codelabor.system.servlets;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.RepositoryType;

import xecure.file.XecureFileInputStream;
import xecure.servlet.XecureServlet;

public class XecureUploadServlet extends UploadServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3747959585667212375L;
	private final Log log = LogFactory.getLog(XecureUploadServlet.class);

	@Override
	@SuppressWarnings("unchecked")
	protected void upload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		XecureServlet xecureServlet = new XecureServlet(request, response);
		XecureFileInputStream xecureFileInputStream = new XecureFileInputStream(
				xecureServlet.getXecureSession(), xecureServlet.request);

		xecureFileInputStream.getFileName();
		xecureFileInputStream.getFileSize();

		// get mime type
		// get byte[] / inputstream

		Map paramMap = xecureServlet.request.getParameterMap();
		log.debug(paramMap);

		String _repositoryType = request.getParameter("repositoryType");
		if (_repositoryType != null && _repositoryType.length() > 0) {
			repositoryType = RepositoryType.valueOf(_repositoryType);
		}

		// FileDTO fileDTO = processFile(item);
		// if (fileDTO != null)
		// fileManager.insertFile(fileDTO);
		dispatch(request, response, forwardPathUpload);
	}

	@Override
	protected void download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO
	}
}
