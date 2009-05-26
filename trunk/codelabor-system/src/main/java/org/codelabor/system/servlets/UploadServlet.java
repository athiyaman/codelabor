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
		repositoryType = RepositoryType.valueOf(config
				.getInitParameter("repositoryType"));
		repositoryPath = config.getInitParameter("repositoryPath");
		isRename = Boolean.parseBoolean(config.getInitParameter("isRename"));
	}

	public String getUniqueFileName() {
		return UUID.randomUUID().toString();
	}
}
