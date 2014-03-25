package org.codelabor.example.remoting.message.dtos;

import java.util.HashMap;
import java.util.Map;

import org.codelabor.system.remoting.message.dtos.DataDTO;

import com.sds.anyframe.util.IOUtil;

public class Saaa001001rInputDTO extends DataDTO {

	private String charSet = "EUC-KR";

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
	 * @name_ko 조회시작일자
	 * @length 8
	 */
	private String inqStDt;
	/**
	 * 표준
	 * 
	 * @name_ko 조회종료일자
	 * @length 8
	 */
	private String inqNdDt;
	/**
	 * 비표준
	 * 
	 * @name_ko 조회키번호
	 * @length 8
	 */
	private String nextKy;

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
	 * 조회시작일자 Getter Method
	 * 
	 * @name_ko 조회시작일자 Getter Method
	 * @return 조회시작일자
	 */
	public String getInqStDt() {
		return inqStDt;
	}

	/**
	 * 조회시작일자 Setter Method
	 * 
	 * @name_ko 조회시작일자 Setter Method
	 * @param String
	 *            조회시작일자
	 */
	public void setInqStDt(String inqStDt) {
		this.inqStDt = inqStDt;
	}

	/**
	 * 조회종료일자 Getter Method
	 * 
	 * @name_ko 조회종료일자 Getter Method
	 * @return 조회종료일자
	 */
	public String getInqNdDt() {
		return inqNdDt;
	}

	/**
	 * 조회종료일자 Setter Method
	 * 
	 * @name_ko 조회종료일자 Setter Method
	 * @param String
	 *            조회종료일자
	 */
	public void setInqNdDt(String inqNdDt) {
		this.inqNdDt = inqNdDt;
	}

	/**
	 * 조회키번호 Getter Method
	 * 
	 * @name_ko 조회키번호 Getter Method
	 * @return 조회키번호
	 */
	public String getNextKy() {
		return nextKy;
	}

	/**
	 * 조회키번호 Setter Method
	 * 
	 * @name_ko 조회키번호 Setter Method
	 * @param String
	 *            조회키번호
	 */
	public void setNextKy(String nextKy) {
		this.nextKy = nextKy;
	}

	/**
	 * byte[] 내용을 VO로 변환한다.
	 * 
	 * @name_ko byte[]->VO 변환 메소드
	 * @param 변환될
	 *            byte[]
	 * 
	 */
	@Override
	public void fromBytes(byte[] bytes) throws Exception {
		setCustNo(IOUtil.substr(bytes, 0, 8, charSet).trim());
		setInqStDt(IOUtil.substr(bytes, 8, 16, charSet).trim());
		setInqNdDt(IOUtil.substr(bytes, 16, 24, charSet).trim());
		setNextKy(IOUtil.substr(bytes, 24, 32, charSet).trim());
	}

	/**
	 * VO의 내용을 byte[] 변환한다.
	 * 
	 * @name_ko VO->byte[] 변환 메소드
	 * @return byte[] 변환된 byte[]
	 */
	@Override
	public byte[] toBytes() throws Exception {
		byte[] destBytes = new byte[32];
		IOUtil.bytecopy(getCustNo(), destBytes, 0, 8, ' ', charSet);
		IOUtil.bytecopy(getInqStDt(), destBytes, 8, 8, ' ', charSet);
		IOUtil.bytecopy(getInqNdDt(), destBytes, 16, 8, ' ', charSet);
		IOUtil.bytecopy(getNextKy(), destBytes, 24, 8, ' ', charSet);

		return destBytes;
	}

	/**
	 * Map의 내용을 VO로 변환한다.
	 * 
	 * @name_ko Map->VO 변환 메소드
	 * @param 변환될
	 *            Map
	 */
	@Override
	public void fromMap(Map<String, Object> map) {
		setCustNo(IOUtil.getString(map, "custNo"));
		setInqStDt(IOUtil.getString(map, "inqStDt"));
		setInqNdDt(IOUtil.getString(map, "inqNdDt"));
		setNextKy(IOUtil.getString(map, "nextKy"));
	}

	/**
	 * VO의 내용을 Map으로 변환한다.
	 * 
	 * @name_ko VO->Map 변환 메소드
	 * @return Map 변환된 Map
	 */
	@Override
	public Map<String, Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("custNo", getCustNo());
		result.put("inqStDt", getInqStDt());
		result.put("inqNdDt", getInqNdDt());
		result.put("nextKy", getNextKy());
		return result;
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

		retValue.append("Saaa001001rInputDTO ( ").append(super.toString()).append(TAB).append("charSet = ").append(this.charSet).append(TAB).append("custNo = ").append(this.custNo).append(TAB).append("inqNdDt = ").append(this.inqNdDt).append(TAB).append("inqStDt = ").append(this.inqStDt)
				.append(TAB).append("nextKy = ").append(this.nextKy).append(TAB).append(" )");

		return retValue.toString();
	}

}
