package org.codelabor.example.util.comparator;

import java.util.Arrays;

public class ComparatorExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EmpVO empVO1 = new EmpVO();
		empVO1.setEmpNo(2000);
		
		EmpVO empVO2 = new EmpVO();
		empVO2.setEmpNo(1000);
		

		EmpVO[] empVOArray = new EmpVO[2];
		empVOArray[0] = empVO1;
		empVOArray[1] = empVO2;
		
		System.out.println("before");
		for (EmpVO empVO : empVOArray) {
			System.out.println(empVO);
		}
		
		EmpComparator empComparator = new EmpComparator();
		Arrays.sort(empVOArray, empComparator);

		System.out.println("after");
		for (EmpVO empVO : empVOArray) {
			System.out.println(empVO);
		}		

		
		
		
		
		

	}

}
