package org.codelabor.system.certification.name.services;

import common.NameCheck;

public class NameCheckNameCertificationServiceImpl implements
		NameCertificationService {

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public void setSitePassword(String sitePassword) {
		this.sitePassword = sitePassword;
	}

	private String siteCode;
	private String sitePassword;
	private int timeOut;

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public NameCertificationStatus certificate(String name,
			String resistrationNumber, boolean isForeigner) throws Exception {

		NameCheck NC = new NameCheck();
		NC.setChkName(name);
		String returnCode = NC.setJumin(resistrationNumber + sitePassword)
				.trim();

		if (returnCode.equals("0")) {
			NC.setSiteCode(siteCode);
			NC.setTimeOut(timeOut);
			returnCode = NC.getRtn().trim();
			return translateReturnCode(returnCode);
		} else {
			return NameCertificationStatus.INCORRECT_ENCRYPTION_DATA;
		}
	}

	private NameCertificationStatus translateReturnCode(String returnCode) {
		if (returnCode.equals("1")) {
			return NameCertificationStatus.CERTIFICATED;
		} else if (returnCode.equals("2")) {
			return NameCertificationStatus.NOT_CERTIFICATED;
		} else if (returnCode.equals("3")) {
			return NameCertificationStatus.NO_DATA;
		} else if (returnCode.equals("4")) {
			return NameCertificationStatus.PROVIDER_SYSTEM_ERROR;
		} else if (returnCode.equals("5")) {
			return NameCertificationStatus.INCORRECT_RESISTRATION_NUMBER;
		} else if (returnCode.equals("6")) {
			return NameCertificationStatus.NOT_ADULT;
		} else if (returnCode.equals("9")) {
			return NameCertificationStatus.INCORRECT_DATA;
		} else if (returnCode.equals("10")) {
			return NameCertificationStatus.INCORRECT_SITE_CODE;
		} else if (returnCode.equals("11")) {
			return NameCertificationStatus.EXPIRED_SITE_CODE;
		} else if (returnCode.equals("12")) {
			return NameCertificationStatus.INCORRECT_SITE_PASSWORD;
		} else if (returnCode.equals("13")) {
			return NameCertificationStatus.PROVIDER_SERVICE_ERROR;
		} else if (returnCode.equals("14")) {
			return NameCertificationStatus.DECODING_SERVICE_ERROR;
		} else if (returnCode.equals("15")) {
			return NameCertificationStatus.DECODING_SYSTEM_ERROR;
		} else if (returnCode.equals("21")) {
			return NameCertificationStatus.INCORRECT_ENCRYPTION_DATA;
		} else if (returnCode.equals("24")) {
			return NameCertificationStatus.ENCRYPTION_ERROR;
		} else if (returnCode.equals("50")) {
			return NameCertificationStatus.ILLEGAL_RESISTRATION_NUMBER;
		} else if (returnCode.equals("61")) {
			return NameCertificationStatus.NO_ROUTE_TO_HOST_EXCEPTION;
		} else if (returnCode.equals("62")) {
			return NameCertificationStatus.MALFORMED_URL_EXCEPTION;
		} else {
			return NameCertificationStatus.UNKNOWN_ERROR;
		}
	}
}