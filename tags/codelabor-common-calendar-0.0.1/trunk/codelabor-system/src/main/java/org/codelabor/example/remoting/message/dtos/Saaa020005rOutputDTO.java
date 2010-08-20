package org.codelabor.example.remoting.message.dtos;

import java.util.HashMap;
import java.util.Map;

import org.codelabor.system.remoting.message.dtos.DataDTO;

import com.sds.anyframe.util.IOUtil;

public class Saaa020005rOutputDTO extends DataDTO {

	private String charSet = "EUC-KR";

	/**
	 * 표준
	 * 
	 * @name_ko 인터넷뱅킹ID
	 * @length 30
	 */
	private String inbkId;
	/**
	 * 표준
	 * 
	 * @name_ko 고객명
	 * @length 100
	 */
	private String custNm;
	/**
	 * 표준
	 * 
	 * @name_ko 고객구분코드
	 * @length 2
	 */
	private String custDscd;
	/**
	 * 표준
	 * 
	 * @name_ko 실명확인번호
	 * @length 24
	 */
	private String rnmCnfmNo;
	/**
	 * 표준
	 * 
	 * @name_ko 고객번호
	 * @length 8
	 */
	private String custNo;
	/**
	 * 표준
	 * 
	 * @name_ko 이메일주소
	 * @length 200
	 */
	private String emlAdr;
	/**
	 * 표준
	 * 
	 * @name_ko 보안매체구분코드
	 * @length 1
	 */
	private String scurMdDscd;
	/**
	 * 표준
	 * 
	 * @name_ko 공인인증서DN값내용
	 * @length 500
	 */
	private String pbcrDnVlCts;
	/**
	 * 표준
	 * 
	 * @name_ko 인터넷뱅킹최종접속일시
	 * @length 14
	 */
	private String inbkLstCnnDttm;
	/**
	 * 표준
	 * 
	 * @name_ko 공인인증서신청구분코드
	 * @length 1
	 */
	private String pbcrRqsDscd;
	/**
	 * 표준
	 * 
	 * @name_ko 이체신청구분코드
	 * @length 1
	 */
	private String trnfRqsDstCd;
	/**
	 * 표준
	 * 
	 * @name_ko 법인뱅킹사용권한관리자여부
	 * @length 1
	 */
	private String crpBnkUsAthAdminYn;
	/**
	 * 표준
	 * 
	 * @name_ko 관련자성명
	 * @length 40
	 */
	private String rlprNm;
	/**
	 * 표준
	 * 
	 * @name_ko 관련자실명확인번호
	 * @length 24
	 */
	private String rlprRnmCnfmNo;
	/**
	 * 표준
	 * 
	 * @name_ko 개인정보사용동의여부
	 * @length 1
	 */
	private String prvInfUsSmpnYn;
	/**
	 * 표준
	 * 
	 * @name_ko 인터넷뱅킹장기미사용여부
	 * @length 1
	 */
	private String inbkLtrmNusYn;
	/**
	 * 표준
	 * 
	 * @name_ko 조합원고객구분코드
	 * @length 1
	 */
	private String unnrCustDscd;

	/**
	 * 인터넷뱅킹ID Getter Method
	 * 
	 * @name_ko 인터넷뱅킹ID Getter Method
	 * @return 인터넷뱅킹ID
	 */
	public String getInbkId() {
		return inbkId;
	}

	/**
	 * 인터넷뱅킹ID Setter Method
	 * 
	 * @name_ko 인터넷뱅킹ID Setter Method
	 * @param String
	 *            인터넷뱅킹ID
	 */
	public void setInbkId(String inbkId) {
		this.inbkId = inbkId;
	}

	/**
	 * 고객명 Getter Method
	 * 
	 * @name_ko 고객명 Getter Method
	 * @return 고객명
	 */
	public String getCustNm() {
		return custNm;
	}

