package org.codelabor.javaprogramming.homework.exam9;

public class Employee {

	String name;
	int age;
	static int empNum;
	
	public Employee() {
		System.out.println("��� ��ü ���� "+ (++empNum));
	}

	public static int getEmpNum() {
		return empNum;
	}

}
