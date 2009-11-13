package org.codelabor.system.certification.pki.services;

import org.codelabor.system.certification.pki.dtos.RegistrationDTO;

public interface RegistrationAuthorityService {
	public void enroll(RegistrationDTO registrationDTO) throws Exception;

	public void enrollRA(RegistrationDTO registrationDTO) throws Exception;

	public void saveRegistrationInfo(RegistrationDTO registrationDTO)
			throws Exception;

	public void loadRegistrationInfo(RegistrationDTO registrationDTO)
			throws Exception;

}
