package org.codelabor.system.certification.pki.services;

import org.codelabor.system.certification.pki.dtos.RegistrationDTO;


public abstract class RegistrationAuthorityService {
	public abstract void enroll(RegistrationDTO registrationDTO) throws Exception;
	protected abstract void enrollRA(RegistrationDTO registrationDTO) throws Exception;	
	protected abstract void saveRegistrationInfo(RegistrationDTO registrationDTO) throws Exception;
	protected abstract void loadRegistrationInfo(RegistrationDTO registrationDTO) throws Exception;

}
