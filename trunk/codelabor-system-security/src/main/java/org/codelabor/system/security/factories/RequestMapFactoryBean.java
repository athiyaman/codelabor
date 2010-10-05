package org.codelabor.system.security.factories;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.ConfigAttribute;
import org.springframework.security.SecurityConfig;
import org.springframework.security.intercept.web.RequestKey;

@SuppressWarnings("unchecked")
public class RequestMapFactoryBean implements FactoryBean {

	public Object getObject() throws Exception {
		LinkedHashMap<RequestKey, List<ConfigAttribute>> requestMap = new LinkedHashMap<RequestKey, List<ConfigAttribute>>();
		RequestKey requestKey = new RequestKey("/system/administration/**");
		List<ConfigAttribute> configAttributeList = new ArrayList<ConfigAttribute>();
		configAttributeList.add(new SecurityConfig("ROLE_ADMIN"));
		configAttributeList.add(new SecurityConfig("ROLE_USER"));
		requestMap.put(requestKey, configAttributeList);
		return requestMap;
	}

	public Class getObjectType() {
		return LinkedHashMap.class;
	}

	public boolean isSingleton() {
		return true;
	}
}
