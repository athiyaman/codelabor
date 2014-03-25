package org.codelabor.system.remoting.message.dtos;

import com.sds.anyframe.util.IOUtil;

public class MessageHeaderDTO {
	private final String charsetName = "EUC-KR";

	private final static int MSG_CD_LENGTH = 7;
	private final static int MSG_DESC_LENGTH = 100;
	private final static int SPLM_MSG_CD_LENGTH = 7;
	private final static int SPLM_MSG_DESC_LENGTH = 200;
	private final static int SQL_NO_LENGTH = 6;
	private final static int ERR_SVC_ID_LENGTH = 11;
	private final static int ERR_FLE_NM_LENGTH = 30;
	private final static int ERR_FNC_NM_LENGTH = 30;
	private final static int ERR_LIN_NO_LENGTH = 6;
	public final static int LENGTH = MSG_CD_LENGTH + MSG_DESC_LENGTH
			+ SPLM_MSG_CD_LENGTH + SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH
			+ ERR_SVC_ID_LENGTH + ERR_FLE_NM_LENGTH + ERR_FNC_NM_LENGTH
			+ ERR_LIN_NO_LENGTH;

	private String msgCd;

	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	public void setSplmMsgCd(String splmMsgCd) {
		this.splmMsgCd = splmMsgCd;
	}

	public void setSplmMsgDesc(String splmMsgDesc) {
		this.splmMsgDesc = splmMsgDesc;
	}

	public void setSqlNo(String sqlNo) {
		this.sqlNo = sqlNo;
	}

	public void setErrSvcId(String errSvcId) {
		this.errSvcId = errSvcId;
	}

	public void setErrFleNm(String errFleNm) {
		this.errFleNm = errFleNm;
	}

	public void setErrFncNm(String errFncNm) {
		this.errFncNm = errFncNm;
	}

	public void setErrLinNo(String errLinNo) {
		this.errLinNo = errLinNo;
	}

	private String msgDesc;
	private String splmMsgCd;
	private String splmMsgDesc;
	private String sqlNo = "000000";
	private String errSvcId;
	private String errFleNm;
	private String errFncNm;
	private String errLinNo = "000000";

	public String getMsgCd() {
		return msgCd;
	}

	public String getMsgDesc() {
		return msgDesc;
	}

	public String getSplmMsgCd() {
		return splmMsgCd;
	}

	public String getSplmMsgDesc() {
		return splmMsgDesc;
	}

	public String getSqlNo() {
		return sqlNo;
	}

	public String getErrSvcId() {
		return errSvcId;
	}

	public String getErrFleNm() {
		return errFleNm;
	}

	public String getErrFncNm() {
		return errFncNm;
	}

	public String getErrLinNo() {
		return errLinNo;
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

		retValue.append("MessageHeaderDTO ( ").append(super.toString()).append(
				TAB).append("errFleNm = ").append(this.errFleNm).append(TAB)
				.append("errFncNm = ").append(this.errFncNm).append(TAB)
				.append("errLinNo = ").append(this.errLinNo).append(TAB)
				.append("errSvcId = ").append(this.errSvcId).append(TAB)
				.append("msgCd = ").append(this.msgCd).append(TAB).append(
						"msgDesc = ").append(this.msgDesc).append(TAB).append(
						"splmMsgCd = ").append(this.splmMsgCd).append(TAB)
				.append("splmMsgDesc = ").append(this.splmMsgDesc).append(TAB)
				.append("sqlNo = ").append(this.sqlNo).append(TAB).append(" )");

		return retValue.toString();
	}

	public byte[] toBytes() throws Exception {
		byte[] destBytes = new byte[LENGTH];
		IOUtil.bytecopy(this.getMsgCd(), destBytes, 0, MSG_CD_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getMsgDesc(), destBytes, MSG_CD_LENGTH,
				MSG_DESC_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getSplmMsgCd(), destBytes, MSG_CD_LENGTH
				+ MSG_DESC_LENGTH, SPLM_MSG_CD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getSplmMsgDesc(), destBytes, MSG_CD_LENGTH
				+ MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH, SPLM_MSG_DESC_LENGTH,
				' ', charsetName);
		IOUtil.bytecopy(this.getSqlNo(), destBytes, MSG_CD_LENGTH
				+ MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH + SPLM_MSG_DESC_LENGTH,
				SQL_NO_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getErrSvcId(), destBytes, MSG_CD_LENGTH
				+ MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH + SPLM_MSG_DESC_LENGTH
				+ SQL_NO_LENGTH, ERR_SVC_ID_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getErrFleNm(), destBytes, MSG_CD_LENGTH
				+ MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH + SPLM_MSG_DESC_LENGTH
				+ SQL_NO_LENGTH + ERR_SVC_ID_LENGTH, ERR_FLE_NM_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getErrFncNm(), destBytes, MSG_CD_LENGTH
				+ MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH + SPLM_MSG_DESC_LENGTH
				+ SQL_NO_LENGTH + ERR_SVC_ID_LENGTH + ERR_FLE_NM_LENGTH,
				ERR_FNC_NM_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getErrLinNo(), destBytes, MSG_CD_LENGTH
				+ MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH + SPLM_MSG_DESC_LENGTH
				+ SQL_NO_LENGTH + ERR_SVC_ID_LENGTH + ERR_FLE_NM_LENGTH
				+ ERR_FNC_NM_LENGTH, ERR_LIN_NO_LENGTH, ' ', charsetName);
		return destBytes;
	}

	public void fromBytes(byte[] bytes) throws Exception {
		setMsgCd(IOUtil.substr(bytes, 0, MSG_CD_LENGTH, charsetName).trim());
		setMsgDesc(IOUtil.substr(bytes, MSG_CD_LENGTH, MSG_DESC_LENGTH,
				charsetName).trim());
		setSplmMsgCd(IOUtil.substr(bytes, MSG_CD_LENGTH + MSG_DESC_LENGTH,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH,
				charsetName).trim());
		setSplmMsgDesc(IOUtil.substr(
				bytes,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH, charsetName).trim());
		setSqlNo(IOUtil.substr(
				bytes,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH, charsetName)
				.trim());
		setErrSvcId(IOUtil.substr(
				bytes,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH
						+ ERR_SVC_ID_LENGTH, charsetName).trim());
		setErrFleNm(IOUtil.substr(
				bytes,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH
						+ ERR_SVC_ID_LENGTH,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH
						+ ERR_SVC_ID_LENGTH + ERR_FLE_NM_LENGTH, charsetName)
				.trim());
		setErrFncNm(IOUtil.substr(
				bytes,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH
						+ ERR_SVC_ID_LENGTH + ERR_FLE_NM_LENGTH,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH
						+ ERR_SVC_ID_LENGTH + ERR_FLE_NM_LENGTH
						+ ERR_FNC_NM_LENGTH, charsetName).trim());
		setErrLinNo(IOUtil.substr(
				bytes,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH
						+ ERR_SVC_ID_LENGTH + ERR_FLE_NM_LENGTH
						+ ERR_FNC_NM_LENGTH,
				MSG_CD_LENGTH + MSG_DESC_LENGTH + SPLM_MSG_CD_LENGTH
						+ SPLM_MSG_DESC_LENGTH + SQL_NO_LENGTH
						+ ERR_SVC_ID_LENGTH + ERR_FLE_NM_LENGTH
						+ ERR_FNC_NM_LENGTH + ERR_LIN_NO_LENGTH, charsetName)
				.trim());

	}
}
