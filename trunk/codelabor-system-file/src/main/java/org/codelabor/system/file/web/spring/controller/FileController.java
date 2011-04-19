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
package org.codelabor.system.file.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Shin Sang-jae
 * 
 */
@Controller
@RequestMapping("/system/file")
public class FileController {

	@RequestMapping("upload")
	public String upload() {
		String viewName = null;
		return viewName;
	}

	@RequestMapping("download")
	public String download() {
		String viewName = null;
		return viewName;
	}

	@RequestMapping("view")
	public String view() {
		String viewName = null;
		return viewName;
	}

	@RequestMapping("list")
	public String list() {
		String viewName = null;
		return viewName;
	}

	public String delete() {
		String viewName = null;
		return viewName;
	}

}
