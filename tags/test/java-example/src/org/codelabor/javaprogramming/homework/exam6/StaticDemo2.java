package org.codelabor.javaprogramming.homework.exam6;

import org.codelabor.javaprogramming.homework.exam9.Employee;

public class StaticDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int empNum = Integer.parseInt(args[0]);
		Employee[] employee = new Employee[empNum];
		for (int i=0; i<employee.length; i++) {
			employee[i] = new Employee();
		}
		System.out.println("생성된 사원 객체의 수: "+Employee.getEmpNum());
		
	}

}
