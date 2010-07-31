package org.codelabor.system.security.xecure.encores;

import org.codelabor.system.security.services.EncryptService;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class XecurePasswordEncoder implements PasswordEncoder {

	protected EncryptService xecureDBEncryptService;

	public void setEncryptService(EncryptService encryptService) {
		this.xecureDBEncryptService = encryptService;
	}

	public String encodePassword(String rawPass, Object salt) {
		assert salt == null;
		try {
			return xecureDBEncryptService.hash64(rawPass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RecoverableDataAccessException(e.getMessage(), e);
		}
	}

	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		assert salt == null;
		try {
			return xecureDBEncryptService.hash64(rawPass).equals(encPass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RecoverableDataAccessException(e.getMessage(), e);
		}
	}
}
