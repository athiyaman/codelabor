package org.codelabor.example.emp.struts.actions;

import org.codelabor.example.emp.managers.EmpManager;
import org.codelabor.system.spring.actions.BaseActionSupport;

public class BaseEmpAction extends BaseActionSupport {

	protected EmpManager empManager;

	public BaseEmpAction() {
		super();
		empManager = (EmpManager) webApplicationContext
				.getBean("exampleEmpEmpManager");
	}

}
