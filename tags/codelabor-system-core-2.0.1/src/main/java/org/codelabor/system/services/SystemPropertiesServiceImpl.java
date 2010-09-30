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

package org.codelabor.system.services;

import org.codelabor.system.dtos.SystemPropertiesDTO;

/**
 * 시스템 프로퍼티 서비스 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class SystemPropertiesServiceImpl implements SystemPropertiesService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.services.SystemPropertiesService#getProperty(java
	 * .lang.String)
	 */
	public String getProperty(String key) {
		return System.getProperty(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.services.SystemPropertiesService#getSystemPropertiesDTO
	 * ()
	 */
	public SystemPropertiesDTO getSystemPropertiesDTO() {
		SystemPropertiesDTO systemPropertiesDTO = new SystemPropertiesDTO();
		systemPropertiesDTO.setJavaVersion(System.getProperty("java.version"));
		systemPropertiesDTO.setJavaVendor(System.getProperty("java.vendor"));
		systemPropertiesDTO.setJavaVendorUrl(System
				.getProperty("java.vendor.url"));
		systemPropertiesDTO.setJavaHome(System.getProperty("java.home"));
		systemPropertiesDTO.setJavaVmSpecificationVersion(System
				.getProperty("java.vm.specification.version"));
		systemPropertiesDTO.setJavaVmSpecificationVendor(System
				.getProperty("java.vm.specification.vendor"));
		systemPropertiesDTO.setJavaVmSpecificationName(System
				.getProperty("java.vm.specification.name"));
		systemPropertiesDTO.setJavaVmVersion(System
				.getProperty("java.vm.version"));
		systemPropertiesDTO.setJavaVmVendor(System
				.getProperty("java.vm.vendor"));
		systemPropertiesDTO.setJavaVmName(System.getProperty("java.vm.name"));
		systemPropertiesDTO.setJavaSpecificationVersion(System
				.getProperty("java.specification.version"));
		systemPropertiesDTO.setJavaSpecificationVendor(System
				.getProperty("java.specification.vendor"));
		systemPropertiesDTO.setJavaSpecificationName(System
				.getProperty("java.specification.name"));
		systemPropertiesDTO.setJavaClassVersion(System
				.getProperty("java.class.version"));
		systemPropertiesDTO.setJavaClassPath(System
				.getProperty("java.class.path"));
		systemPropertiesDTO.setJavaLibraryPath(System
				.getProperty("java.library.path"));
		systemPropertiesDTO.setJavaIoTmpdir(System
				.getProperty("java.io.tmpdir"));
		systemPropertiesDTO
				.setJavaCompiler(System.getProperty("java.compiler"));
		systemPropertiesDTO.setJavaExtDirs(System.getProperty("java.ext.dirs"));
		systemPropertiesDTO.setOsName(System.getProperty("os.name"));
		systemPropertiesDTO.setOsArch(System.getProperty("os.arch"));
		systemPropertiesDTO.setOsVersion(System.getProperty("os.version"));
		systemPropertiesDTO.setFileSeparator(System
				.getProperty("file.separator"));
		systemPropertiesDTO.setPathSeparator(System
				.getProperty("path.separator"));
		systemPropertiesDTO.setLineSeparator(System
				.getProperty("line.separator"));
		systemPropertiesDTO.setUserName(System.getProperty("user.name"));
		systemPropertiesDTO.setUserHome(System.getProperty("user.home"));
		systemPropertiesDTO.setUserDir(System.getProperty("user.dir"));

		return systemPropertiesDTO;
	}
}