	/**
	 * 고객명 Setter Method
	 * 
	 * @name_ko 고객명 Setter Method
	 * @param String
	 *            고객명
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	/**
	 * 고객구분코드 Getter Method
	 * 
	 * @name_ko 고객구분코드 Getter Method
	 * @return 고객구분코드
	 */
	public String getCustDscd() {
		return custDscd;
	}

	/**
	 * 고객구분코드 Setter Method
	 * 
	 * @name_ko 고객구분코드 Setter Method
	 * @param String
	 *            고객구분코드
	 */
	public void setCustDscd(String custDscd) {
		this.custDscd = custDscd;
	}

	/**
	 * 실명확인번호 Getter Method
	 * 
	 * @name_ko 실명확인번호 Getter Method
	 * @return 실명확인번호
	 */
	public String getRnmCnfmNo() {
		return rnmCnfmNo;
	}

	/**
	 * 실명확인번호 Setter Method
	 * 
	 * @name_ko 실명확인번호 Setter Method
	 * @param String
	 *            실명확인번호
	 */
	public void setRnmCnfmNo(String rnmCnfmNo) {
		this.rnmCnfmNo = rnmCnfmNo;
	}

	/**
	 * 고객번호 Getter Method
	 * 
	 * @name_ko 고객번호 Getter Method
	 * @return 고객번호
	 */
	public String getCustNo() {
		return custNo;
	}

	/**
	 * 고객번호 Setter Method
	 * 
	 * @name_ko 고객번호 Setter Method
	 * @param String
	 *            고객번호
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	/**
	 * 이메일주소 Getter Method
	 * 
	 * @name_ko 이메일주소 Getter Method
	 * @return 이메일주소
	 */
	public String getEmlAdr() {
		return emlAdr;
	}

	/**
	 * 이메일주소 Setter Method
	 * 
	 * @name_ko 이메일주소 Setter Method
	 * @param String
	 *            이메일주소
	 */
	public void setEmlAdr(String emlAdr) {
		this.emlAdr = emlAdr;
	}

	/**
	 * 보안매체구분코드 Getter Method
	 * 
	 * @name_ko 보안매체구분코드 Getter Method
	 * @return 보안매체구분코드
	 */
	public String getScurMdDscd() {
		return scurMdDscd;
	}

	/**
	 * 보안매체구분코드 Setter Method
	 * 
	 * @name_ko 보안매체구분코드 Setter Method
	 * @param String
	 *            보안매체구분코드
	 */
	public void setScurMdDscd(String scurMdDscd) {
		this.scurMdDscd = scurMdDscd;
	}

	/**
	 * 공인인증서DN값내용 Getter Method
	 * 
	 * @name_ko 공인인증서DN값내용 Getter Method
	 * @return 공인인증서DN값내용
	 */
	public String getPbcrDnVlCts() {
		return pbcrDnVlCts;
	}

	/**
	 * 공인인증서DN값내용 Setter Method
	 * 
	 * @name_ko 공인인증서DN값내용 Setter Method
	 * @param String
	 *            공인인증서DN값내용
	 */
	public void setPbcrDnVlCts(String pbcrDnVlCts) {
		this.pbcrDnVlCts = pbcrDnVlCts;
	}

	/**
	 * 인터넷뱅킹최종접속일시 Getter Method
	 * 
	 * @name_ko 인터넷뱅킹최종접속일시 Getter Method
	 * @return 인터넷뱅킹최종접속일시
	 */
	public String getInbkLstCnnDttm() {
		return inbkLstCnnDttm;
	}

	/**
	 * 인터넷뱅킹최종접속일시 Setter Method
	 * 
	 * @name_ko 인터넷뱅킹최종접속일시 Setter Method
	 * @param String
	 *            인터넷뱅킹최종접속일시
	 */
	public void setInbkLstCnnDttm(String inbkLstCnnDttm) {
		this.inbkLstCnnDttm = inbkLstCnnDttm;
	}

	/**
	 * 공인인증서신청구분코드 Getter Method
	 * 
	 * @name_ko 공인인증서신청구분코드 Getter Method
	 * @return 공인인증서신청구분코드
	 */
	public String getPbcrRqsDscd() {
		return pbcrRqsDscd;
	}

