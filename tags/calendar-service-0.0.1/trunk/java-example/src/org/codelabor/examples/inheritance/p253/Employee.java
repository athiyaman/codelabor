package org.codelabor.examples.inheritance.p253;

public class Employee {
	protected String name;
	protected int age;
	protected String mainRole = "��Ű�� ��� �� �ϱ�";
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void introduce() {
		System.out.println("�����Դϴ�.");
	}
	public String getMainRole() {
		return mainRole;
	}
	public void setMainRole(String mainRole) {
		this.mainRole = mainRole;
	}
	
}
