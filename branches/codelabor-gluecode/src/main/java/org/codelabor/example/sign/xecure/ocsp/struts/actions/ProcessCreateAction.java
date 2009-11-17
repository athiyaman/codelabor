package org.codelabor.example.sign.xecure.ocsp.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codelabor.system.security.xecure.Constants;
import org.codelabor.system.sign.dtos.SignDTO;
import org.codelabor.system.sign.exceptions.NotVerifiedException;
import org.codelabor.system.sign.managers.SignManager;
import org.codelabor.system.struts.actions.BaseAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.WebUtils;

import xecure.crypto.Certificate;
import xecure.crypto.SignVerifierM;
import xecure.servlet.XecureConfig;
import anyframe.core.properties.IPropertiesService;

public class ProcessCreateAction extends BaseAction {

	private String caDnList;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// get bean
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		SignManager signManager = (SignManager) ctx.getBean("signManager");
		IPropertiesService propertiesService = (IPropertiesService) ctx
				.getBean("propertiesService");

		// get caDnList
		caDnList = propertiesService.getString("ca.dn.list");
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("caDnList: ").append(caDnList);
			log.debug(sb.toString());
		}

		// exeucte biz logic
		String signedMessage = WebUtils.findParameterValue(request,
				Constants.SECURITY_SIGNED_MESSAGE_KEY);

		if (signedMessage != null) {
			SignVerifierM signVerifier = new SignVerifierM(new XecureConfig(),
					signedMessage);

			// 서명 메시지 검증
			int errorCode = signVerifier.getLastError();
			if (errorCode != 0) {
				throw new NotVerifiedException(signVerifier.getLastErrorMsg());
			}

			// OCSP 검증
			errorCode = signVerifier.getSignerCertificate().VerifyCertificate(
					signVerifier.getSignerCertificate().getCertPem(),
					"internet", caDnList);
			if (errorCode != 0) {
				throw new NotVerifiedException(signVerifier.getLastErrorMsg());
			}

			Certificate signerCertificate = signVerifier.getSignerCertificate();
			String subject = signerCertificate.getSubject().trim();
			String certPem = signerCertificate.getCertPem();
			int certType = signerCertificate.getCertType();
			String serial = signerCertificate.getSerial();

			SignDTO signDTO = new SignDTO();
			signDTO.setSerial(serial);
			signDTO.setSubject(subject);
			signDTO.setSignedMessage(signedMessage);
			signDTO.setCertType(String.valueOf(certType));
			signDTO.setCertPem(certPem);
			signManager.insert(signDTO);
		}

		// forward
		return mapping.findForward("success");
	}
}
