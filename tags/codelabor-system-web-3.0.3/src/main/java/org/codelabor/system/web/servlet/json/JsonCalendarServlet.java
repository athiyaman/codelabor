/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.system.web.servlet.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * java.util.Calendar의 내용을 JSON 형태로 응답하는 서블릿
 *
 * @author Shin Sang-jae
 *
 */
public class JsonCalendarServlet extends HttpServlet {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = 5860293886282746503L;
	private final Logger logger = LoggerFactory
			.getLogger(JsonCalendarServlet.class);

	/**
	 * 인코딩</br>기본값은 UTF-8을 사용한다.
	 */
	protected String encoding = "UTF-8";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String tempEncoding = config.getInitParameter("encoding");
		if (!StringUtils.isEmpty(tempEncoding)) {
			encoding = tempEncoding;
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Calendar calendar = Calendar.getInstance();
		JSONObject jsonObject = JSONObject.fromObject(calendar);
		logger.debug("calendar: {}", calendar);
		logger.debug("jsonObject: {}", jsonObject);
		response.setCharacterEncoding(encoding);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(jsonObject.toString());
	}
}
