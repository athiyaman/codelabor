package org.codelabor.system.sign.daos;

import java.util.List;

import org.codelabor.system.sign.dtos.SignDTO;

public interface SignDAO {

	public int insert(SignDTO signDTO) throws Exception;

	public List<SignDTO> select() throws Exception;
}
