package org.codelabor.commons.zipcode.service;

public class EpostZipCodeServiceImpl implements ZipCodeService {
	protected String openApiRegKey = null;

	/**
	 * @return the openApiRegKey
	 */
	public String getOpenApiRegKey() {
		return openApiRegKey;
	}

	/**
	 * @param openApiRegKey
	 *            the openApiRegKey to set
	 */
	public void setOpenApiRegKey(String openApiRegKey) {
		this.openApiRegKey = openApiRegKey;
	}
}
