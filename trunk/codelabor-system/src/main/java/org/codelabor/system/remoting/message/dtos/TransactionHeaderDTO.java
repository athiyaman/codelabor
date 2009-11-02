package org.codelabor.system.remoting.message.dtos;

import com.sds.anyframe.util.IOUtil;

public class TransactionHeaderDTO {
	private final static int HDBR_BDCD_LENGTH = 4;
	private final static int SCTN_BDCD_LENGTH = 4;
	private final static int TEAM_BDCD_LENGTH = 4;
	private final static int HND_EMPNO_LENGTH = 5;
	private final static int OPTR_NM_LENGTH = 20;
	private final static int LGN_YN_LENGTH = 1;
	private final static int CLSN_BF_AF_DSCD_LENGTH = 1;
	private final static int ICCD_RDR_INP_YN_LENGTH = 1;
	private final static int PINPD_INP_YN_LENGTH = 1;
	private final static int BKBK_PRTR_INP_YN_LENGTH = 1;
	private final static int RSPR_APRV_TR_OBJ_YN_LENGTH = 1;
	private final static int RSPR_APRV_RSCD_LENGTH = 7;
	private final static int RSPR_TMNL_NO_LENGTH = 8;
	private final static int RSPL_EMPNO_LENGTH = 5;
	private final static int CNC_TLG_DSCD_LENGTH = 1;
	private final static int TLG_TR_TPCD_LENGTH = 1;
	private final static int OSD_TR_TPCD_LENGTH = 1;
	private final static int DTM_NTM_DSCD_LENGTH = 1;
	private final static int HDY_DSCD_LENGTH = 1;
	private final static int SLS_DT_LENGTH = 8;
	private final static int SLP_NO_LENGTH = 16;
	private final static int TR_ATR_CD_LENGTH = 1;
	private final static int TR_DT_LENGTH = 8;
	private final static int ERR_MSG_PRCS_YN_LENGTH = 1;
	private final static int RESERVED2_LENGTH = 31;

	public final static int LENGTH = HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH
			+ TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH + OPTR_NM_LENGTH
			+ LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
			+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
			+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
			+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH
			+ TLG_TR_TPCD_LENGTH + OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
			+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH
			+ TR_ATR_CD_LENGTH + TR_DT_LENGTH + ERR_MSG_PRCS_YN_LENGTH
			+ RESERVED2_LENGTH;

	private String hdbrBdcd;
	private String sctnBdcd;
	private String teamBdcd;
	private String hndEmpno;
	private String optrNm;
	private int lgnYn;
	private String clsnBfAfDscd;
	private String iccdRdrInpYn;
	private String pinpdInpYn;
	private String bkbkPrtrInpYn;
	private String rsprAprvTrObjYn;
	private String rsprAprvRscd;
	private String rsprTmnlNo;
	private String rsplEmpno;
	private int cncTlgDscd;
	private int tlgTrTpcd;
	private String osdTrTpcd;
	private String dtmNtmDscd;
	private String hdyDscd = null;
	private String slsDt;
	private String slpNo;
	private String trAtrCd;
	private String trDt;
	private String errMsgPrcsYn;
	private String reserved;

	public String getSlsDt() {
		return slsDt;
	}

	public void setSlsDt(String slsDt) {
		this.slsDt = slsDt;
	}

	public String getSlpNo() {
		return slpNo;
	}

	public void setSlpNo(String slpNo) {
		this.slpNo = slpNo;
	}

	public String getTrAtrCd() {
		return trAtrCd;
	}

	public void setTrAtrCd(String trAtrCd) {
		this.trAtrCd = trAtrCd;
	}

	public String getTrDt() {
		return trDt;
	}

	public void setTrDt(String trDt) {
		this.trDt = trDt;
	}

	public String getErrMsgPrcsYn() {
		return errMsgPrcsYn;
	}

