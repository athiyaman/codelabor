package org.codelabor.system.sniffer.context;

public class RequestContextImpl implements RequestContext {

	private String requestId = null;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String userId) {
		this.requestId = userId;
	}

}
