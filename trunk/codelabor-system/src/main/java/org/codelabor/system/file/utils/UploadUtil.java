package org.codelabor.system.file.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.utils.ChannelUtil;
import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
	static private final Log log = LogFactory.getLog(UploadUtil.class);

	static public void processFile(RepositoryType repositoryType,
			InputStream inputStream, List<FileDTO> fileDTOList)
			throws Exception {
		for (int i = 0; i < fileDTOList.size(); i++) {
			FileDTO tempFileDTO = fileDTOList.get(i);
			processFile(repositoryType, inputStream, tempFileDTO);
			fileDTOList.add(i, tempFileDTO);
		}
	}

	static public void processFile(RepositoryType repositoryType,
			InputStream inputStream, FileDTO fileDTO) throws Exception {
		// prepare io
		OutputStream outputStream = null;
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;

		int fileSize = 0;
		StringBuilder stringBuilder = new StringBuilder();
		switch (repositoryType) {
		case FILE_SYSTEM:
			// prepare repository
			File repository = new File(fileDTO.getRepositoryPath());

			if (log.isDebugEnabled()) {
				stringBuilder = new StringBuilder();
				stringBuilder.append("repositoryPath: ").append(
						fileDTO.getRepositoryPath());
				stringBuilder.append(", repositoryType: ").append(
						repositoryType);
				stringBuilder.append(", repository.exists(): ").append(
						repository.exists());
				stringBuilder.append(", repository.isDirectory(): ").append(
						repository.isDirectory());
				log.debug(stringBuilder.toString());
			}

			// prepare stream
			stringBuilder = new StringBuilder();
			stringBuilder.append(fileDTO.getRepositoryPath());
			if (!fileDTO.getRepositoryPath().endsWith(File.separator)) {
				stringBuilder.append(File.separator);
			}
			stringBuilder.append(fileDTO.getUniqueFileName());
			outputStream = new FileOutputStream(stringBuilder.toString());

			// copy channel
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			fileSize = ChannelUtil.copy(inputChannel, outputChannel);
			break;
		case DATABASE:
			// prepare steam
			outputStream = new ByteArrayOutputStream();

			// copy channel
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			fileSize = ChannelUtil.copy(inputChannel, outputChannel);

			// set vo
			fileDTO.setBytes(((ByteArrayOutputStream) outputStream)
					.toByteArray());
			fileDTO.setRepositoryPath(null);
			break;
		}
		fileDTO.setFileSize(fileSize);

		// close io
		inputChannel.close();
		outputChannel.close();
		inputStream.close();
		outputStream.close();
	}

	static public FileDTO processFile(RepositoryType repositoryType,
			FileItem fileItem, String realRepositoryPath,
			String uniqueFileName, String mapId) throws Exception {
		if (fileItem.getName() == null || fileItem.getName().length() == 0)
			return null;

		// set DTO
		FileDTO fileDTO = new FileDTO();
		fileDTO.setMapId(mapId);
		fileDTO.setRealFileName(stripPathInfo(fileItem.getName()));
		fileDTO.setUniqueFileName(uniqueFileName);
		fileDTO.setContentType(fileItem.getContentType());
		fileDTO.setRepositoryPath(realRepositoryPath);
		if (log.isDebugEnabled()) {
			log.debug(fileDTO);
		}
		processFile(repositoryType, fileItem.getInputStream(), fileDTO);
		return fileDTO;
	}

	static public FileDTO processFile(RepositoryType repositoryType,
			FileItemStream fileItemStream, String realRepositoryPath,
			String uniqueFileName, String mapId) throws Exception {
		if (fileItemStream.getName() == null
				|| fileItemStream.getName().length() == 0)
			return null;

		// set DTO
		FileDTO fileDTO = new FileDTO();
		fileDTO.setMapId(mapId);
		fileDTO.setRealFileName(stripPathInfo(fileItemStream.getName()));
		fileDTO.setUniqueFileName(uniqueFileName);
		fileDTO.setContentType(fileItemStream.getContentType());
		fileDTO.setRepositoryPath(realRepositoryPath);
		if (log.isDebugEnabled()) {
			log.debug(fileDTO);
		}
		processFile(repositoryType, fileItemStream.openStream(), fileDTO);
		return fileDTO;
	}

	public static FileDTO processFile(RepositoryType repositoryType,
			MultipartFile uploadedFile, String repositoryPath,
			String uniqueFileName, String mapId) throws Exception {
		String originalFilename = uploadedFile.getOriginalFilename();
		if (originalFilename == null || originalFilename.length() == 0)
			return null;

		// set DTO
		FileDTO fileDTO = new FileDTO();
		fileDTO.setMapId(mapId);
		fileDTO.setRealFileName(stripPathInfo(originalFilename));
		fileDTO.setUniqueFileName(uniqueFileName);
		fileDTO.setContentType(uploadedFile.getContentType());
		fileDTO.setRepositoryPath(repositoryPath);
		if (log.isDebugEnabled()) {
			log.debug(fileDTO);
		}
		processFile(repositoryType, uploadedFile.getInputStream(), fileDTO);
		return fileDTO;
	}

	static public String stripPathInfo(String realFileNameWithPath) {
		int lastIndex = realFileNameWithPath.lastIndexOf(System
				.getProperty("file.separator"));
		int beginIndex = (lastIndex > 0) ? lastIndex + 1 : 0;
		String realFileName = realFileNameWithPath.substring(beginIndex);

		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("realFileNameWithPath: ").append(realFileNameWithPath);
			sb.append(", realFileName: ").append(realFileName);
			log.debug(sb.toString());
		}
		return realFileName;
	}

}
