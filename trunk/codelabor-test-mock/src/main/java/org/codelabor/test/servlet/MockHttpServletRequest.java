package org.codelabor.test.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MockHttpServletRequest extends HttpServletRequestWrapper {

	public MockHttpServletRequest(HttpServletRequest request) {
		super(request);
	}

}
