package org.codelabor.system.security.dtos;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;

public class SecureUrlDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 5456237549561709832L;
	private String httpMethod;
	private String urlPattern;
	private List<ConfigAttribute> configAttributeList;

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public List<ConfigAttribute> getConfigAttributeList() {
		return configAttributeList;
	}

	public void setConfigAttributeList(List<ConfigAttribute> configAttributeList) {
		this.configAttributeList = configAttributeList;
	}

}
