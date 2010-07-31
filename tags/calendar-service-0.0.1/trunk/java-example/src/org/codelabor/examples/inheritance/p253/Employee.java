package org.codelabor.examples.inheritance.p253;

public class Employee {
	protected String name;
	protected int age;
	protected String mainRole = "시키는 대로 잘 하기";
	
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
		System.out.println("직원입니다.");
	}
	public String getMainRole() {
		return mainRole;
	}
	public void setMainRole(String mainRole) {
		this.mainRole = mainRole;
	}
	
}
