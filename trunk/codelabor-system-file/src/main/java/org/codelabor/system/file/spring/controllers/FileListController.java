package org.codelabor.system.file.spring.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.codelabor.system.file.Constants;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.utils.RequestUtils;
import org.springframework.web.servlet.ModelAndView;

public class FileListController extends BaseFileController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug(paramMap);

		String mapId = (String) paramMap.get("mapId");
		String repositoryType = (String) paramMap.get("repositoryType");

		List<FileDTO> fileDTOList = null;
		ModelAndView mav = null;
		try {
			if (StringUtils.isEmpty(repositoryType)) {
				if (StringUtils.isEmpty(mapId)) {
					fileDTOList = fileManager.selectFile();
				} else {
					fileDTOList = fileManager.selectFileByMapId(mapId);
				}
			} else {
				switch (RepositoryType.valueOf(repositoryType)) {
				case DATABASE:
					fileDTOList = fileManager
							.selectFileByRepositoryType(RepositoryType.DATABASE);
					break;
				case FILE_SYSTEM:
					fileDTOList = fileManager
							.selectFileByRepositoryType(RepositoryType.FILE_SYSTEM);
					break;
				}
			}
			mav = new ModelAndView(getSuccessView());
			mav.addObject(Constants.FILE_LIST_KEY, fileDTOList);
			mav.addObject(Constants.MAP_ID, mapIdGenerationService
					.getNextStringId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
