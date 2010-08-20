package org.codelabor.system.certification.name.services;

public interface NameCertificationService {
	public NameCertificationStatus certificate(String name, String resistrationNumber,
			boolean isForeigner) throws Exception;
}
