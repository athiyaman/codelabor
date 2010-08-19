package org.codelabor.example.remoting.message.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codelabor.system.remoting.message.dtos.DataDTO;

import com.sds.anyframe.util.IOUtil;

public class Saaa001001rOutputDTO extends DataDTO {

	private String charSet = "EUC-KR";

	/**
	 * 비표준
	 * 
	 * @name_ko 조회키번호
	 * @length 8
	 */
	private String nextKy;
	/**
	 * 비표준
	 * 
	 * @name_ko 반복횟수
	 * @length 5
	 */
	private BigDecimal gridCnt;
	/**
	 * @name_ko 전자금융서비스리스트조회_SUB
	 * @length 460
	 * @arrayCount 100
	 */
	private List<Saaa001001rOutstrSub> saaa001001rOutstrSub;

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
	 * 반복횟수 Getter Method
	 * 
	 * @name_ko 반복횟수 Getter Method
	 * @return 반복횟수
	 */
	public BigDecimal getGridCnt() {
		return gridCnt;
	}

	/**
	 * 반복횟수 Setter Method
	 * 
	 * @name_ko 반복횟수 Setter Method
	 * @param BigDecimal
	 *            반복횟수
	 */
	public void setGridCnt(BigDecimal gridCnt) {
		this.gridCnt = gridCnt;
	}

	/**
	 * 전자금융서비스리스트조회_SUB Getter Method
	 * 
	 * @name_ko 전자금융서비스리스트조회_SUB Getter Method
	 * @return 전자금융서비스리스트조회_SUB
	 */
	@SuppressWarnings("unchecked")
	public List getSaaa001001rOutstrSub() {
		return saaa001001rOutstrSub;
	}

