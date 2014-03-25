package org.codelabor.examples.inheritance.p253;

public class EmployeeTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee emp1 = new Employee();
		Employee emp2 = new Programmer();
		Employee emp3 = new Manager();
		
		emp1.introduce();
		System.out.println(emp1.getMainRole());
		System.out.println(emp1.mainRole);
		System.out.println();
		
		emp2.introduce();
		System.out.println(emp2.getMainRole());
		System.out.println(emp2.mainRole);
		System.out.println();
		
		emp3.introduce();
		System.out.println(emp3.getMainRole());
		System.out.println(emp3.mainRole);
		System.out.println();
		
		
		
		

	}

}
