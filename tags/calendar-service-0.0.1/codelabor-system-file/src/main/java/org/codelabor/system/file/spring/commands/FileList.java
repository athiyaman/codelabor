/**
 * 
 */
package org.codelabor.system.file.spring.commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author bomber
 * 
 */
public class FileList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7498417407011918047L;
	private List<MultipartFile> file = new ArrayList<MultipartFile>();
	private String mapId;
	private String repositoryType;

	public String getMapId() {
		return mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public String getRepositoryType() {
		return repositoryType;
	}

	public void setRepositoryType(String repositoryType) {
		this.repositoryType = repositoryType;
	}

	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
}
