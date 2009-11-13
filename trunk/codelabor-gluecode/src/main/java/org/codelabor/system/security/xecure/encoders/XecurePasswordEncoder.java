package org.codelabor.system.security.xecure.encoders;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.security.services.EncryptService;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class XecurePasswordEncoder implements PasswordEncoder {

	private final Log log = LogFactory.getLog(XecurePasswordEncoder.class);

	protected EncryptService xecureDBEncryptService;

	public void setEncryptService(EncryptService encryptService) {
		this.xecureDBEncryptService = encryptService;
	}

	public String encodePassword(String rawPass, Object salt) {
		assert salt == null;
		try {
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("rawPass: ").append(rawPass);
				log.debug(sb.toString());
			}
			return xecureDBEncryptService.hash64(rawPass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RecoverableDataAccessException(e.getMessage(), e);
		}
	}

	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		assert salt == null;
		try {
			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("encPass: ").append(encPass);
				sb.append(", ");
				sb.append("rawPass: ").append(rawPass);
				log.debug(sb.toString());
			}
			return xecureDBEncryptService.hash64(rawPass).equals(encPass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RecoverableDataAccessException(e.getMessage(), e);
		}
	}
}
