package org.codelabor.system.daos;

import java.util.List;

import org.codelabor.system.RepositoryType;
import org.codelabor.system.dtos.FileDTO;

public interface FileDAO {

	public int deleteFile(int fileId) throws Exception;

	public int deleteFile(int[] fileIdList) throws Exception;

	public int insertFile(FileDTO fileDTO) throws Exception;

	public int insertFile(List<FileDTO> fileDTOList) throws Exception;

	public List<FileDTO> selectFile(RepositoryType repositoryType)
			throws Exception;

	public List<FileDTO> selectFile() throws Exception;

	public FileDTO selectFile(int fileId) throws Exception;

}