	public void setErrMsgPrcsYn(String errMsgPrcsYn) {
		this.errMsgPrcsYn = errMsgPrcsYn;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getHdbrBdcd() {
		return hdbrBdcd;
	}

	public void setHdbrBdcd(String hdbrBdcd) {
		this.hdbrBdcd = hdbrBdcd;
	}

	public String getSctnBdcd() {
		return sctnBdcd;
	}

	public void setSctnBdcd(String sctnBdcd) {
		this.sctnBdcd = sctnBdcd;
	}

	public String getTeamBdcd() {
		return teamBdcd;
	}

	public void setTeamBdcd(String teamBdcd) {
		this.teamBdcd = teamBdcd;
	}

	public String getHndEmpno() {
		return hndEmpno;
	}

	public void setHndEmpno(String hndEmpno) {
		this.hndEmpno = hndEmpno;
	}

	public String getOptrNm() {
		return optrNm;
	}

	public void setOptrNm(String optrNm) {
		this.optrNm = optrNm;
	}

	public int getLgnYn() {
		return lgnYn;
	}

	public void setLgnYn(int lgnYn) {
		this.lgnYn = lgnYn;
	}

	public String getClsnBfAfDscd() {
		return clsnBfAfDscd;
	}

	public void setClsnBfAfDscd(String clsnBfAfDscd) {
		this.clsnBfAfDscd = clsnBfAfDscd;
	}

	public String getIccdRdrInpYn() {
		return iccdRdrInpYn;
	}

	public void setIccdRdrInpYn(String iccdRdrInpYn) {
		this.iccdRdrInpYn = iccdRdrInpYn;
	}

	public String getPinpdInpYn() {
		return pinpdInpYn;
	}

	public void setPinpdInpYn(String pinpdInpYn) {
		this.pinpdInpYn = pinpdInpYn;
	}

	public String getBkbkPrtrInpYn() {
		return bkbkPrtrInpYn;
	}

	public void setBkbkPrtrInpYn(String bkbkPrtrInpYn) {
		this.bkbkPrtrInpYn = bkbkPrtrInpYn;
	}

	public String getRsprAprvTrObjYn() {
		return rsprAprvTrObjYn;
	}

	public void setRsprAprvTrObjYn(String string) {
		this.rsprAprvTrObjYn = string;
	}

	public String getRsprAprvRscd() {
		return rsprAprvRscd;
	}

	public void setRsprAprvRscd(String rsprAprvRscd) {
		this.rsprAprvRscd = rsprAprvRscd;
	}

	public String getRsprTmnlNo() {
		return rsprTmnlNo;
	}

	public void setRsprTmnlNo(String rsprTmnlNo) {
		this.rsprTmnlNo = rsprTmnlNo;
	}

	public String getRsplEmpno() {
		return rsplEmpno;
	}

	public void setRsplEmpno(String rsplEmpno) {
		this.rsplEmpno = rsplEmpno;
	}

	public int getCncTlgDscd() {
		return cncTlgDscd;
	}

	public void setCncTlgDscd(int cncTlgDscd) {
		this.cncTlgDscd = cncTlgDscd;
	}

	public int getTlgTrTpcd() {
		return tlgTrTpcd;
	}

	public void setTlgTrTpcd(int tlgTrTpcd) {
		this.tlgTrTpcd = tlgTrTpcd;
	}

	public String getOsdTrTpcd() {
		return osdTrTpcd;
	}

	public void setOsdTrTpcd(String osdTrTpcd) {
		this.osdTrTpcd = osdTrTpcd;
	}

	public String getDtmNtmDscd() {
		return dtmNtmDscd;
	}

	public void setDtmNtmDscd(String dtmNtmDscd) {
		this.dtmNtmDscd = dtmNtmDscd;
	}

	public String getHdyDscd() {
		return hdyDscd;
	}

	public void setHdyDscd(String hdyDscd) {
		this.hdyDscd = hdyDscd;
	}

	private final String charsetName = "EUC-KR";

	public byte[] toBytes() throws Exception {
		byte[] destBytes = new byte[LENGTH];
		IOUtil.bytecopy(this.getHdbrBdcd(), destBytes, 0, HDBR_BDCD_LENGTH,
				' ', charsetName);
		IOUtil.bytecopy(this.getSctnBdcd(), destBytes, HDBR_BDCD_LENGTH,
				SCTN_BDCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTeamBdcd(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH, TEAM_BDCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getHndEmpno(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH, HND_EMPNO_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getOptrNm(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH,
				OPTR_NM_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getLgnYn(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH, LGN_YN_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getClsnBfAfDscd(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH, CLSN_BF_AF_DSCD_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getIccdRdrInpYn(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH,
				ICCD_RDR_INP_YN_LENGTH, ' ', charsetName);
		IOUtil
				.bytecopy(this.getPinpdInpYn(), destBytes, HDBR_BDCD_LENGTH
						+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH,
						PINPD_INP_YN_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getBkbkPrtrInpYn(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH,
				BKBK_PRTR_INP_YN_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getRsprAprvTrObjYn(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH, RSPR_APRV_TR_OBJ_YN_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getRsprAprvRscd(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH,
				RSPR_APRV_RSCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getRsprTmnlNo(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH, RSPR_TMNL_NO_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getRsplEmpno(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH,
				RSPL_EMPNO_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getCncTlgDscd(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH, CNC_TLG_DSCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTlgTrTpcd(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH, TLG_TR_TPCD_LENGTH,
				' ', charsetName);
		IOUtil.bytecopy(this.getOsdTrTpcd(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH,
				OSD_TR_TPCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getDtmNtmDscd(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
				+ OSD_TR_TPCD_LENGTH, DTM_NTM_DSCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getHdyDscd(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
				+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH, HDY_DSCD_LENGTH,
				' ', charsetName);
		IOUtil.bytecopy(this.getSlsDt(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
				+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH + HDY_DSCD_LENGTH,
				SLS_DT_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getSlpNo(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
				+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH + HDY_DSCD_LENGTH
				+ SLS_DT_LENGTH, SLP_NO_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTrAtrCd(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
				+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH + HDY_DSCD_LENGTH
				+ SLS_DT_LENGTH + SLP_NO_LENGTH, TR_ATR_CD_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getTrDt(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
				+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH + HDY_DSCD_LENGTH
				+ SLS_DT_LENGTH + SLP_NO_LENGTH + TR_ATR_CD_LENGTH,
				TR_DT_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getErrMsgPrcsYn(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
				+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH + HDY_DSCD_LENGTH
				+ SLS_DT_LENGTH + SLP_NO_LENGTH + TR_ATR_CD_LENGTH
				+ TR_DT_LENGTH, ERR_MSG_PRCS_YN_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getReserved(), destBytes, HDBR_BDCD_LENGTH
				+ SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH + HND_EMPNO_LENGTH
				+ OPTR_NM_LENGTH + LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
				+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
				+ BKBK_PRTR_INP_YN_LENGTH + RSPR_APRV_TR_OBJ_YN_LENGTH
				+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
				+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
				+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH + HDY_DSCD_LENGTH
				+ SLS_DT_LENGTH + SLP_NO_LENGTH + TR_ATR_CD_LENGTH
				+ TR_DT_LENGTH + ERR_MSG_PRCS_YN_LENGTH, RESERVED2_LENGTH, ' ',
				charsetName);

		return destBytes;
	}

	public void fromBytes(byte[] bytes) throws Exception {
		setHdbrBdcd(IOUtil.substr(bytes, 0, HDBR_BDCD_LENGTH, charsetName)
				.trim());
		setSctnBdcd(IOUtil.substr(bytes, HDBR_BDCD_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH, charsetName).trim());
		setTeamBdcd(IOUtil.substr(bytes, HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH,
				charsetName).trim());
		setHndEmpno(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH, charsetName).trim());
		setOptrNm(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH, charsetName)
				.trim());
		setLgnYn(Integer.parseInt(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH,
				charsetName).trim()));
		setClsnBfAfDscd(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH, charsetName).trim());
		setIccdRdrInpYn(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH,
				charsetName).trim());
		setPinpdInpYn(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH, charsetName).trim());
		setBkbkPrtrInpYn(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH,
				charsetName).trim());
		setRsprAprvTrObjYn(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH, charsetName).trim());
		setRsprAprvRscd(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH,
				charsetName).trim());
		setRsprTmnlNo(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH, charsetName).trim());
		setRsplEmpno(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH, charsetName)
				.trim());
		setCncTlgDscd(Integer.parseInt(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH, charsetName).trim()));
		setTlgTrTpcd(Integer.parseInt(IOUtil
				.substr(
						bytes,
						HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
								+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH
								+ LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
								+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
								+ BKBK_PRTR_INP_YN_LENGTH
								+ RSPR_APRV_TR_OBJ_YN_LENGTH
								+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
								+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH,
						HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
								+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH
								+ LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
								+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
								+ BKBK_PRTR_INP_YN_LENGTH
								+ RSPR_APRV_TR_OBJ_YN_LENGTH
								+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
								+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH
								+ TLG_TR_TPCD_LENGTH, charsetName).trim()));
		setOsdTrTpcd(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH, charsetName).trim());
		setDtmNtmDscd(IOUtil
				.substr(
						bytes,
						HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
								+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH
								+ LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
								+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
								+ BKBK_PRTR_INP_YN_LENGTH
								+ RSPR_APRV_TR_OBJ_YN_LENGTH
								+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
								+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH
								+ TLG_TR_TPCD_LENGTH + OSD_TR_TPCD_LENGTH,
						HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
								+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH
								+ LGN_YN_LENGTH + CLSN_BF_AF_DSCD_LENGTH
								+ ICCD_RDR_INP_YN_LENGTH + PINPD_INP_YN_LENGTH
								+ BKBK_PRTR_INP_YN_LENGTH
								+ RSPR_APRV_TR_OBJ_YN_LENGTH
								+ RSPR_APRV_RSCD_LENGTH + RSPR_TMNL_NO_LENGTH
								+ RSPL_EMPNO_LENGTH + CNC_TLG_DSCD_LENGTH
								+ TLG_TR_TPCD_LENGTH + OSD_TR_TPCD_LENGTH
								+ DTM_NTM_DSCD_LENGTH, charsetName).trim());
		setHdyDscd(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH, charsetName).trim());
		setSlsDt(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH, charsetName).trim());
		setSlpNo(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH,
				charsetName).trim());
		setTrAtrCd(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH
						+ TR_ATR_CD_LENGTH, charsetName).trim());
		setTrDt(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH
						+ TR_ATR_CD_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH
						+ TR_ATR_CD_LENGTH + TR_DT_LENGTH, charsetName).trim());
		setErrMsgPrcsYn(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH
						+ TR_ATR_CD_LENGTH + TR_DT_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH
						+ TR_ATR_CD_LENGTH + TR_DT_LENGTH
						+ ERR_MSG_PRCS_YN_LENGTH, charsetName).trim());
		setReserved(IOUtil.substr(
				bytes,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH
						+ TR_ATR_CD_LENGTH + TR_DT_LENGTH
						+ ERR_MSG_PRCS_YN_LENGTH,
				HDBR_BDCD_LENGTH + SCTN_BDCD_LENGTH + TEAM_BDCD_LENGTH
						+ HND_EMPNO_LENGTH + OPTR_NM_LENGTH + LGN_YN_LENGTH
						+ CLSN_BF_AF_DSCD_LENGTH + ICCD_RDR_INP_YN_LENGTH
						+ PINPD_INP_YN_LENGTH + BKBK_PRTR_INP_YN_LENGTH
						+ RSPR_APRV_TR_OBJ_YN_LENGTH + RSPR_APRV_RSCD_LENGTH
						+ RSPR_TMNL_NO_LENGTH + RSPL_EMPNO_LENGTH
						+ CNC_TLG_DSCD_LENGTH + TLG_TR_TPCD_LENGTH
						+ OSD_TR_TPCD_LENGTH + DTM_NTM_DSCD_LENGTH
						+ HDY_DSCD_LENGTH + SLS_DT_LENGTH + SLP_NO_LENGTH
						+ TR_ATR_CD_LENGTH + TR_DT_LENGTH
						+ ERR_MSG_PRCS_YN_LENGTH + RESERVED2_LENGTH,
				charsetName).trim());

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

		retValue.append("TransactionHeaderDTO ( ").append(super.toString())
				.append(TAB).append("bkbkPrtrInpYn = ").append(
						this.bkbkPrtrInpYn).append(TAB).append(
						"clsnBfAfDscd = ").append(this.clsnBfAfDscd)
				.append(TAB).append("cncTlgDscd = ").append(this.cncTlgDscd)
				.append(TAB).append("dtmNtmDscd = ").append(this.dtmNtmDscd)
				.append(TAB).append("errMsgPrcsYn = ")
				.append(this.errMsgPrcsYn).append(TAB).append("hdbrBdcd = ")
				.append(this.hdbrBdcd).append(TAB).append("hdyDscd = ").append(
						this.hdyDscd).append(TAB).append("hndEmpno = ").append(
						this.hndEmpno).append(TAB).append("iccdRdrInpYn = ")
				.append(this.iccdRdrInpYn).append(TAB).append("lgnYn = ")
				.append(this.lgnYn).append(TAB).append("optrNm = ").append(
						this.optrNm).append(TAB).append("osdTrTpcd = ").append(
						this.osdTrTpcd).append(TAB).append("pinpdInpYn = ")
				.append(this.pinpdInpYn).append(TAB).append("reserved = ")
				.append(this.reserved).append(TAB).append("rsplEmpno = ")
				.append(this.rsplEmpno).append(TAB).append("rsprAprvRscd = ")
				.append(this.rsprAprvRscd).append(TAB).append(
						"rsprAprvTrObjYn = ").append(this.rsprAprvTrObjYn)
				.append(TAB).append("rsprTmnlNo = ").append(this.rsprTmnlNo)
				.append(TAB).append("sctnBdcd = ").append(this.sctnBdcd)
				.append(TAB).append("slpNo = ").append(this.slpNo).append(TAB)
				.append("slsDt = ").append(this.slsDt).append(TAB).append(
						"teamBdcd = ").append(this.teamBdcd).append(TAB)
				.append("tlgTrTpcd = ").append(this.tlgTrTpcd).append(TAB)
				.append("trAtrCd = ").append(this.trAtrCd).append(TAB).append(
						"trDt = ").append(this.trDt).append(TAB).append(" )");

		return retValue.toString();
	}

}
