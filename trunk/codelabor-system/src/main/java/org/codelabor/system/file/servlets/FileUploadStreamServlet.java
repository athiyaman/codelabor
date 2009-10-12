package org.codelabor.system.file.servlets;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.utils.UploadUtil;
import org.codelabor.system.utils.RequestUtil;

import anyframe.common.util.StringUtil;

public class FileUploadStreamServlet extends FileUploadServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5122173090841307836L;
	private final Log log = LogFactory.getLog(FileUploadStreamServlet.class);

	@Override
	protected void upload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		Map<String, Object> paramMap = RequestUtil.getParameterMap(request);

		RepositoryType acceptedRepositoryType = repositoryType;
		String tempRepositoryType = (String) paramMap.get("repositoryType");
		String mapId = (String) paramMap.get("mapId");
		if (StringUtil.isNotEmpty(tempRepositoryType)) {
			acceptedRepositoryType = RepositoryType.valueOf(tempRepositoryType);
		}

		if (isMultipart) {
			ServletFileUpload upload = new ServletFileUpload();
			upload.setFileSizeMax(fileSizeMax);
			upload.setSizeMax(requestSizeMax);
			upload.setHeaderEncoding(characterEncoding);
			upload.setProgressListener(fileUploadProgressListener);
			try {
				FileItemIterator iter = upload.getItemIterator(request);

				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					if (log.isDebugEnabled()) {
						log.debug(item);
					}
					FileDTO fileDTO = null;
					if (item.isFormField()) {
						paramMap.put(item.getFieldName(), Streams.asString(item
								.openStream(), characterEncoding));
					} else {
						fileDTO = UploadUtil.processFile(
								acceptedRepositoryType, item,
								realRepositoryPath, getUniqueFileName(), mapId);
					}
					if (fileDTO != null)
						fileManager.insertFile(fileDTO);
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			paramMap = RequestUtil.getParameterMap(request);
		}
		try {
			processParameters(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispatch(request, response, forwardPathUpload);

	}
}
