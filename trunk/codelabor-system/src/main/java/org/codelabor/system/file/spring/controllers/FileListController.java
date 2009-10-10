package org.codelabor.system.file.spring.controllers;

import static org.codelabor.system.Constants.FILE_LIST_KEY;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.file.dtos.FileDTO;
import org.springframework.web.servlet.ModelAndView;

public class FileListController extends BaseFileController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<FileDTO> fileDTOList = fileManager.selectFile();
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject(FILE_LIST_KEY, fileDTOList);
		return mav;
	}
}
