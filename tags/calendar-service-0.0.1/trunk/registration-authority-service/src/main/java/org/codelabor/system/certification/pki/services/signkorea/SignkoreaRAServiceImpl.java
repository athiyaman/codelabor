package org.codelabor.system.certification.pki.services.signkorea;

import org.codelabor.system.certification.pki.CertStatus;
import org.codelabor.system.certification.pki.CertificateType;
import org.codelabor.system.certification.pki.ReturnCodeTranslator;
import org.codelabor.system.certification.pki.dtos.CodeDTO;
import org.codelabor.system.certification.pki.services.QueryStatusException;
import org.codelabor.system.certification.pki.services.RegistrationAuthorityService;

import com.signkorea.Lra.SKLrac;
import com.signkorea.Lra.SKLracStatus;
import com.signkorea.Lra.SKLracUserInfo;

public class SignkoreaRAServiceImpl implements RegistrationAuthorityService {
	private boolean isTest;
	private String raServerIp;


	private int raServerPort;
	private ReturnCodeTranslator returnCodeTranslator;
	
	private SKLracUserInfo populate(String name, String registrationNumber, String dn, CertificateType certificateType, boolean isNew, boolean isTest) throws Exception {
		SKLracUserInfo userInfo = new SKLracUserInfo();
		userInfo.user_name = name;
		userInfo.ssn = registrationNumber;
		StringBuilder dnBuilder = new StringBuilder();
	
		switch (certificateType) {
		case PLATINUM_PRIVATE:
			userInfo.cert_kind = "PPB";
			if (isTest) {
				dnBuilder.append(Constants.testPrivateDNPrefix);
			}			
			break;
		case PLATINUM_CORPORATION:
			userInfo.cert_kind = "PCB";
			if (isTest) {
				dnBuilder.append(Constants.testCorporationDNPrefix);
			}			
			break;
		}
		if (isNew) { // issue
			dnBuilder.append(Constants.defaultDN);
		} else { // reissue
			dnBuilder.append(dn);
		}		
		userInfo.dn = dnBuilder.toString();
		return userInfo;
	}	
	
	public CodeDTO enroll(String name, String registrationNumber, String dn,
			CertificateType certificateType, boolean isNew) throws Exception {
		SKLracUserInfo userInfo = this.populate(name, registrationNumber, dn, certificateType, isNew, isTest);;
		SKLracStatus status = new SKLracStatus(); 
		SKLrac lrac = new SKLrac();
		
		int returnCode = 0;
		CertStatus certificateStatus;
		
		if (certificateType.equals(CertificateType.PLATINUM_CORPORATION) && isNew) {
			lrac.addUser(userInfo, raServerIp, raServerPort);
			returnCode = lrac.QueryStatus(userInfo, raServerIp, raServerPort, status);
			if (returnCode != 0) throw new QueryStatusException();
		} else {
			returnCode = lrac.QueryStatus(userInfo, raServerIp, raServerPort, status);
			if (returnCode != 0) throw new QueryStatusException();
			certificateStatus = returnCodeTranslator.translate(status.status);
			switch (certificateStatus) {
			case NOT_REGISTERED:
				returnCode = lrac.addUser(userInfo, raServerIp, raServerPort);
				break;			
			case VALID:
			case REVOKED:
			case SUSPENDED:
			case EXPIRED:
			case REGISTERED_BUT_NOT_ISSUED:
			default:
				userInfo.dn = status.dn;
				returnCode = lrac.re_addUser(userInfo, raServerIp, raServerPort);
				break;
			}
		}
		
		CodeDTO codeDTO = new CodeDTO();
		codeDTO.setReferenceCode(userInfo.auth_reference);
		codeDTO.setAuthorizationCode(userInfo.auth_code);
		codeDTO.setDistinguishedName(status.dn);
		codeDTO.setSerial(status.serial);
		return codeDTO;
	}
	
	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}

	public void setLrasIp(String lrasIp) {
		this.raServerIp = lrasIp;
	}

	public void setLrasPort(int lrasPort) {
		this.raServerPort = lrasPort;
	}
	
	public void setRaServerIp(String raServerIp) {
		this.raServerIp = raServerIp;
	}
	
	public void setRaServerPort(int raServerPort) {
		this.raServerPort = raServerPort;
	}
	
	public void setReturnCodeTranslator(ReturnCodeTranslator returnCodeTranslator) {
		this.returnCodeTranslator = returnCodeTranslator;
	}	
}
