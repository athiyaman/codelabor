package org.codelabor.system.servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.codelabor.system.RepositoryType;

public abstract class UploadServlet implements Servlet {

	protected String repositoryType = RepositoryType.FILE_SYSTEM.toString();
	protected boolean isRename = true;
	protected String repositoryPath = "/";

	public void init(ServletConfig config) throws ServletException {
		repositoryType = config.getInitParameter("repositoryType");
		repositoryPath = config.getInitParameter("repositoryPath");
		isRename = Boolean.parseBoolean(config.getInitParameter("isRename"));
	}
}
