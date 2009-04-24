package org.codelabor.system.certification.pki.services.signkorea;

import org.codelabor.system.certification.pki.CertificateStatus;
import org.codelabor.system.certification.pki.CertificateType;
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
	
	private SKLracUserInfo populate(String name, String registrationNumber, String dn, CertificateType certificateType, boolean isNew, boolean isTest) {
		SKLracUserInfo userInfo = new SKLracUserInfo();
		userInfo.user_name = name;
		userInfo.ssn = registrationNumber;
		StringBuffer dnBuffer = new StringBuffer();
		if (isTest) {
			dnBuffer.append(Constants.testDistinguishedNamePrefix);
		}
		if (isNew) { // reissue
			dnBuffer.append(Constants.defaultDistinguishedName);
		} else { // issue
			dnBuffer.append(dn);
		}
		userInfo.dn = dnBuffer.toString();
	
		switch (certificateType) {
		case PLATINUM_PRIVATE:
			userInfo.cert_kind = "PPB";
			break;
		case PLATINUM_CORPORATION:
			userInfo.cert_kind = "PCB";
			break;
		}		
		return userInfo;
	}	
	
	public CodeDTO enroll(String name, String registrationNumber, String dn,
			CertificateType certificateType, boolean isNew) throws Exception {
		SKLracUserInfo userInfo = this.populate(name, registrationNumber, dn, certificateType, isNew, isTest);;
		SKLracStatus status = new SKLracStatus(); 
		SKLrac lrac = new SKLrac();
		
		int returnCode = 0;
		CertificateStatus certificateStatus;
		
		if (certificateType.equals(CertificateType.PLATINUM_CORPORATION) && isNew) {
			lrac.addUser(userInfo, raServerIp, raServerPort);
			returnCode = lrac.QueryStatus(userInfo, raServerIp, raServerPort, status);
			if (returnCode != 0) throw new QueryStatusException();
		} else {
			returnCode = lrac.QueryStatus(userInfo, raServerIp, raServerPort, status);
			if (returnCode != 0) throw new QueryStatusException();
			certificateStatus = CertificateStatus.valueOf(status.status);
			switch (certificateStatus) {
			case NOT_EXIST:
				returnCode = lrac.addUser(userInfo, raServerIp, raServerPort);
				break;			
			case VALID:
			case INVALID:
			case LOCKED:
			case EXPIRED:
			case NON_ISSUED:
			default:
				returnCode = lrac.re_addUser(userInfo, raServerIp, raServerPort);
				break;
			}
		}
		
		CodeDTO codeDTO = new CodeDTO();
		codeDTO.setReferenceCode(userInfo.auth_reference);
		codeDTO.setAuthorizationCode(userInfo.auth_code);
		codeDTO.setDistinguishedName(status.dn);
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
}
