package org.codelabor.examples.inheritance.p253;

public class Manager extends Employee {
	protected String mainRole = "관리 하기";
	public void introduce() {
		System.out.println("관리자입니다.");
	}
}
