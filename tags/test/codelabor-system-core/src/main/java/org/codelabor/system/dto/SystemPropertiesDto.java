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

package org.codelabor.system.dto;

import java.io.Serializable;

/**
 * 시스템 속성 DTO
 * 
 * @author Shin Sang-jae
 * 
 */
public class SystemPropertiesDto implements Serializable {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -760395641031548481L;

	protected String fileSeparator;
	protected String javaClassPath;
	protected String javaClassVersion;
	protected String javaCompiler;
	protected String javaExtDirs;
	protected String javaHome;
	protected String javaIoTmpdir;
	protected String javaLibraryPath;
	protected String javaSpecificationName;
	protected String javaSpecificationVendor;
	protected String javaSpecificationVersion;
	protected String javaVendor;
	protected String javaVendorUrl;
	protected String javaVersion;
	protected String javaVmName;
	protected String javaVmSpecificationName;
	protected String javaVmSpecificationVendor;
	protected String javaVmSpecificationVersion;
	protected String javaVmVendor;
	protected String javaVmVersion;
	protected String lineSeparator;
	protected String osArch;
	protected String osName;
	protected String osVersion;
	protected String pathSeparator;
	protected String userDir;
	protected String userHome;
	protected String userName;

	public String getFileSeparator() {
		return fileSeparator;
	}

	public String getJavaClassPath() {
		return javaClassPath;
	}

	public String getJavaClassVersion() {
		return javaClassVersion;
	}

	public String getJavaCompiler() {
		return javaCompiler;
	}

	public String getJavaExtDirs() {
		return javaExtDirs;
	}

	public String getJavaHome() {
		return javaHome;
	}

	public String getJavaIoTmpdir() {
		return javaIoTmpdir;
	}

	public String getJavaLibraryPath() {
		return javaLibraryPath;
	}

	public String getJavaSpecificationName() {
		return javaSpecificationName;
	}

	public String getJavaSpecificationVendor() {
		return javaSpecificationVendor;
	}

	public String getJavaSpecificationVersion() {
		return javaSpecificationVersion;
	}

	public String getJavaVendor() {
		return javaVendor;
	}

	public String getJavaVendorUrl() {
		return javaVendorUrl;
	}

	public String getJavaVersion() {
		return javaVersion;
	}

	public String getJavaVmName() {
		return javaVmName;
	}

	public String getJavaVmSpecificationName() {
		return javaVmSpecificationName;
	}

	public String getJavaVmSpecificationVendor() {
		return javaVmSpecificationVendor;
	}

	public String getJavaVmSpecificationVersion() {
		return javaVmSpecificationVersion;
	}

	public String getJavaVmVendor() {
		return javaVmVendor;
	}

	public String getJavaVmVersion() {
		return javaVmVersion;
	}

	public String getLineSeparator() {
		return lineSeparator;
	}

	public String getOsArch() {
		return osArch;
	}

