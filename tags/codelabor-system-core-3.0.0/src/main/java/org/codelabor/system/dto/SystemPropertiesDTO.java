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
public class SystemPropertiesDTO implements Serializable {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -760395641031548481L;

	protected String javaVersion;
	protected String javaVendor;
	protected String javaVendorUrl;
	protected String javaHome;
	protected String javaVmSpecificationVersion;
	protected String javaVmSpecificationVendor;
	protected String javaVmSpecificationName;
	protected String javaVmVersion;
	protected String javaVmVendor;
	protected String javaVmName;
	protected String javaSpecificationVersion;
	protected String javaSpecificationVendor;
	protected String javaSpecificationName;
	protected String javaClassVersion;
	protected String javaClassPath;
	protected String javaLibraryPath;
	protected String javaIoTmpdir;
	protected String javaCompiler;
	protected String javaExtDirs;
	protected String osName;
	protected String osArch;
	protected String osVersion;
	protected String fileSeparator;
	protected String pathSeparator;
	protected String lineSeparator;
	protected String userName;
	protected String userHome;
	protected String userDir;

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getJavaVendor() {
		return javaVendor;
	}

	public void setJavaVendor(String javaVendor) {
		this.javaVendor = javaVendor;
	}

	public String getJavaVendorUrl() {
		return javaVendorUrl;
	}

	public void setJavaVendorUrl(String javaVendorUrl) {
		this.javaVendorUrl = javaVendorUrl;
	}

	public String getJavaHome() {
		return javaHome;
	}

	public void setJavaHome(String javaHome) {
		this.javaHome = javaHome;
	}

	public String getJavaVmSpecificationVersion() {
		return javaVmSpecificationVersion;
	}

	public void setJavaVmSpecificationVersion(String javaVmSpecificationVersion) {
		this.javaVmSpecificationVersion = javaVmSpecificationVersion;
	}

	public String getJavaVmSpecificationVendor() {
		return javaVmSpecificationVendor;
	}

	public void setJavaVmSpecificationVendor(String javaVmSpecificationVendor) {
		this.javaVmSpecificationVendor = javaVmSpecificationVendor;
	}

	public String getJavaVmSpecificationName() {
		return javaVmSpecificationName;
	}

	public void setJavaVmSpecificationName(String javaVmSpecificationName) {
		this.javaVmSpecificationName = javaVmSpecificationName;
	}

	public String getJavaVmVersion() {
		return javaVmVersion;
	}

	public void setJavaVmVersion(String javaVmVersion) {
		this.javaVmVersion = javaVmVersion;
	}

	public String getJavaVmVendor() {
		return javaVmVendor;
	}

	public void setJavaVmVendor(String javaVmVendor) {
		this.javaVmVendor = javaVmVendor;
	}

	public String getJavaVmName() {
		return javaVmName;
	}

	public void setJavaVmName(String javaVmName) {
		this.javaVmName = javaVmName;
	}

	public String getJavaSpecificationVersion() {
		return javaSpecificationVersion;
	}

	public void setJavaSpecificationVersion(String javaSpecificationVersion) {
		this.javaSpecificationVersion = javaSpecificationVersion;
	}

	public String getJavaSpecificationVendor() {
		return javaSpecificationVendor;
	}

	public void setJavaSpecificationVendor(String javaSpecificationVendor) {
		this.javaSpecificationVendor = javaSpecificationVendor;
	}

	public String getJavaSpecificationName() {
		return javaSpecificationName;
	}

	public void setJavaSpecificationName(String javaSpecificationName) {
		this.javaSpecificationName = javaSpecificationName;
	}

	public String getJavaClassVersion() {
		return javaClassVersion;
	}

	public void setJavaClassVersion(String javaClassVersion) {
		this.javaClassVersion = javaClassVersion;
	}

	public String getJavaClassPath() {
		return javaClassPath;
	}

	public void setJavaClassPath(String javaClassPath) {
		this.javaClassPath = javaClassPath;
	}

