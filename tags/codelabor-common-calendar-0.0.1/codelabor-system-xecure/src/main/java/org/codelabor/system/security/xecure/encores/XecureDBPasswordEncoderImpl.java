package org.codelabor.system.security.xecure.encores;

import org.codelabor.system.security.services.EncryptService;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class XecureDBPasswordEncoderImpl implements PasswordEncoder {

	// private final Log log = LogFactory
	// .getLog(XecureDBPasswordEncoderImpl.class);

	protected EncryptService encryptService;

	public void setEncryptService(EncryptService encryptService) {
		this.encryptService = encryptService;
	}

	public String encodePassword(String rawPass, Object salt) {
		assert salt == null;
		try {
			// if (log.isDebugEnabled()) {
			// StringBuilder sb = new StringBuilder();
			// sb.append("rawPass: ").append(rawPass);
			// log.debug(sb.toString());
			// }
			return encryptService.hash64(rawPass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RecoverableDataAccessException(e.getMessage(), e);
		}
	}

	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		assert salt == null;
		try {
			// if (log.isDebugEnabled()) {
			// StringBuilder sb = new StringBuilder();
			// sb.append("encPass: ").append(encPass);
			// sb.append(", ");
			// sb.append("rawPass: ").append(rawPass);
			// log.debug(sb.toString());
			// }
			return encryptService.hash64(rawPass).equals(encPass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RecoverableDataAccessException(e.getMessage(), e);
		}
	}
}
