package org.codelabor.example.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.codelabor.example.dtos.CrudDTO;
import org.codelabor.example.services.CrudService;
import org.codelabor.system.exceptions.ParameterNotFoundException;
import org.codelabor.system.struts.actions.BaseDispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CrudAction extends BaseDispatchAction {

	public CrudAction() {
		super();
	}

	public ActionForward prepareCreate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		return mapping.findForward("prepareCreate");
	}

	public ActionForward prepareUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		CrudService crudService = (CrudService) ctx.getBean("example.crudService");

		DynaActionForm dynaActionform = (DynaActionForm) form;
		String crudId = ((String[]) dynaActionform.get("id"))[0];

		CrudDTO crudDTO = crudService.read(Integer.parseInt(crudId));
		request.setAttribute("crudDTO", crudDTO);
		return mapping.findForward("prepareUpdate");
	}

	@SuppressWarnings("unchecked")
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		CrudService crudService = (CrudService) ctx.getBean("example.crudService");

		List crudDTOList = crudService.list();
		request.setAttribute("crudDTOList", crudDTOList);
		return mapping.findForward("list");
	}

	public ActionForward read(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		CrudService crudService = (CrudService) ctx.getBean("example.crudService");

		String crudIdParam = request.getParameter("id");
		int crudId = 0;
		if (crudIdParam != null && crudIdParam.length() > 0) {
			crudId = Integer.parseInt(crudIdParam);
		} else {
			throw new ParameterNotFoundException();
		}
		CrudDTO crudDTO = crudService.read(crudId);
		request.setAttribute("crudDTO", crudDTO);
		return mapping.findForward("read");
	}

	public ActionForward processCreate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		CrudService crudService = (CrudService) ctx.getBean("example.crudService");

		CrudDTO crudDTO = new CrudDTO();
		DynaActionForm dynaActionform = (DynaActionForm) form;
		crudDTO.setField1((String) dynaActionform.get("field1"));
		crudDTO.setField2((String) dynaActionform.get("field2"));

		int affectedRowCount = crudService.create(crudDTO);
		request.setAttribute("affectedRowCount", affectedRowCount);
		return mapping.findForward("processCreate");
	}

	public ActionForward processUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		CrudService crudService = (CrudService) ctx.getBean("example.crudService");

		CrudDTO crudDTO = new CrudDTO();
		DynaActionForm dynaActionform = (DynaActionForm) form;
		crudDTO.setId(Integer
				.parseInt((((String[]) dynaActionform.get("id"))[0])));
		crudDTO.setField1((String) dynaActionform.get("field1"));
		crudDTO.setField2((String) dynaActionform.get("field2"));

		int affectedRowCount = crudService.update(crudDTO);
		request.setAttribute("affectedRowCount", affectedRowCount);
		return mapping.findForward("processUpdate");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		CrudService crudService = (CrudService) ctx.getBean("example.crudService");

		DynaActionForm dynaActionform = (DynaActionForm) form;
		String[] crudIdStringList = (String[]) dynaActionform.get("id");
		int[] crudIdList = new int[crudIdStringList.length];
		for (int i = 0; i < crudIdStringList.length; i++) {
			crudIdList[i] = Integer.parseInt(crudIdStringList[i]);
		}

		int affectedRowCount = crudService.delete(crudIdList);
		request.setAttribute("affectedRowCount", affectedRowCount);
		return mapping.findForward("delete");
	}
}