	public String getJavaLibraryPath() {
		return javaLibraryPath;
	}

	public void setJavaLibraryPath(String javaLibraryPath) {
		this.javaLibraryPath = javaLibraryPath;
	}

	public String getJavaIoTmpdir() {
		return javaIoTmpdir;
	}

	public void setJavaIoTmpdir(String javaIoTmpdir) {
		this.javaIoTmpdir = javaIoTmpdir;
	}

	public String getJavaCompiler() {
		return javaCompiler;
	}

	public void setJavaCompiler(String javaCompiler) {
		this.javaCompiler = javaCompiler;
	}

	public String getJavaExtDirs() {
		return javaExtDirs;
	}

	public void setJavaExtDirs(String javaExtDirs) {
		this.javaExtDirs = javaExtDirs;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsArch() {
		return osArch;
	}

	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getFileSeparator() {
		return fileSeparator;
	}

	public void setFileSeparator(String fileSeparator) {
		this.fileSeparator = fileSeparator;
	}

	public String getPathSeparator() {
		return pathSeparator;
	}

	public void setPathSeparator(String pathSeparator) {
		this.pathSeparator = pathSeparator;
	}

	public String getLineSeparator() {
		return lineSeparator;
	}

	public void setLineSeparator(String lineSeparator) {
		this.lineSeparator = lineSeparator;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHome() {
		return userHome;
	}

	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}

	public String getUserDir() {
		return userDir;
	}

	public void setUserDir(String userDir) {
		this.userDir = userDir;
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

		retValue.append("SystemPropertiesDTO ( ").append(super.toString())
				.append(TAB).append("fileSeparator = ").append(
						this.fileSeparator).append(TAB).append(
						"javaClassPath = ").append(this.javaClassPath).append(
						TAB).append("javaClassVersion = ").append(
						this.javaClassVersion).append(TAB).append(
						"javaCompiler = ").append(this.javaCompiler)
				.append(TAB).append("javaExtDirs = ").append(this.javaExtDirs)
				.append(TAB).append("javaHome = ").append(this.javaHome)
				.append(TAB).append("javaIoTmpdir = ")
				.append(this.javaIoTmpdir).append(TAB).append(
						"javaLibraryPath = ").append(this.javaLibraryPath)
				.append(TAB).append("javaSpecificationName = ").append(
						this.javaSpecificationName).append(TAB).append(
						"javaSpecificationVendor = ").append(
						this.javaSpecificationVendor).append(TAB).append(
						"javaSpecificationVersion = ").append(
						this.javaSpecificationVersion).append(TAB).append(
						"javaVendor = ").append(this.javaVendor).append(TAB)
				.append("javaVendorUrl = ").append(this.javaVendorUrl).append(
						TAB).append("javaVersion = ").append(this.javaVersion)
				.append(TAB).append("javaVmName = ").append(this.javaVmName)
				.append(TAB).append("javaVmSpecificationName = ").append(
						this.javaVmSpecificationName).append(TAB).append(
						"javaVmSpecificationVendor = ").append(
						this.javaVmSpecificationVendor).append(TAB).append(
						"javaVmSpecificationVersion = ").append(
						this.javaVmSpecificationVersion).append(TAB).append(
						"javaVmVendor = ").append(this.javaVmVendor)
				.append(TAB).append("javaVmVersion = ").append(
						this.javaVmVersion).append(TAB).append(
						"lineSeparator = ").append(this.lineSeparator).append(
						TAB).append("osArch = ").append(this.osArch)
				.append(TAB).append("osName = ").append(this.osName)
				.append(TAB).append("osVersion = ").append(this.osVersion)
				.append(TAB).append("pathSeparator = ").append(
						this.pathSeparator).append(TAB).append("userDir = ")
				.append(this.userDir).append(TAB).append("userHome = ").append(
						this.userHome).append(TAB).append("userName = ")
				.append(this.userName).append(TAB).append(" )");

		return retValue.toString();
	}

}
