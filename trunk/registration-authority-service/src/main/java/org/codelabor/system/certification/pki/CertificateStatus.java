package org.codelabor.system.certification.pki;

public enum CertificateStatus {
	VALID, // 유효
	INVALID, // 폐지 
	LOCKED, // 정지 
	EXPIRED, //  만료 
	NON_ISSUED, // 등록 후, 미발급 
	NOT_EXIST // 인증서 없음
}
