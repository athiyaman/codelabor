package org.codelabor.system.daos;

import java.util.Collection;
import java.util.List;

import org.codelabor.system.RepositoryType;
import org.codelabor.system.dtos.FileDTO;

public class FileDAOImpl extends BaseDAOImpl implements FileDAO {

	public int insertFile(FileDTO fileDTO) throws Exception {
		int fileId = idGenerationService.getNextIntegerId();
		if (log.isDebugEnabled()) {
			log.debug("fileId: " + fileId);
		}
		fileDTO.setFileId(fileId);
		return queryService.create(fileDTO);
	}

	public int insertFile(List<FileDTO> insertFileDTOList) throws Exception {
		int fileDTOCount = insertFileDTOList.size();
		int affectedRowCount = 0;
		if (insertFileDTOList != null && insertFileDTOList.size() > 0) {
			for (int i = 0; i < fileDTOCount; i++) {
				affectedRowCount += this.insertFile(insertFileDTOList.get(i));
			}
		}
		return affectedRowCount;
	}

	public int deleteFile(int fileId) throws Exception {
		String queryId = "system.delete.file";
		Object[] param = new Object[] { fileId };
		return queryService.remove(queryId, param);
	}

	public int deleteFile(int[] fileIdList) throws Exception {
		int affectedRowCount = 0;
		for (int fileId : fileIdList) {
			affectedRowCount += this.deleteFile(fileId);
		}
		return affectedRowCount;
	}

	@SuppressWarnings("unchecked")
	public List<FileDTO> selectFile(RepositoryType repositoryType)
			throws Exception {
		String queryId = "system.select.file.list.by.repository.type";
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("REPOSITORY_TYPE=");
		stringBuilder.append(repositoryType.toString());
		Object[] params = new Object[] { stringBuilder.toString() };
		return (List<FileDTO>) queryService.find(queryId, params);
	}

	@SuppressWarnings("unchecked")
	public List<FileDTO> selectFile() throws Exception {
		String queryId = "system.select.file.list";
		Object[] params = new Object[] {};
		return (List<FileDTO>) queryService.find(queryId, params);
	}

	@SuppressWarnings("unchecked")
	public FileDTO selectFile(int fileId) throws Exception {
		String queryId = "system.select.file";
		Object[] param = new Object[] { fileId };
		Collection<FileDTO> fileCol = queryService.find(queryId, param);
		if (fileCol == null || fileCol.size() == 0)
			return null;
		return (FileDTO) fileCol.toArray()[0];
	}
}
