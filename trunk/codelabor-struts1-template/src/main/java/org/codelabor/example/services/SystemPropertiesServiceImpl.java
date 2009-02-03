package org.codelabor.example.services;

import org.codelabor.example.dtos.SystemPropertiesDTO;
import org.codelabor.system.services.BaseServiceImpl;

public class SystemPropertiesServiceImpl extends BaseServiceImpl implements
		SystemPropertiesService {

	public String getProperty(String key) {
		return System.getProperty(key);
	}

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
