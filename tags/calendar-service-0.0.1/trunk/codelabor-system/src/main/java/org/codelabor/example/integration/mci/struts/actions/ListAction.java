package org.codelabor.example.integration.mci.struts.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.codelabor.example.integration.mci.services.FinancialService;
import org.codelabor.system.struts.actions.BaseAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ListAction extends BaseAction {
	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get bean
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		FinancialService financialService = (FinancialService) ctx
				.getBean("exampleIntegrationMciFinancialService");

		// execute biz logic
		DynaActionForm searchForm = (DynaActionForm) form;
		String fromDate = (String) searchForm.get("fromDate");
		String toDate = (String) searchForm.get("toDate");

		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("fromDate: ").append(fromDate);
			sb.append(", ");
			sb.append("toDate: ").append(toDate);
			log.debug(sb.toString());
		}

		if (fromDate == null || toDate == null)
			return mapping.findForward("success");

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale
				.getDefault());
		List serviceList = financialService.search(dateFormat.parse(fromDate),
				dateFormat.parse(toDate));

		// set attribute
		request.setAttribute("serviceList", serviceList);

		// forward
		return mapping.findForward("success");
	}
}
