package org.codelabor.system.file.struts.actions;

import static org.codelabor.system.Constants.AFFECTED_ROW_COUNT_KEY;

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
import org.codelabor.system.file.Constants;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.managers.FileManager;
import org.codelabor.system.file.struts.forms.FileUploadForm;
import org.codelabor.system.file.utils.UploadUtil;
import org.codelabor.system.struts.actions.BaseDispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;

public class FileUploadAction extends BaseDispatchAction {

	public FileUploadAction() {
		super();

	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		List<FileDTO> fileDTOList = null;
		String repositoryType = request.getParameter("repositoryType");
		if (repositoryType == null) {
			fileDTOList = fileManager.selectFile();
		} else {
			switch (RepositoryType.valueOf(repositoryType)) {
			case DATABASE:
				fileDTOList = fileManager.selectFileByRepositoryType(RepositoryType.DATABASE);
				break;
			case FILE_SYSTEM:
				fileDTOList = fileManager
						.selectFileByRepositoryType(RepositoryType.FILE_SYSTEM);
				break;
			}
		}
		request.setAttribute(Constants.FILE_LIST_KEY, fileDTOList);
		return mapping.findForward("list");
	}

	public ActionForward read(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		String fileId = request.getParameter("fileId");
		FileDTO fileDTO = fileManager.selectFile(fileId);
		request.setAttribute(Constants.FILE_KEY, fileDTO);
		return mapping.findForward("read");
	}

	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
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
		FileUploadForm uploadForm = (FileUploadForm) form;
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
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
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
				"file.default.real.repository.path", System
						.getProperty("user.dir"));

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

		UploadUtil.processFile(repositoryType, inputStream, fileDTO);
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
				.getRequiredWebApplicationContext(getServlet()
						.getServletContext());
		FileManager fileManager = (FileManager) ctx.getBean("fileManager");
		int affectedRowCount = 0;
		if (form != null) {
			FileUploadForm uploadForm = (FileUploadForm) form;
			String[] fileIdList = uploadForm.getFileId();
			affectedRowCount = fileManager.deleteFile(fileIdList);
			request.setAttribute(AFFECTED_ROW_COUNT_KEY, affectedRowCount);
		}
		return mapping.findForward("delete");
	}
}
