package org.codelabor.system.file.advices;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;

public class FileAuthorizationAdvice implements Ordered {

	protected Logger logger = LoggerFactory
			.getLogger(FileAuthorizationAdvice.class);

	protected int order;

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void deleteFile(JoinPoint joinPoint) {

	}

	public void insertFile(JoinPoint joinPoint) {

	}

	public void selectFile(JoinPoint joinPoint) {

	}

	public void selectFileByRepositoryType(JoinPoint joinPoint) {

	}

	public void selectFileByFileId(JoinPoint joinPoint) {

	}

	public void selectFileByMapId(JoinPoint joinPoint) {

	}

}
