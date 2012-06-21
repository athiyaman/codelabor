package org.codelabor.system.web.controller;

import static org.codelabor.system.web.xplatform.XplatformConstants.OUTPUT_DATA_SET_LIST;
import static org.codelabor.system.web.xplatform.XplatformConstants.OUTPUT_VARIABLE_LIST;
import static org.codelabor.system.web.xplatform.XplatformConstants.VIEW_NAME;
import org.codelabor.system.security.context.GscmContextDTO;
import org.codelabor.system.security.context.GscmContextUtils;
import org.codelabor.system.util.xplatform.XplatformUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.anyframe.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.VariableList;

@Controller
@RequestMapping("/system")
public class XplatformSessionController {

	@RequestMapping("/xp/getsession")
	public String getGdsSession(HttpSession session,
			DataSetList inputDataSetList, VariableList inputVariableList,
			Model model) {
		DataSetList outDl = new DataSetList();
		VariableList outVl = new VariableList();
		GscmContextDTO org.codelaborContextDTO = GscmContextUtils.getGscmContextDTO();

		List<Map<String, Object>> userRole = org.codelaborContextDTO.getUserrole();
		Map<String, Object> userSession = new HashMap<String, Object>();

		try {
			userSession.put("userid", StringUtil.null2str(org.codelaborContextDTO.getUserid()));
			userSession.put("username", StringUtil.null2str(org.codelaborContextDTO.getUsername()));
			userSession.put("engname", StringUtil.null2str(org.codelaborContextDTO.getEngname()));
			userSession.put("firstview", StringUtil.null2str(org.codelaborContextDTO.getFirstview()));
			userSession.put("scmlang", StringUtil.null2str(org.codelaborContextDTO.getScmlang()));
			userSession.put("epmail", StringUtil.null2str(org.codelaborContextDTO.getEpmail()));
			userSession.put("deptid", StringUtil.null2str(org.codelaborContextDTO.getDeptid()));
			userSession.put("ipaddr", StringUtil.null2str(org.codelaborContextDTO.getIpaddr()));
			userSession.put("currentipaddr", StringUtil.null2str(org.codelaborContextDTO.getCurrentipaddr()));
			userSession.put("lastlogintime", StringUtil.null2str(org.codelaborContextDTO.getLastlogintime()));
			userSession.put("defaultmodule", StringUtil.null2str(org.codelaborContextDTO.getDefaultmodule()));
			userSession.put("defaultgc", StringUtil.null2str(org.codelaborContextDTO.getDefaultgc()));
			userSession.put("defaultap2", StringUtil.null2str(org.codelaborContextDTO.getDefaultap2()));
			userSession.put("defaultap1", StringUtil.null2str(org.codelaborContextDTO.getDefaultap1()));
			userSession.put("defaultgbm", StringUtil.null2str(org.codelaborContextDTO.getDefaultgbm()));
			userSession.put("defaultproductgroup", StringUtil.null2str(org.codelaborContextDTO.getDefaultproductgroup()));
			userSession.put("defaultfromsub", StringUtil.null2str(org.codelaborContextDTO.getDefaultfromsub()));
			userSession.put("defaulttosub", StringUtil.null2str(org.codelaborContextDTO.getDefaulttosub()));
			userSession.put("defaultplant", StringUtil.null2str(org.codelaborContextDTO.getDefaultplant()));
			userSession.put("logindevice", StringUtil.null2str(org.codelaborContextDTO.getLogindevice()));

			outDl.add(XplatformUtils.convertMapToDataSet(userSession, "outDs"));
			outDl.add(XplatformUtils.convertMapListToDataSet(userRole, "outDsRole"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute(OUTPUT_DATA_SET_LIST, outDl);
		model.addAttribute(OUTPUT_VARIABLE_LIST, outVl);
		return VIEW_NAME;
	}
}