	public String getOsName() {
		return osName;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public String getPathSeparator() {
		return pathSeparator;
	}

	public String getUserDir() {
		return userDir;
	}

	public String getUserHome() {
		return userHome;
	}

	public String getUserName() {
		return userName;
	}

	public void setFileSeparator(String fileSeparator) {
		this.fileSeparator = fileSeparator;
	}

	public void setJavaClassPath(String javaClassPath) {
		this.javaClassPath = javaClassPath;
	}

	public void setJavaClassVersion(String javaClassVersion) {
		this.javaClassVersion = javaClassVersion;
	}

	public void setJavaCompiler(String javaCompiler) {
		this.javaCompiler = javaCompiler;
	}

	public void setJavaExtDirs(String javaExtDirs) {
		this.javaExtDirs = javaExtDirs;
	}

	public void setJavaHome(String javaHome) {
		this.javaHome = javaHome;
	}

	public void setJavaIoTmpdir(String javaIoTmpdir) {
		this.javaIoTmpdir = javaIoTmpdir;
	}

	public void setJavaLibraryPath(String javaLibraryPath) {
		this.javaLibraryPath = javaLibraryPath;
	}

	public void setJavaSpecificationName(String javaSpecificationName) {
		this.javaSpecificationName = javaSpecificationName;
	}

	public void setJavaSpecificationVendor(String javaSpecificationVendor) {
		this.javaSpecificationVendor = javaSpecificationVendor;
	}

	public void setJavaSpecificationVersion(String javaSpecificationVersion) {
		this.javaSpecificationVersion = javaSpecificationVersion;
	}

	public void setJavaVendor(String javaVendor) {
		this.javaVendor = javaVendor;
	}

	public void setJavaVendorUrl(String javaVendorUrl) {
		this.javaVendorUrl = javaVendorUrl;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public void setJavaVmName(String javaVmName) {
		this.javaVmName = javaVmName;
	}

	public void setJavaVmSpecificationName(String javaVmSpecificationName) {
		this.javaVmSpecificationName = javaVmSpecificationName;
	}

	public void setJavaVmSpecificationVendor(String javaVmSpecificationVendor) {
		this.javaVmSpecificationVendor = javaVmSpecificationVendor;
	}

	public void setJavaVmSpecificationVersion(String javaVmSpecificationVersion) {
		this.javaVmSpecificationVersion = javaVmSpecificationVersion;
	}

	public void setJavaVmVendor(String javaVmVendor) {
		this.javaVmVendor = javaVmVendor;
	}

	public void setJavaVmVersion(String javaVmVersion) {
		this.javaVmVersion = javaVmVersion;
	}

	public void setLineSeparator(String lineSeparator) {
		this.lineSeparator = lineSeparator;
	}

	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public void setPathSeparator(String pathSeparator) {
		this.pathSeparator = pathSeparator;
	}

	public void setUserDir(String userDir) {
		this.userDir = userDir;
	}

	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("SystemPropertiesDto ( ").append(super.toString())
				.append(TAB).append("fileSeparator = ")
				.append(this.fileSeparator).append(TAB)
				.append("javaClassPath = ").append(this.javaClassPath)
				.append(TAB).append("javaClassVersion = ")
				.append(this.javaClassVersion).append(TAB)
				.append("javaCompiler = ").append(this.javaCompiler)
				.append(TAB).append("javaExtDirs = ").append(this.javaExtDirs)
				.append(TAB).append("javaHome = ").append(this.javaHome)
				.append(TAB).append("javaIoTmpdir = ")
				.append(this.javaIoTmpdir).append(TAB)
				.append("javaLibraryPath = ").append(this.javaLibraryPath)
				.append(TAB).append("javaSpecificationName = ")
				.append(this.javaSpecificationName).append(TAB)
				.append("javaSpecificationVendor = ")
				.append(this.javaSpecificationVendor).append(TAB)
				.append("javaSpecificationVersion = ")
				.append(this.javaSpecificationVersion).append(TAB)
				.append("javaVendor = ").append(this.javaVendor).append(TAB)
				.append("javaVendorUrl = ").append(this.javaVendorUrl)
				.append(TAB).append("javaVersion = ").append(this.javaVersion)
				.append(TAB).append("javaVmName = ").append(this.javaVmName)
				.append(TAB).append("javaVmSpecificationName = ")
				.append(this.javaVmSpecificationName).append(TAB)
				.append("javaVmSpecificationVendor = ")
				.append(this.javaVmSpecificationVendor).append(TAB)
				.append("javaVmSpecificationVersion = ")
				.append(this.javaVmSpecificationVersion).append(TAB)
				.append("javaVmVendor = ").append(this.javaVmVendor)
				.append(TAB).append("javaVmVersion = ")
				.append(this.javaVmVersion).append(TAB)
				.append("lineSeparator = ").append(this.lineSeparator)
				.append(TAB).append("osArch = ").append(this.osArch)
				.append(TAB).append("osName = ").append(this.osName)
				.append(TAB).append("osVersion = ").append(this.osVersion)
				.append(TAB).append("pathSeparator = ")
				.append(this.pathSeparator).append(TAB).append("userDir = ")
				.append(this.userDir).append(TAB).append("userHome = ")
				.append(this.userHome).append(TAB).append("userName = ")
				.append(this.userName).append(TAB).append(" )");

		return retValue.toString();
	}

}
