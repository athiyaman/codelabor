package org.codelabor.system.struts.actions;

import static org.codelabor.system.Constants.AFFECTED_ROW_COUNT_KEY;
import static org.codelabor.system.Constants.FILE_KEY;
import static org.codelabor.system.Constants.FILE_LIST_KEY;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
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
import org.codelabor.system.utils.ChannelUtil;

import anyframe.core.idgen.IIdGenerationService;


public class UploadAction extends BaseDispatchAction {

	protected String repositoryPath;

	protected FileManager fileManager;

	protected IIdGenerationService uniqueFileNameGenerationService;

	protected String defaultRepositoryType;

	public String getDefaultRepositoryType() {
		return defaultRepositoryType;
	}

	public void setDefaultRepositoryType(String defaultRepositoryType) {
		this.defaultRepositoryType = defaultRepositoryType;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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
		String fileId = request.getParameter("fileId");
		FileDTO fileDTO = this.fileManager.selectFile(Integer.parseInt(fileId));
		request.setAttribute(FILE_KEY, fileDTO);
		return mapping.findForward("read");
	}

	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get parameter
		String repositoryType = request.getParameter("repositoryType");
		if (repositoryType == null) {
			repositoryType = defaultRepositoryType;
			if (repositoryType == null) {
				repositoryType = propertiesService.getString(
						"file.default.repository.type", "FILE_SYSTEM");
			}
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
		StringBuilder stringBuilder = new StringBuilder();

		// prepare io
		InputStream inputStream = null;
		OutputStream outputStream = null;
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;

		// set file properties
		String realFileName = formFile.getFileName();
		int fileSize = formFile.getFileSize();
		String contentType = formFile.getContentType();

		// generate unique file name
		String uniqueFileName = uniqueFileNameGenerationService
				.getNextStringId();

		// debug
		if (log.isDebugEnabled()) {
			stringBuilder = new StringBuilder();
			stringBuilder.append("realFileName: ").append(realFileName);
			stringBuilder.append("uniqueFileName: ").append(uniqueFileName);
			stringBuilder.append(", contentType: ").append(contentType);
			stringBuilder.append(", fileSize: ").append(fileSize);
			log.debug(stringBuilder.toString());
		}

		// set vo
		FileDTO fileDTO = new FileDTO();
		fileDTO.setRealFileName(realFileName);
		fileDTO.setUniqueFileName(uniqueFileName);
		fileDTO.setFileSize(fileSize);
		fileDTO.setContentType(contentType);

		switch (repositoryType) {
		case FILE_SYSTEM:
			// prepare repository
			if (repositoryPath == null) {
				repositoryPath = propertiesService.getString(
						"file.default.repository.path", System
								.getProperty("user.dir"));
			}
			File repository = new File(repositoryPath);

			if (log.isDebugEnabled()) {
				stringBuilder = new StringBuilder();
				stringBuilder.append("repositoryPath: ").append(repositoryPath);
				stringBuilder.append(System.getProperty("line.separator"));
				stringBuilder.append(", repositoryType: ").append(
						repositoryType);
				stringBuilder.append(System.getProperty("line.separator"));
				stringBuilder.append(", repository.exists(): ").append(
						repository.exists());
				stringBuilder.append(System.getProperty("line.separator"));
				stringBuilder.append("repository.isDirectory(): ").append(
						repository.isDirectory());
				log.debug(stringBuilder.toString());
			}

			// prepare stream
			stringBuilder = new StringBuilder();
			stringBuilder.append(repositoryPath);
			if (!repositoryPath.endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(uniqueFileName);
			inputStream = formFile.getInputStream();
			outputStream = new FileOutputStream(stringBuilder.toString());

			// copy channel
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			ChannelUtil.copy(inputChannel, outputChannel);

			// set vo
			fileDTO.setRepositoryPath(repositoryPath);
			break;
		case DATABASE:
			// prepare steam
			inputStream = formFile.getInputStream();
			outputStream = new ByteArrayOutputStream();

			// copy channel
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			ChannelUtil.copy(inputChannel, outputChannel);

			// set vo
			fileDTO.setBytes(((ByteArrayOutputStream) outputStream)
					.toByteArray());
			break;
		}

		// close io
		inputChannel.close();
		outputChannel.close();
		inputStream.close();
		outputStream.close();

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

	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public void setUniqueFileNameGenerationService(
			IIdGenerationService uuidGenerationService) {
		this.uniqueFileNameGenerationService = uuidGenerationService;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
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
