package org.codelabor.system.servlets;

import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.codelabor.system.RepositoryType;

public abstract class UploadServlet implements Servlet {

	protected RepositoryType repositoryType = RepositoryType.FILE_SYSTEM;
	protected boolean isRename = true;
	protected String repositoryPath = "/";

	public void init(ServletConfig config) throws ServletException {
		String _repositoryType = config.getInitParameter("repositoryType");
		String _repositoryPath = config.getInitParameter("repositoryPath");
		String _isRename = config.getInitParameter("isRename");

		if (_repositoryType != null && _repositoryType.length() > 0) {
			repositoryType = RepositoryType.valueOf(_repositoryType);
		}
		if (_repositoryPath != null && _repositoryPath.length() > 0) {
			repositoryPath = _repositoryPath;
		}
		if (_isRename != null && _isRename.length() > 0) {
			isRename = Boolean.parseBoolean(_isRename);
		}
	}

	public String getUniqueFileName() {
		return UUID.randomUUID().toString();
	}
}
