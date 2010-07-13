package org.codelabor.system.sign.managers;

import java.util.List;

import org.codelabor.system.sign.dtos.SignDTO;

public interface SignManager {
	public List<SignDTO> search() throws Exception;

	public int insert(SignDTO signDTO) throws Exception;
}
