package org.codelabor.system.sniffer.context;

public class RequestContextImpl implements RequestContext {

	private String requestId = null;

	@Override
	public String getRequestId() {
		return requestId;
	}

	@Override
	public void setRequestId(String userId) {
		this.requestId = userId;
	}

}
