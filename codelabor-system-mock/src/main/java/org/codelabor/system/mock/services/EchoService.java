package org.codelabor.system.mock.services;

public interface EchoService {
	public String[] echo(String[] array) throws Exception;

	public Object echo(Object obj) throws Exception;
}