	/**
	 * 공인인증서신청구분코드 Setter Method
	 * 
	 * @name_ko 공인인증서신청구분코드 Setter Method
	 * @param String
	 *            공인인증서신청구분코드
	 */
	public void setPbcrRqsDscd(String pbcrRqsDscd) {
		this.pbcrRqsDscd = pbcrRqsDscd;
	}

	/**
	 * 이체신청구분코드 Getter Method
	 * 
	 * @name_ko 이체신청구분코드 Getter Method
	 * @return 이체신청구분코드
	 */
	public String getTrnfRqsDstCd() {
		return trnfRqsDstCd;
	}

	/**
	 * 이체신청구분코드 Setter Method
	 * 
	 * @name_ko 이체신청구분코드 Setter Method
	 * @param String
	 *            이체신청구분코드
	 */
	public void setTrnfRqsDstCd(String trnfRqsDstCd) {
		this.trnfRqsDstCd = trnfRqsDstCd;
	}

	/**
	 * 법인뱅킹사용권한관리자여부 Getter Method
	 * 
	 * @name_ko 법인뱅킹사용권한관리자여부 Getter Method
	 * @return 법인뱅킹사용권한관리자여부
	 */
	public String getCrpBnkUsAthAdminYn() {
		return crpBnkUsAthAdminYn;
	}

	/**
	 * 법인뱅킹사용권한관리자여부 Setter Method
	 * 
	 * @name_ko 법인뱅킹사용권한관리자여부 Setter Method
	 * @param String
	 *            법인뱅킹사용권한관리자여부
	 */
	public void setCrpBnkUsAthAdminYn(String crpBnkUsAthAdminYn) {
		this.crpBnkUsAthAdminYn = crpBnkUsAthAdminYn;
	}

	/**
	 * 관련자성명 Getter Method
	 * 
	 * @name_ko 관련자성명 Getter Method
	 * @return 관련자성명
	 */
	public String getRlprNm() {
		return rlprNm;
	}

	/**
	 * 관련자성명 Setter Method
	 * 
	 * @name_ko 관련자성명 Setter Method
	 * @param String
	 *            관련자성명
	 */
	public void setRlprNm(String rlprNm) {
		this.rlprNm = rlprNm;
	}

	/**
	 * 관련자실명확인번호 Getter Method
	 * 
	 * @name_ko 관련자실명확인번호 Getter Method
	 * @return 관련자실명확인번호
	 */
	public String getRlprRnmCnfmNo() {
		return rlprRnmCnfmNo;
	}

	/**
	 * 관련자실명확인번호 Setter Method
	 * 
	 * @name_ko 관련자실명확인번호 Setter Method
	 * @param String
	 *            관련자실명확인번호
	 */
	public void setRlprRnmCnfmNo(String rlprRnmCnfmNo) {
		this.rlprRnmCnfmNo = rlprRnmCnfmNo;
	}

	/**
	 * 개인정보사용동의여부 Getter Method
	 * 
	 * @name_ko 개인정보사용동의여부 Getter Method
	 * @return 개인정보사용동의여부
	 */
	public String getPrvInfUsSmpnYn() {
		return prvInfUsSmpnYn;
	}

	/**
	 * 개인정보사용동의여부 Setter Method
	 * 
	 * @name_ko 개인정보사용동의여부 Setter Method
	 * @param String
	 *            개인정보사용동의여부
	 */
	public void setPrvInfUsSmpnYn(String prvInfUsSmpnYn) {
		this.prvInfUsSmpnYn = prvInfUsSmpnYn;
	}

	/**
	 * 인터넷뱅킹장기미사용여부 Getter Method
	 * 
	 * @name_ko 인터넷뱅킹장기미사용여부 Getter Method
	 * @return 인터넷뱅킹장기미사용여부
	 */
	public String getInbkLtrmNusYn() {
		return inbkLtrmNusYn;
	}

