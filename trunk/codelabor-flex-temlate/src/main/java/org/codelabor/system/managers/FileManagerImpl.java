package org.codelabor.system.managers;

import java.util.List;

import org.codelabor.system.RepositoryType;
import org.codelabor.system.daos.FileDAO;
import org.codelabor.system.dtos.FileDTO;

public class FileManagerImpl extends BaseManagerImpl implements FileManager {

	private FileDAO fileDAO;

	public int deleteFile(int fileId) throws Exception {
		return fileDAO.deleteFile(fileId);
	}

	public int deleteFile(int[] fileIdList) throws Exception {
		return fileDAO.deleteFile(fileIdList);
	}

	public int insertFile(FileDTO fileDTO) throws Exception {
		return fileDAO.insertFile(fileDTO);
	}

	public int insertFile(List<FileDTO> fileDTOList) throws Exception {
		return fileDAO.insertFile(fileDTOList);
	}

	public List<FileDTO> selectFile(RepositoryType repositoryType)
			throws Exception {
		return fileDAO.selectFile(repositoryType);
	}

	public List<FileDTO> selectFile() throws Exception {
		return fileDAO.selectFile();
	}

	public FileDTO selectFile(int fileId) throws Exception {
		return fileDAO.selectFile(fileId);
	}

	public FileDAO getFileDAO() {
		return fileDAO;
	}

	public void setFileDAO(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}

}
