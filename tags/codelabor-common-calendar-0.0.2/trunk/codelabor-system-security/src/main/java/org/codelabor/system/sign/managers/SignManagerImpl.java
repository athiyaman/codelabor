package org.codelabor.system.sign.managers;

import java.util.List;

import org.codelabor.system.managers.BaseManagerImpl;
import org.codelabor.system.sign.daos.SignDAO;
import org.codelabor.system.sign.dtos.SignDTO;

public class SignManagerImpl extends BaseManagerImpl implements SignManager {
	private SignDAO signDAO;

	public void setSignDAO(SignDAO signDAO) {
		this.signDAO = signDAO;
	}

	public int insert(SignDTO signDTO) throws Exception {
		return signDAO.insert(signDTO);
	}

	public List<SignDTO> search() throws Exception {
		return signDAO.select();
	}
}
