package org.codelabor.system.file.spring.controllers;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.file.spring.commands.FileList;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class FileUploadController extends SimpleFormController {
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return new FileList();
	}

	@Override
	protected void doSubmitAction(Object command) throws Exception {
		List<MultipartFile> uploadedFileList = ((FileList) command).getFile();
		Iterator<MultipartFile> iter = uploadedFileList.iterator();
		while (iter.hasNext()) {
			MultipartFile uploadedFile = iter.next();

			if (uploadedFile.getOriginalFilename().length() == 0)
				continue;

			StringBuffer pathName = new StringBuffer();
			pathName.append(System.getProperty("user.home"));
			pathName.append(System.getProperty("file.separator"));
			pathName.append(uploadedFile.getOriginalFilename());
			logger.debug(pathName.toString());
			File file = new File(pathName.toString());
			FileCopyUtils.copy(uploadedFile.getBytes(), file);

		}
		super.doSubmitAction(command);
	}

	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		Map<String, Object> controlModel = new HashMap<String, Object>();
		return super.showForm(request, response, errors, controlModel);
	}
}
