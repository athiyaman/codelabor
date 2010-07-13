package org.codelabor.system.certification.pki;
/*
 * 유효 (Valid): 인증서의 유효기간이 만료이전이며, 폐지 또는 정지되지 않은 유효한 상태
 * 만료 (Expired): 인증서의 유효기간이 지나 효력을 상실한 상태
 * 폐지 (Revoked): 인증서의 사용을 완전히 폐지하여 효력을 상실한 상태
 * 정지 (Suspended): 인증서의 사용을 일시 중지하여 효력을 상실한 상태
 * 미발급 (Registered but Not Issued): 가입자가 등록기관을 통해 등록은 했으나 참조번호/인가코드를 이용해 공인인증기관으로 부터 인증서를 아직 발급 받지 않은 상태
 * 미등록 (Not Registered): 가입자가 등록기관을 통해 가입자 등록도 하지 않은 최초의 상태
 */
public enum CertStatus {
	VALID, // 유효
	EXPIRED, //  만료 
	REVOKED, // 폐지 
	SUSPENDED, // 정지 
	REGISTERED_BUT_NOT_ISSUED, // 미발급 
	NOT_REGISTERED // 미동록
}
