package org.codelabor.example.util.comparator;

import java.util.Comparator;

public class EmpComparator implements Comparator<EmpVO> {

	public int compare(EmpVO empVO1, EmpVO empVO2) {
		int returnValue = 0;
		if (empVO1.getEmpNo() > empVO2.getEmpNo()) {
			returnValue = 1;
		} else if (empVO1.getEmpNo() < empVO2.getEmpNo()) {
			returnValue = -1;
		}
		return returnValue;
	}

}
