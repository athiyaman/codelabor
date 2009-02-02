package org.codelabor.example.services;

import org.codelabor.example.dtos.SystemPropertiesDTO;

public class SystemPropertiesServiceImpl implements SystemPropertiesService {

	public String getProperty(String key) {
		return System.getProperty(key);
	}

	public SystemPropertiesDTO getSystemPropertiesDTO() {
		SystemPropertiesDTO systemPropertiesDTO = new SystemPropertiesDTO();
		systemPropertiesDTO.setJavaVersion("java.version");
		systemPropertiesDTO.setJavaVendor("java.vendor");
		systemPropertiesDTO.setJavaVendorUrl("java.vendor.url");
		systemPropertiesDTO.setJavaHome("java.home");
		systemPropertiesDTO
				.setJavaVmSpecificationVersion("java.vm.specification.version");
		systemPropertiesDTO
				.setJavaVmSpecificationVendor("java.vm.specification.vendor");
		systemPropertiesDTO
				.setJavaVmSpecificationName("java.vm.specification.name");
		systemPropertiesDTO.setJavaVmVersion("java.vm.version");
		systemPropertiesDTO.setJavaVmVendor("java.vm.vendor");
		systemPropertiesDTO.setJavaVmName("java.vm.name");
		systemPropertiesDTO
				.setJavaSpecificationVersion("java.specification.version");
		systemPropertiesDTO
				.setJavaSpecificationVendor("java.specification.vendor");
		systemPropertiesDTO.setJavaSpecificationName("java.specification.name");
		systemPropertiesDTO.setJavaClassVersion("java.class.version");
		systemPropertiesDTO.setJavaClassPath("java.class.path");
		systemPropertiesDTO.setJavaLibraryPath("java.library.path");
		systemPropertiesDTO.setJavaIoTmpdir("java.io.tmpdir");
		systemPropertiesDTO.setJavaCompiler("java.compiler");
		systemPropertiesDTO.setJavaExtDirs("java.ext.dirs");
		systemPropertiesDTO.setOsName("os.name");
		systemPropertiesDTO.setOsArch("os.arch");
		systemPropertiesDTO.setOsVersion("os.version");
		systemPropertiesDTO.setFileSeparator("file.separator");
		systemPropertiesDTO.setPathSeparator("path.separator");
		systemPropertiesDTO.setLineSeparator("line.separator");
		systemPropertiesDTO.setUserName("user.name");
		systemPropertiesDTO.setUserHome("user.home");
		systemPropertiesDTO.setUserDir("user.dir");
		return systemPropertiesDTO;
	}
}