	/**
	 * 전자금융서비스리스트조회_SUB Setter Method
	 * 
	 * @name_ko 전자금융서비스리스트조회_SUB Setter Method
	 * @param List
	 *            전자금융서비스리스트조회_SUB
	 */
	@SuppressWarnings("unchecked")
	public void setSaaa001001rOutstrSub(List saaa001001rOutstrSub) {
		this.saaa001001rOutstrSub = saaa001001rOutstrSub;
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
	@SuppressWarnings("unchecked")
	public void fromBytes(byte[] bytes) throws Exception {
		setNextKy(IOUtil.substr(bytes, 0, 8, charSet).trim());
		setGridCnt(IOUtil.getBigDecimal(IOUtil.substr(bytes, 8, 13, charSet).trim()));
		int pos = 13;
		int len = 460;
		List list = new ArrayList();
		for (int i = 0; i < gridCnt.intValue(); i++) {
			Saaa001001rOutstrSub item = new Saaa001001rOutstrSub();
			item.fromBytes(IOUtil.subbyte(bytes, pos, pos + len));
			list.add(item);
			pos += len;
		}
		setSaaa001001rOutstrSub(list);
	}

	/**
	 * VO의 내용을 byte[] 변환한다.
	 * 
	 * @name_ko VO->byte[] 변환 메소드
	 * @return byte[] 변환된 byte[]
	 */
	@Override
	@SuppressWarnings("unchecked")
	public byte[] toBytes() throws Exception {
		byte[] destBytes = new byte[13 + (460 * gridCnt.intValue())];
		IOUtil.bytecopy(getNextKy(), destBytes, 0, 8, ' ', charSet);
		IOUtil.bytecopy(getGridCnt(), destBytes, 8, 5, ' ', charSet);
		int pos = 13;
		List list = getSaaa001001rOutstrSub();
		int len = 460;
		for (int i = 0; i < list.size(); i++) {
			Saaa001001rOutstrSub item = (Saaa001001rOutstrSub) list.get(i);
			IOUtil.bytecopy(item.toBytes(), 0, destBytes, pos, len, ' ');
			pos += len;
		}

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
	@SuppressWarnings("unchecked")
	public void fromMap(Map<String, Object> map) {
		setNextKy(IOUtil.getString(map, "nextKy"));
		setGridCnt(IOUtil.getBigDecimal(map, "gridCnt"));
		if (map.get("saaa001001rOutstrSub") != null) {
			saaa001001rOutstrSub = new ArrayList();
			ArrayList saaa001001rOutstrSubs = (ArrayList) map.get("saaa001001rOutstrSub");
			for (int i = 0; i < saaa001001rOutstrSubs.size(); i++) {
				Saaa001001rOutstrSub saaa001001rOutstrSub = new Saaa001001rOutstrSub();
				saaa001001rOutstrSub.fromMap((Map) saaa001001rOutstrSubs.get(i));
				this.saaa001001rOutstrSub.add(saaa001001rOutstrSub);
			}
		}
	}

	/**
	 * VO의 내용을 Map으로 변환한다.
	 * 
	 * @name_ko VO->Map 변환 메소드
	 * @return Map 변환된 Map
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("nextKy", getNextKy());
		result.put("gridCnt", String.valueOf(getGridCnt()));
		if (saaa001001rOutstrSub != null) {
			ArrayList saaa001001rOutstrSubs = new ArrayList();
			for (int i = 0; i < this.saaa001001rOutstrSub.size(); i++) {
				Saaa001001rOutstrSub saaa001001rOutstrSub = this.saaa001001rOutstrSub.get(i);
				saaa001001rOutstrSubs.add(saaa001001rOutstrSub.toMap());
			}
			result.put("saaa001001rOutstrSub", saaa001001rOutstrSubs);
		}
		return result;
	}

	public class Saaa001001rOutstrSub extends DataDTO {

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
		 * @name_ko 이체신청구분코드
		 * @length 1
		 */
		private String trnfRqsDstCd;
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
		 * @name_ko 인터넷뱅킹사용상태코드
		 * @length 2
		 */
		private String inbkUsStcd;
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
		 * @name_ko ARS사용상태코드
		 * @length 2
		 */
		private String arsUsStcd;
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
		 * @name_ko 보안매체고유번호
		 * @length 16
		 */
		private String scurMdUnqNo;
		/**
		 * 표준
		 * 
		 * @name_ko 비고
		 * @length 300
		 */
		private String rmk;

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
		 * 인터넷뱅킹사용상태코드 Getter Method
		 * 
		 * @name_ko 인터넷뱅킹사용상태코드 Getter Method
		 * @return 인터넷뱅킹사용상태코드
		 */
		public String getInbkUsStcd() {
			return inbkUsStcd;
		}

		/**
		 * 인터넷뱅킹사용상태코드 Setter Method
		 * 
		 * @name_ko 인터넷뱅킹사용상태코드 Setter Method
		 * @param String
		 *            인터넷뱅킹사용상태코드
		 */
		public void setInbkUsStcd(String inbkUsStcd) {
			this.inbkUsStcd = inbkUsStcd;
		}

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
		 * ARS사용상태코드 Getter Method
		 * 
		 * @name_ko ARS사용상태코드 Getter Method
		 * @return ARS사용상태코드
		 */
		public String getArsUsStcd() {
			return arsUsStcd;
		}

		/**
		 * ARS사용상태코드 Setter Method
		 * 
		 * @name_ko ARS사용상태코드 Setter Method
		 * @param String
		 *            ARS사용상태코드
		 */
		public void setArsUsStcd(String arsUsStcd) {
			this.arsUsStcd = arsUsStcd;
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
		 * 보안매체고유번호 Getter Method
		 * 
		 * @name_ko 보안매체고유번호 Getter Method
		 * @return 보안매체고유번호
		 */
		public String getScurMdUnqNo() {
			return scurMdUnqNo;
		}

		/**
		 * 보안매체고유번호 Setter Method
		 * 
		 * @name_ko 보안매체고유번호 Setter Method
		 * @param String
		 *            보안매체고유번호
		 */
		public void setScurMdUnqNo(String scurMdUnqNo) {
			this.scurMdUnqNo = scurMdUnqNo;
		}

		/**
		 * 비고 Getter Method
		 * 
		 * @name_ko 비고 Getter Method
		 * @return 비고
		 */
		public String getRmk() {
			return rmk;
		}

		/**
		 * 비고 Setter Method
		 * 
		 * @name_ko 비고 Setter Method
		 * @param String
		 *            비고
		 */
		public void setRmk(String rmk) {
			this.rmk = rmk;
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
			setTrnfRqsDstCd(IOUtil.substr(bytes, 8, 9, charSet).trim());
			setCustNm(IOUtil.substr(bytes, 9, 109, charSet).trim());
			setInbkUsStcd(IOUtil.substr(bytes, 109, 111, charSet).trim());
			setInbkId(IOUtil.substr(bytes, 111, 141, charSet).trim());
			setArsUsStcd(IOUtil.substr(bytes, 141, 143, charSet).trim());
			setScurMdDscd(IOUtil.substr(bytes, 143, 144, charSet).trim());
			setScurMdUnqNo(IOUtil.substr(bytes, 144, 160, charSet).trim());
			setRmk(IOUtil.substr(bytes, 160, 460, charSet).trim());
		}

		/**
		 * VO의 내용을 byte[] 변환한다.
		 * 
		 * @name_ko VO->byte[] 변환 메소드
		 * @return byte[] 변환된 byte[]
		 */
		@Override
		public byte[] toBytes() throws Exception {
			byte[] destBytes = new byte[460];
			IOUtil.bytecopy(getCustNo(), destBytes, 0, 8, ' ', charSet);
			IOUtil.bytecopy(getTrnfRqsDstCd(), destBytes, 8, 1, ' ', charSet);
			IOUtil.bytecopy(getCustNm(), destBytes, 9, 100, ' ', charSet);
			IOUtil.bytecopy(getInbkUsStcd(), destBytes, 109, 2, ' ', charSet);
			IOUtil.bytecopy(getInbkId(), destBytes, 111, 30, ' ', charSet);
			IOUtil.bytecopy(getArsUsStcd(), destBytes, 141, 2, ' ', charSet);
			IOUtil.bytecopy(getScurMdDscd(), destBytes, 143, 1, ' ', charSet);
			IOUtil.bytecopy(getScurMdUnqNo(), destBytes, 144, 16, ' ', charSet);
			IOUtil.bytecopy(getRmk(), destBytes, 160, 300, ' ', charSet);

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
			setTrnfRqsDstCd(IOUtil.getString(map, "trnfRqsDstCd"));
			setCustNm(IOUtil.getString(map, "custNm"));
			setInbkUsStcd(IOUtil.getString(map, "inbkUsStcd"));
			setInbkId(IOUtil.getString(map, "inbkId"));
			setArsUsStcd(IOUtil.getString(map, "arsUsStcd"));
			setScurMdDscd(IOUtil.getString(map, "scurMdDscd"));
			setScurMdUnqNo(IOUtil.getString(map, "scurMdUnqNo"));
			setRmk(IOUtil.getString(map, "rmk"));
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
			result.put("trnfRqsDstCd", getTrnfRqsDstCd());
			result.put("custNm", getCustNm());
			result.put("inbkUsStcd", getInbkUsStcd());
			result.put("inbkId", getInbkId());
			result.put("arsUsStcd", getArsUsStcd());
			result.put("scurMdDscd", getScurMdDscd());
			result.put("scurMdUnqNo", getScurMdUnqNo());
			result.put("rmk", getRmk());
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

			retValue.append("Saaa001001rOutstrSub ( ").append(super.toString()).append(TAB).append("arsUsStcd = ").append(this.arsUsStcd).append(TAB).append("custNm = ").append(this.custNm).append(TAB).append("custNo = ").append(this.custNo).append(TAB).append("inbkId = ").append(this.inbkId)
					.append(TAB).append("inbkUsStcd = ").append(this.inbkUsStcd).append(TAB).append("rmk = ").append(this.rmk).append(TAB).append("scurMdDscd = ").append(this.scurMdDscd).append(TAB).append("scurMdUnqNo = ").append(this.scurMdUnqNo).append(TAB).append("trnfRqsDstCd = ").append(
							this.trnfRqsDstCd).append(TAB).append(" )");

			return retValue.toString();
		}
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

		retValue.append("Saaa001001rOutputDTO ( ").append(super.toString()).append(TAB).append("charSet = ").append(this.charSet).append(TAB).append("gridCnt = ").append(this.gridCnt).append(TAB).append("nextKy = ").append(this.nextKy).append(TAB).append("saaa001001rOutstrSub = ").append(
				this.saaa001001rOutstrSub).append(TAB).append(" )");

		return retValue.toString();
	}

}
