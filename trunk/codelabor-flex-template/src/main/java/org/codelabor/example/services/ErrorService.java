package org.codelabor.example.services;

import org.codelabor.system.exceptions.CommonException;

public interface ErrorService {

	public void rollbackMethod() throws CommonException;

	public void noRollbackMethod() throws CommonException;
}
