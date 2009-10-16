package org.codelabor.example.emp.struts.actions;

import org.codelabor.example.emp.managers.EmpManager;
import org.codelabor.system.struts.actions.BaseAction;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BaseEmpAction extends BaseAction {

	protected EmpManager empManager = (EmpManager) WebApplicationContextUtils
			.getRequiredWebApplicationContext(servlet.getServletContext())
			.getBean("exampleEmpEmpManager");

}
