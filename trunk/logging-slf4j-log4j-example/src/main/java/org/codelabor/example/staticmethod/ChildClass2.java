package org.codelabor.example.staticmethod;

public class ChildClass2 extends ParentClass2 {

	public ChildClass2() {
		super();
		logger.debug("constructor");
	}
	
	static protected void  someStaticMethod() {
		logger.debug("someStaticMethod");
	}

}
