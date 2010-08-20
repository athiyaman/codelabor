package org.codelabor.system.dtos;

import java.io.Serializable;

public class SystemPropertiesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -760395641031548481L;

	private String javaVersion;
	private String javaVendor;
	private String javaVendorUrl;
	private String javaHome;
	private String javaVmSpecificationVersion;
	private String javaVmSpecificationVendor;
	private String javaVmSpecificationName;
	private String javaVmVersion;
	private String javaVmVendor;
	private String javaVmName;
	private String javaSpecificationVersion;
	private String javaSpecificationVendor;
	private String javaSpecificationName;
	private String javaClassVersion;
	private String javaClassPath;
	
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
	private String javaLibraryPath;
	private String javaIoTmpdir;
	private String javaCompiler;
	private String javaExtDirs;
	private String osName;
	private String osArch;
	private String osVersion;
	private String fileSeparator;
	private String pathSeparator;
	private String lineSeparator;
	private String userName;
	private String userHome;
	private String userDir;

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("SystemPropertiesDTO ( ")
	        .append(super.toString()).append(TAB)
	        .append("fileSeparator = ").append(this.fileSeparator).append(TAB)
	        .append("javaClassPath = ").append(this.javaClassPath).append(TAB)
	        .append("javaClassVersion = ").append(this.javaClassVersion).append(TAB)
	        .append("javaCompiler = ").append(this.javaCompiler).append(TAB)
	        .append("javaExtDirs = ").append(this.javaExtDirs).append(TAB)
	        .append("javaHome = ").append(this.javaHome).append(TAB)
	        .append("javaIoTmpdir = ").append(this.javaIoTmpdir).append(TAB)
	        .append("javaLibraryPath = ").append(this.javaLibraryPath).append(TAB)
	        .append("javaSpecificationName = ").append(this.javaSpecificationName).append(TAB)
	        .append("javaSpecificationVendor = ").append(this.javaSpecificationVendor).append(TAB)
	        .append("javaSpecificationVersion = ").append(this.javaSpecificationVersion).append(TAB)
	        .append("javaVendor = ").append(this.javaVendor).append(TAB)
	        .append("javaVendorUrl = ").append(this.javaVendorUrl).append(TAB)
	        .append("javaVersion = ").append(this.javaVersion).append(TAB)
	        .append("javaVmName = ").append(this.javaVmName).append(TAB)
	        .append("javaVmSpecificationName = ").append(this.javaVmSpecificationName).append(TAB)
	        .append("javaVmSpecificationVendor = ").append(this.javaVmSpecificationVendor).append(TAB)
	        .append("javaVmSpecificationVersion = ").append(this.javaVmSpecificationVersion).append(TAB)
	        .append("javaVmVendor = ").append(this.javaVmVendor).append(TAB)
	        .append("javaVmVersion = ").append(this.javaVmVersion).append(TAB)
	        .append("lineSeparator = ").append(this.lineSeparator).append(TAB)
	        .append("osArch = ").append(this.osArch).append(TAB)
	        .append("osName = ").append(this.osName).append(TAB)
	        .append("osVersion = ").append(this.osVersion).append(TAB)
	        .append("pathSeparator = ").append(this.pathSeparator).append(TAB)
	        .append("userDir = ").append(this.userDir).append(TAB)
	        .append("userHome = ").append(this.userHome).append(TAB)
	        .append("userName = ").append(this.userName).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}

}
