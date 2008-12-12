package org.codelabor.example.struts.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import org.codelabor.example.dtos.CrudDTO;
import org.codelabor.example.services.CrudService;
import org.codelabor.system.struts.actions.BaseDispatchAction;

public class CrudAction extends BaseDispatchAction {

	private CrudService crudService;

	public void setCrudService(CrudService crudService) {
		this.crudService = crudService;
	}

	public ActionForward prepareCreate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		return mapping.findForward("prepareCreate");
	}

	@SuppressWarnings("unchecked")
	public ActionForward prepareUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {

		DynaActionForm dynaActionform = (DynaActionForm) form;
		String crudId = ((String[]) dynaActionform.get("id"))[0];

		// String crudId = request.getParameter("id");
		Map<String, ?> crudMap = this.crudService.read(crudId);
		request.setAttribute("crudMap", crudMap);
		return mapping.findForward("prepareUpdate");
	}

	@SuppressWarnings("unchecked")
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		List crudMapList = this.crudService.list();
		request.setAttribute("crudMapList", crudMapList);
		return mapping.findForward("list");
	}

	@SuppressWarnings("unchecked")
	public ActionForward read(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		String crudId = request.getParameter("id");
		Map<String, ?> crudMap = this.crudService.read(crudId);
		request.setAttribute("crudMap", crudMap);
		return mapping.findForward("read");
	}

	public ActionForward processCreate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		CrudDTO crudDTO = new CrudDTO();
		DynaActionForm dynaActionform = (DynaActionForm) form;
		crudDTO.setField1((String) dynaActionform.get("field1"));
		crudDTO.setField2((String) dynaActionform.get("field2"));

		// crudDTO.setField1(request.getParameter("field1"));
		// crudDTO.setField2(request.getParameter("field1"));
		int affectedRowCount = this.crudService.create(crudDTO);
		request.setAttribute("affectedRowCount", affectedRowCount);
		return mapping.findForward("processCreate");
	}

	public ActionForward processUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		CrudDTO crudDTO = new CrudDTO();
		DynaActionForm dynaActionform = (DynaActionForm) form;
		crudDTO.setId(((String[]) dynaActionform.get("id"))[0]);
		crudDTO.setField1((String) dynaActionform.get("field1"));
		crudDTO.setField2((String) dynaActionform.get("field2"));

		// crudDTO.setId(request.getParameter("id"));
		// crudDTO.setField1(request.getParameter("field1"));
		// crudDTO.setField2(request.getParameter("field2"));
		int affectedRowCount = this.crudService.update(crudDTO);
		request.setAttribute("affectedRowCount", affectedRowCount);
		return mapping.findForward("processUpdate");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse args)
			throws Exception {
		DynaActionForm dynaActionform = (DynaActionForm) form;
		String[] crudIdList = (String[]) dynaActionform.get("id");
		int affectedRowCount = this.crudService.delete(crudIdList);
		request.setAttribute("affectedRowCount", affectedRowCount);
		return mapping.findForward("delete");
	}

}
