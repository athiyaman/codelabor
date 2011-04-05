package org.codelabor.system.web.bind.support.xplatform;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.tx.HttpPlatformRequest;

public class XplatformArgumentResolver implements WebArgumentResolver {

	public Object resolveArgument(MethodParameter methodParameter,
			NativeWebRequest nativeWebRequest) throws Exception {
		Class<?> parameterType = methodParameter.getParameterType();
		if (parameterType.equals(PlatformData.class)) {
			HttpServletRequest request = (HttpServletRequest) nativeWebRequest
					.getNativeRequest();
			HttpPlatformRequest httpPlatformRequest = new HttpPlatformRequest(
					request);
			httpPlatformRequest.receiveData();
			return httpPlatformRequest.getData();
		} else {
			return UNRESOLVED;
		}
	}
}
