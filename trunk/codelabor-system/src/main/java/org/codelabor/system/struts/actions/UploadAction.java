package org.codelabor.system.struts.actions;

import static org.codelabor.system.Constants.AFFECTED_ROW_COUNT_KEY;
import static org.codelabor.system.Constants.FILE_KEY;
import static org.codelabor.system.Constants.FILE_LIST_KEY;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.codelabor.system.RepositoryType;
import org.codelabor.system.dtos.FileDTO;
import org.codelabor.system.managers.FileManager;
import org.codelabor.system.struts.forms.UploadForm;
import org.codelabor.system.utils.UploadUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

public class UploadAction extends BaseDispatchAction {

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		List<FileDTO> fileDTOList = null;
		String repositoryType = request.getParameter("repositoryType");
		if (repositoryType == null) {
			fileDTOList = fileManager.selectFile();
		} else {
			switch (RepositoryType.valueOf(repositoryType)) {
			case DATABASE:
				fileDTOList = fileManager.selectFile(RepositoryType.DATABASE);
				break;
			case FILE_SYSTEM:
				fileDTOList = fileManager
						.selectFile(RepositoryType.FILE_SYSTEM);
				break;
			}
		}
		request.setAttribute(FILE_LIST_KEY, fileDTOList);
		return mapping.findForward("list");
	}

	public ActionForward read(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		String fileId = request.getParameter("fileId");
		FileDTO fileDTO = fileManager.selectFile(Integer.parseInt(fileId));
		request.setAttribute(FILE_KEY, fileDTO);
		return mapping.findForward("read");
	}

	public UploadAction() {
		super();

	}

	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		IPropertiesService propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");

		// get parameter
		String repositoryType = request.getParameter("repositoryType");
		if (repositoryType == null) {
			repositoryType = propertiesService.getString(
					"file.default.real.repository.type", "FILE_SYSTEM");
		}
		RepositoryType.valueOf(repositoryType);

		if (log.isDebugEnabled()) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("repositoryType: ");
			stringBuilder.append(repositoryType);
			log.debug(stringBuilder.toString());
		}

		// get form
		UploadForm uploadForm = (UploadForm) form;
		List<FormFile> formFileList = uploadForm.getFormFileList();

		// upload
		List<FileDTO> fileDTOList = this.saveFile(RepositoryType
				.valueOf(repositoryType), formFileList);

		// invoke manager

		int affectedRowCount = fileManager.insertFile(fileDTOList);
		request.setAttribute(AFFECTED_ROW_COUNT_KEY, affectedRowCount);

		// forward
		return mapping.findForward("upload");
	}

	protected FileDTO saveFile(RepositoryType repositoryType, FormFile formFile)
			throws Exception {
		// get service
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		IPropertiesService propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");
		IIdGenerationService uniqueFileNameGenerationService = (IIdGenerationService) ctx
				.getBean("uniqueFileNameGenerationService");

		// set file properties
		String realFileName = formFile.getFileName();
		int fileSize = formFile.getFileSize();
		String contentType = formFile.getContentType();
		InputStream inputStream = formFile.getInputStream();
		String uniqueFileName = uniqueFileNameGenerationService
				.getNextStringId();

		// set configuration
		String repositoryPath = propertiesService.getString(
				"file.default.real.repository.path", System.getProperty("user.dir"));

		// set dto
		FileDTO fileDTO = new FileDTO();
		fileDTO.setRealFileName(realFileName);
		fileDTO.setUniqueFileName(uniqueFileName);
		fileDTO.setFileSize(fileSize);
		fileDTO.setContentType(contentType);
		fileDTO.setRepositoryPath(repositoryPath);
		if (log.isDebugEnabled()) {
			log.debug(fileDTO);
		}

		UploadUtil.processUploadFile(repositoryType, inputStream, fileDTO);
		return fileDTO;
	}

	protected List<FileDTO> saveFile(RepositoryType repositoryType,
			List<FormFile> formFileList) throws Exception {
		List<FileDTO> fileDTOList = new ArrayList<FileDTO>();
		Iterator<FormFile> iter = formFileList.iterator();
		while (iter.hasNext()) {
			FormFile formFile = iter.next();
			String realFileName = formFile.getFileName();
			if (realFileName == null || realFileName.length() == 0) {
				continue;
			}
			FileDTO fileDTO = saveFile(repositoryType, formFile);
			fileDTOList.add(fileDTO);
		}
		return fileDTOList;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		int affectedRowCount = 0;
		if (form != null) {
			UploadForm uploadForm = (UploadForm) form;
			int[] fileIdList = uploadForm.getFileId();
			affectedRowCount = fileManager.deleteFile(fileIdList);
			request.setAttribute(AFFECTED_ROW_COUNT_KEY, affectedRowCount);
		}
		return mapping.findForward("delete");
	}

}
