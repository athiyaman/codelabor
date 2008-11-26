package org.codelabor.system.services;

import org.codelabor.system.dtos.MailDTO;

public interface MailService {

	public void send(MailDTO mailDTO) throws Exception;

}
