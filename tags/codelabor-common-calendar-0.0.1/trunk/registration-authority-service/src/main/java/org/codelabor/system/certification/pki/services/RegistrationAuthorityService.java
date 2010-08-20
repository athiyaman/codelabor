package org.codelabor.system.certification.pki.services;

import org.codelabor.system.certification.pki.CertificateType;
import org.codelabor.system.certification.pki.dtos.CodeDTO;


public interface RegistrationAuthorityService {
	public CodeDTO enroll(String name, String registrationNumber, String dn, CertificateType certificateType, boolean isNew) throws Exception;
}
