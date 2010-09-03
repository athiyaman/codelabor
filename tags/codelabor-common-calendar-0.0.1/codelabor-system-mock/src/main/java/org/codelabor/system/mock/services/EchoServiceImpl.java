package org.codelabor.system.mock.services;

public class EchoServiceImpl implements EchoService {

	public Object echo(Object obj) throws Exception {
		return obj;
	}

	public String[] echo(String[] array) throws Exception {
		return array;
	}

}
