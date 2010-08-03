package org.codelabor.system.file.servlets;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.lang.StringUtils;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.utils.UploadUtils;
import org.codelabor.system.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadStreamServlet extends FileUploadServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -5122173090841307836L;
	private final Logger log = LoggerFactory
			.getLogger(FileUploadStreamServlet.class);

	@Override
	protected void upload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		if (log.isDebugEnabled()) {
			log.debug(paramMap.toString());
		}

		String mapId = (String) paramMap.get("mapId");
		RepositoryType acceptedRepositoryType = repositoryType;
		String requestedRepositoryType = (String) paramMap
				.get("repositoryType");
		if (StringUtils.isNotEmpty(requestedRepositoryType)) {
			acceptedRepositoryType = RepositoryType
					.valueOf(requestedRepositoryType);
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
					FileItemStream fileItemSteam = iter.next();
					if (log.isDebugEnabled()) {
						log.debug(fileItemSteam.toString());
					}
					FileDTO fileDTO = null;
					if (fileItemSteam.isFormField()) {
						paramMap.put(fileItemSteam.getFieldName(), Streams
								.asString(fileItemSteam.openStream(),
										characterEncoding));
					} else {
						if (fileItemSteam.getName() == null
								|| fileItemSteam.getName().length() == 0)
							continue;

						// set DTO
						fileDTO = new FileDTO();
						fileDTO.setMapId(mapId);
						fileDTO.setRealFileName(UploadUtils
								.stripPathInfo(fileItemSteam.getName()));
						fileDTO.setUniqueFileName(getUniqueFileName());
						fileDTO.setContentType(fileItemSteam.getContentType());
						fileDTO.setRepositoryPath(realRepositoryPath);
						if (log.isDebugEnabled()) {
							log.debug(fileDTO.toString());
						}
						UploadUtils.processFile(acceptedRepositoryType,
								fileItemSteam.openStream(), fileDTO);
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
			paramMap = RequestUtils.getParameterMap(request);
		}
		try {
			processParameters(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispatch(request, response, forwardPathUpload);

	}
}
