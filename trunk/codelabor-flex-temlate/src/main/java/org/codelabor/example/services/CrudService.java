package org.codelabor.example.services;

import java.util.List;
import java.util.Map;

import org.codelabor.example.dtos.CrudDTO;
import org.codelabor.system.exceptions.CommonException;

public interface CrudService {

	public int create(CrudDTO crudDTO) throws CommonException;

	public int update(CrudDTO crudDTO) throws CommonException;

	public int delete(String[] crudIdList) throws CommonException;

	@SuppressWarnings("unchecked")
	public Map read(String crudId) throws CommonException;

	@SuppressWarnings("unchecked")
	public List<Map> list(String filed1Pattern) throws CommonException;

	@SuppressWarnings("unchecked")
	public List<Map> list() throws CommonException;
}