	/**
	 * 인터넷뱅킹장기미사용여부 Setter Method
	 * 
	 * @name_ko 인터넷뱅킹장기미사용여부 Setter Method
	 * @param String
	 *            인터넷뱅킹장기미사용여부
	 */
	public void setInbkLtrmNusYn(String inbkLtrmNusYn) {
		this.inbkLtrmNusYn = inbkLtrmNusYn;
	}

	/**
	 * 조합원고객구분코드 Getter Method
	 * 
	 * @name_ko 조합원고객구분코드 Getter Method
	 * @return 조합원고객구분코드
	 */
	public String getUnnrCustDscd() {
		return unnrCustDscd;
	}

	/**
	 * 조합원고객구분코드 Setter Method
	 * 
	 * @name_ko 조합원고객구분코드 Setter Method
	 * @param String
	 *            조합원고객구분코드
	 */
	public void setUnnrCustDscd(String unnrCustDscd) {
		this.unnrCustDscd = unnrCustDscd;
	}

	/**
	 * byte[] 내용을 VO로 변환한다.
	 * 
	 * @name_ko byte[]->VO 변환 메소드
	 * @param 변환될
	 *            byte[]
	 * 
	 */
	public void fromBytes(byte[] bytes) throws Exception {
		setInbkId(IOUtil.substr(bytes, 0, 30, charSet).trim());
		setCustNm(IOUtil.substr(bytes, 30, 130, charSet).trim());
		setCustDscd(IOUtil.substr(bytes, 130, 132, charSet).trim());
		setRnmCnfmNo(IOUtil.substr(bytes, 132, 156, charSet).trim());
		setCustNo(IOUtil.substr(bytes, 156, 164, charSet).trim());
		setEmlAdr(IOUtil.substr(bytes, 164, 364, charSet).trim());
		setScurMdDscd(IOUtil.substr(bytes, 364, 365, charSet).trim());
		setPbcrDnVlCts(IOUtil.substr(bytes, 365, 865, charSet).trim());
		setInbkLstCnnDttm(IOUtil.substr(bytes, 865, 879, charSet).trim());
		setPbcrRqsDscd(IOUtil.substr(bytes, 879, 880, charSet).trim());
		setTrnfRqsDstCd(IOUtil.substr(bytes, 880, 881, charSet).trim());
		setCrpBnkUsAthAdminYn(IOUtil.substr(bytes, 881, 882, charSet).trim());
		setRlprNm(IOUtil.substr(bytes, 882, 922, charSet).trim());
		setRlprRnmCnfmNo(IOUtil.substr(bytes, 922, 946, charSet).trim());
		setPrvInfUsSmpnYn(IOUtil.substr(bytes, 946, 947, charSet).trim());
		setInbkLtrmNusYn(IOUtil.substr(bytes, 947, 948, charSet).trim());
		setUnnrCustDscd(IOUtil.substr(bytes, 948, 949, charSet).trim());
	}

	/**
	 * VO의 내용을 byte[] 변환한다.
	 * 
	 * @name_ko VO->byte[] 변환 메소드
	 * @return byte[] 변환된 byte[]
	 */
	public byte[] toBytes() throws Exception {
		byte[] destBytes = new byte[949];
		IOUtil.bytecopy(getInbkId(), destBytes, 0, 30, ' ', charSet);
		IOUtil.bytecopy(getCustNm(), destBytes, 30, 100, ' ', charSet);
		IOUtil.bytecopy(getCustDscd(), destBytes, 130, 2, ' ', charSet);
		IOUtil.bytecopy(getRnmCnfmNo(), destBytes, 132, 24, ' ', charSet);
		IOUtil.bytecopy(getCustNo(), destBytes, 156, 8, ' ', charSet);
		IOUtil.bytecopy(getEmlAdr(), destBytes, 164, 200, ' ', charSet);
		IOUtil.bytecopy(getScurMdDscd(), destBytes, 364, 1, ' ', charSet);
		IOUtil.bytecopy(getPbcrDnVlCts(), destBytes, 365, 500, ' ', charSet);
		IOUtil.bytecopy(getInbkLstCnnDttm(), destBytes, 865, 14, ' ', charSet);
		IOUtil.bytecopy(getPbcrRqsDscd(), destBytes, 879, 1, ' ', charSet);
		IOUtil.bytecopy(getTrnfRqsDstCd(), destBytes, 880, 1, ' ', charSet);
		IOUtil.bytecopy(getCrpBnkUsAthAdminYn(), destBytes, 881, 1, ' ', charSet);
		IOUtil.bytecopy(getRlprNm(), destBytes, 882, 40, ' ', charSet);
		IOUtil.bytecopy(getRlprRnmCnfmNo(), destBytes, 922, 24, ' ', charSet);
		IOUtil.bytecopy(getPrvInfUsSmpnYn(), destBytes, 946, 1, ' ', charSet);
		IOUtil.bytecopy(getInbkLtrmNusYn(), destBytes, 947, 1, ' ', charSet);
		IOUtil.bytecopy(getUnnrCustDscd(), destBytes, 948, 1, ' ', charSet);

		return destBytes;
	}

