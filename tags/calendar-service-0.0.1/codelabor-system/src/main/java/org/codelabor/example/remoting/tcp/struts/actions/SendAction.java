package org.codelabor.example.remoting.tcp.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.codelabor.system.remoting.tcp.services.SocketAdapterService;
import org.codelabor.system.struts.actions.BaseAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SendAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get bean
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		SocketAdapterService socketAdapterService = (SocketAdapterService) ctx
				.getBean("exampleRemotingTcpSimpleSocketAdapterService");

		// execute biz logic
		DynaActionForm messageForm = (DynaActionForm) form;
		String sentMessage = (String) messageForm.get("message");
		String receivedMessage = socketAdapterService.send(sentMessage);

		// set attribute
		request.setAttribute("receivedMessage", receivedMessage);

		// forward
		return mapping.findForward("success");
	}

}
