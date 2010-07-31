package org.codelabor.system.certification.pki.services.signkorea;

import org.codelabor.system.certification.pki.CertStatus;
import org.codelabor.system.certification.pki.ReturnCodeTranslator;

public class SignkoreaReturnCodeTranslator extends ReturnCodeTranslator {

	@Override
	public CertStatus translate(String returnCode) {
		return translate(Integer.parseInt(returnCode));
	}
	
	@Override
	public CertStatus translate(int returnCode) {
		switch (returnCode) {
		case 0:
			return CertStatus.VALID;
		case 1:
			return CertStatus.REVOKED;
		case 2:
			return CertStatus.SUSPENDED;
		case 3:
			return CertStatus.EXPIRED;
		case 4:
			return CertStatus.REGISTERED_BUT_NOT_ISSUED;
		case 5:
			return CertStatus.NOT_REGISTERED;
		default:
			return null;
		}
	}	
}