	/**
	 * Map의 내용을 VO로 변환한다.
	 * 
	 * @name_ko Map->VO 변환 메소드
	 * @param 변환될
	 *            Map
	 */
	public void fromMap(Map<String, Object> map) {
		setInbkId(IOUtil.getString(map, "inbkId"));
		setCustNm(IOUtil.getString(map, "custNm"));
		setCustDscd(IOUtil.getString(map, "custDscd"));
		setRnmCnfmNo(IOUtil.getString(map, "rnmCnfmNo"));
		setCustNo(IOUtil.getString(map, "custNo"));
		setEmlAdr(IOUtil.getString(map, "emlAdr"));
		setScurMdDscd(IOUtil.getString(map, "scurMdDscd"));
		setPbcrDnVlCts(IOUtil.getString(map, "pbcrDnVlCts"));
		setInbkLstCnnDttm(IOUtil.getString(map, "inbkLstCnnDttm"));
		setPbcrRqsDscd(IOUtil.getString(map, "pbcrRqsDscd"));
		setTrnfRqsDstCd(IOUtil.getString(map, "trnfRqsDstCd"));
		setCrpBnkUsAthAdminYn(IOUtil.getString(map, "crpBnkUsAthAdminYn"));
		setRlprNm(IOUtil.getString(map, "rlprNm"));
		setRlprRnmCnfmNo(IOUtil.getString(map, "rlprRnmCnfmNo"));
		setPrvInfUsSmpnYn(IOUtil.getString(map, "prvInfUsSmpnYn"));
		setInbkLtrmNusYn(IOUtil.getString(map, "inbkLtrmNusYn"));
		setUnnrCustDscd(IOUtil.getString(map, "unnrCustDscd"));
	}

	/**
	 * VO의 내용을 Map으로 변환한다.
	 * 
	 * @name_ko VO->Map 변환 메소드
	 * @return Map 변환된 Map
	 */
	public Map<String, Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("inbkId", getInbkId());
		result.put("custNm", getCustNm());
		result.put("custDscd", getCustDscd());
		result.put("rnmCnfmNo", getRnmCnfmNo());
		result.put("custNo", getCustNo());
		result.put("emlAdr", getEmlAdr());
		result.put("scurMdDscd", getScurMdDscd());
		result.put("pbcrDnVlCts", getPbcrDnVlCts());
		result.put("inbkLstCnnDttm", getInbkLstCnnDttm());
		result.put("pbcrRqsDscd", getPbcrRqsDscd());
		result.put("trnfRqsDstCd", getTrnfRqsDstCd());
		result.put("crpBnkUsAthAdminYn", getCrpBnkUsAthAdminYn());
		result.put("rlprNm", getRlprNm());
		result.put("rlprRnmCnfmNo", getRlprRnmCnfmNo());
		result.put("prvInfUsSmpnYn", getPrvInfUsSmpnYn());
		result.put("inbkLtrmNusYn", getInbkLtrmNusYn());
		result.put("unnrCustDscd", getUnnrCustDscd());
		return result;
	}

}
