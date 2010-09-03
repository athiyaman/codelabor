package org.codelabor.system.file.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.file.Constants;
import org.codelabor.system.file.dtos.FileDTO;
import org.springframework.web.servlet.ModelAndView;

public class FileListController extends BaseFileController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<FileDTO> fileDTOList = fileManager.selectFile();
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject(Constants.FILE_LIST_KEY, fileDTOList);
		mav.addObject(Constants.MAP_ID, mapIdGenerationService
				.getNextStringId());
		return mav;
	}
}
