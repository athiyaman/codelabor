package org.codelabor.example.daos;

import java.util.List;
import java.util.Map;

import org.codelabor.example.dtos.EmpDTO;
import org.codelabor.system.dtos.AffectedRowCountDTO;

public interface EmpDAO {
	public int insertEmp(EmpDTO empDTO) throws Exception;

	public int insertEmp(List<EmpDTO> empDTOList) throws Exception;

	public int updateEmp(EmpDTO empDTO) throws Exception;

	public int updateEmp(List<EmpDTO> empDTOList) throws Exception;

	public int deleteEmp(EmpDTO empDTO) throws Exception;

	public int deleteEmp(List<EmpDTO> empDTOList) throws Exception;

	public AffectedRowCountDTO saveEmp(List<EmpDTO> insertEmpDTOList,
			List<EmpDTO> updateEmpDTOList, List<EmpDTO> deleteEmpDTOList)
			throws Exception;

	public List<EmpDTO> selectEmp() throws Exception;

	public List<EmpDTO> selectEmp(Map<String, String> searchCondition)
			throws Exception;
}
