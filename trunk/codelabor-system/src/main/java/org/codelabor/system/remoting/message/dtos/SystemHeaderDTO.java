package org.codelabor.system.remoting.message.dtos;

import com.sds.anyframe.util.IOUtil;

public class SystemHeaderDTO {
	private final static int STND_TLG_THWH_LEN_LENGTH = 8;
	private final static int TLG_DSCD_LENGTH = 1;
	private final static int ITN_INCD_LENGTH = 3;
	private final static int TR_CD_LENGTH = 11;
	private final static int SCRN_NO_LENGTH = 8;
	private final static int SYS_DSCD_LENGTH = 3;
	private final static int TR_ID_CH_CODE_LENGTH = 3;
	private final static int TR_ID_PID_LENGTH = 8;
	private final static int TR_ID_REQ_DT_LENGTH = 6;
	private final static int TR_ID_REQ_TM_LENGTH = 8;
	private final static int TR_ID_SEQ_LENGTH = 2;
	private final static int LNKG_SNO_LENGTH = 3;
	private final static int OG_TR_ID_LENGTH = 27;
	private final static int INP_TLG_RCVG_DT_LENGTH = 8;
	private final static int INP_TLG_RCVG_DTL_TM_LENGTH = 8;
	private final static int POUT_TLG_TRN_DT_LENGTH = 8;
	private final static int POUT_TLG_TRN_DTL_TM_LENGTH = 8;
	private final static int CD_VL_STUP_DSCD_LENGTH = 1;
	private final static int SYNC_DSCD_LENGTH = 1;
	private final static int ASYNC_TPCD_LENGTH = 1;
	private final static int RSP_TPCD_LENGTH = 1;
	private final static int TLG_POUT_TPCD_LENGTH = 1;
	private final static int NXT_TR_YN_LENGTH = 1;
	private final static int LQ_POUT_SNO_LENGTH = 8;
	private final static int TMNL_IP_LENGTH = 15;
	private final static int TMNL_NO_LENGTH = 8;
	private final static int TMNL_TPCD_LENGTH = 1;
	private final static int MCI_SRV_ID_LENGTH = 10;
	private final static int MCI_RQS_DT_LENGTH = 8;
	private final static int MCI_RQS_DTL_TM_LENGTH = 8;
	private final static int EAI_LNKN_ID_LENGTH = 20;
	private final static int EAI_RCV_PGM_ID_LENGTH = 20;
	private final static int EAI_TRN_PGM_ID_LENGTH = 20;
	private final static int EAI_TRN_BZ_TPCD_LENGTH = 1;
	private final static int EAI_RCV_BZ_TPCD_LENGTH = 1;
	private final static int EAI_LNKN_TPCD_LENGTH = 1;
	private final static int OSD_RQS_CHNL_CD_LENGTH = 3;
	private final static int OSD_INCD_LENGTH = 4;
	private final static int OSD_TLG_ID_LENGTH = 32;
	private final static int OSD_TR_ID_LENGTH = 32;
	private final static int OSD_SRV_NOD_NO_LENGTH = 1;
	private final static int TR_RQS_CHNL_CD_LENGTH = 3;
	private final static int OG_TR_RQS_CHNL_CD_LENGTH = 3;
	private final static int TR_PRCS_RSL_CD_LENGTH = 1;
	private final static int XA_TR_DSCD_LENGTH = 1;
	private final static int OG_TR_CD_LENGTH = 11;
	private final static int RESERVED1_LENGTH = 29;

	public final static int LENGTH = STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH
			+ ITN_INCD_LENGTH + TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
			+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH
			+ TR_ID_REQ_TM_LENGTH + TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH
			+ OG_TR_ID_LENGTH + INP_TLG_RCVG_DT_LENGTH
			+ INP_TLG_RCVG_DTL_TM_LENGTH + POUT_TLG_TRN_DT_LENGTH
			+ POUT_TLG_TRN_DTL_TM_LENGTH + CD_VL_STUP_DSCD_LENGTH
			+ SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
			+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH + LQ_POUT_SNO_LENGTH
			+ TMNL_IP_LENGTH + TMNL_NO_LENGTH + TMNL_TPCD_LENGTH
			+ MCI_SRV_ID_LENGTH + MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
			+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
			+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
			+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
			+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH + OSD_TLG_ID_LENGTH
			+ OSD_TR_ID_LENGTH + OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
			+ OG_TR_RQS_CHNL_CD_LENGTH + TR_PRCS_RSL_CD_LENGTH
			+ XA_TR_DSCD_LENGTH + OG_TR_CD_LENGTH + RESERVED1_LENGTH;

	private int stndTlgThwhLen;
	private String tlgDscd;
	private String itnIncd = "KSF";
	private String trCd;
	private String scrnNo;
	private String sysDscd;
	private String trIdChCode = "IBS";
	private String trIdPid;
	private String trIdReqDt;
	private String trIdReqTm;
	private String trIdSeq;
	private String lnkgSno;
	private String ogTrId;
	private String inpTlgRcvgDt;
	private String inpTlgRcvgDtlTm;
	private String poutTlgTrnDt;
	private String poutTlgTrnDtlTm;
	private int cdVlStupDscd;
	private String syncDscd;
	private String asyncTpcd;
	private int rspTpcd;
	private int tlgPoutTpcd;
	private int nxtTrYn;
	private String lqPoutSno;
	private String tmnlIp;
	private String tmnlNo;
	private String tmnlTpcd;
	private String mciSrvId;
	private String mciRqsDt;
	private String mciRqsDtlTm;
	private String eaiLnknId;
	private String eaiRcvPgmId;
	private String eaiTrnPgmId;
	private String eaiTrnBzTpcd;
	private String eaiRcvBzTpcd;
	private String eaiLnknTpcd;
	private String osdRqsChnlCd;
	private String osdIncd;
	private String osdTlgId;
	private String osdTrId;
	private String osdSrvNodNo;
	private String trRqsChnlCd;
	private String ogTrRqsChnlCd;
	private int trPrcsRslCd;
	private String xaTrDscd;
	private String ogTrCd;
	private String reserved1;
	private final String charsetName = "EUC-KR";

	public int getStndTlgThwhLen() {
		return stndTlgThwhLen;
	}

	public void setStndTlgThwhLen(int stndTlgThwhLen) {
		this.stndTlgThwhLen = stndTlgThwhLen;
	}

	public String getTlgDscd() {
		return tlgDscd;
	}

	public void setTlgDscd(String tlgDscd) {
		this.tlgDscd = tlgDscd;
	}

	public String getItnIncd() {
		return itnIncd;
	}

	public void setItnIncd(String itnIncd) {
		this.itnIncd = itnIncd;
	}

	public String getTrCd() {
		return trCd;
	}

	public void setTrCd(String trCd) {
		this.trCd = trCd;
	}

	public String getScrnNo() {
		return scrnNo;
	}

	public void setScrnNo(String scrnNo) {
		this.scrnNo = scrnNo;
	}

	public String getSysDscd() {
		return sysDscd;
	}

	public void setSysDscd(String sysDscd) {
		this.sysDscd = sysDscd;
	}

	public String getTrIdChCode() {
		return trIdChCode;
	}

	public void setTrIdChCode(String trIdChCode) {
		this.trIdChCode = trIdChCode;
	}

	public String getTrIdPid() {
		return trIdPid;
	}

	public void setTrIdPid(String trIdPid) {
		this.trIdPid = trIdPid;
	}

	public String getTrIdReqDt() {
		return trIdReqDt;
	}

	public void setTrIdReqDt(String trIdReqDt) {
		this.trIdReqDt = trIdReqDt;
	}

	public String getTrIdReqTm() {
		return trIdReqTm;
	}

	public void setTrIdReqTm(String trIdReqTm) {
		this.trIdReqTm = trIdReqTm;
	}

	public String getTrIdSeq() {
		return trIdSeq;
	}

	public void setTrIdSeq(String trIdSeq) {
		this.trIdSeq = trIdSeq;
	}

	public String getLnkgSno() {
		return lnkgSno;
	}

	public void setLnkgSno(String lnkgSno) {
		this.lnkgSno = lnkgSno;
	}

	public String getOgTrId() {
		return ogTrId;
	}

	public void setOgTrId(String ogTrId) {
		this.ogTrId = ogTrId;
	}

	public String getInpTlgRcvgDt() {
		return inpTlgRcvgDt;
	}

	public void setInpTlgRcvgDt(String inpTlgRcvgDt) {
		this.inpTlgRcvgDt = inpTlgRcvgDt;
	}

	public String getInpTlgRcvgDtlTm() {
		return inpTlgRcvgDtlTm;
	}

	public void setInpTlgRcvgDtlTm(String inpTlgRcvgDtlTm) {
		this.inpTlgRcvgDtlTm = inpTlgRcvgDtlTm;
	}

	public String getPoutTlgTrnDt() {
		return poutTlgTrnDt;
	}

	public void setPoutTlgTrnDt(String poutTlgTrnDt) {
		this.poutTlgTrnDt = poutTlgTrnDt;
	}

	public String getPoutTlgTrnDtlTm() {
		return poutTlgTrnDtlTm;
	}

	public void setPoutTlgTrnDtlTm(String poutTlgTrnDtlTm) {
		this.poutTlgTrnDtlTm = poutTlgTrnDtlTm;
	}

	public int getCdVlStupDscd() {
		return cdVlStupDscd;
	}

	public void setCdVlStupDscd(int cdVlStupDscd) {
		this.cdVlStupDscd = cdVlStupDscd;
	}

	public String getSyncDscd() {
		return syncDscd;
	}

	public void setSyncDscd(String syncDscd) {
		this.syncDscd = syncDscd;
	}

	public String getAsyncTpcd() {
		return asyncTpcd;
	}

	public void setAsyncTpcd(String asyncTpcd) {
		this.asyncTpcd = asyncTpcd;
	}

	public int getRspTpcd() {
		return rspTpcd;
	}

	public void setRspTpcd(int rspTpcd) {
		this.rspTpcd = rspTpcd;
	}

	public int getTlgPoutTpcd() {
		return tlgPoutTpcd;
	}

	public void setTlgPoutTpcd(int tlgPoutTpcd) {
		this.tlgPoutTpcd = tlgPoutTpcd;
	}

	public int getNxtTrYn() {
		return nxtTrYn;
	}

	public void setNxtTrYn(int nxtTrYn) {
		this.nxtTrYn = nxtTrYn;
	}

	public String getLqPoutSno() {
		return lqPoutSno;
	}

	public void setLqPoutSno(String lqPoutSno) {
		this.lqPoutSno = lqPoutSno;
	}

	public String getTmnlIp() {
		return tmnlIp;
	}

	public void setTmnlIp(String tmnlIp) {
		this.tmnlIp = tmnlIp;
	}

	public String getTmnlNo() {
		return tmnlNo;
	}

	public void setTmnlNo(String tmnlNo) {
		this.tmnlNo = tmnlNo;
	}

	public String getTmnlTpcd() {
		return tmnlTpcd;
	}

	public void setTmnlTpcd(String tmnlTpcd) {
		this.tmnlTpcd = tmnlTpcd;
	}

	public String getMciSrvId() {
		return mciSrvId;
	}

	public void setMciSrvId(String mciSrvId) {
		this.mciSrvId = mciSrvId;
	}

	public String getMciRqsDt() {
		return mciRqsDt;
	}

	public void setMciRqsDt(String mciRqsDt) {
		this.mciRqsDt = mciRqsDt;
	}

	public String getMciRqsDtlTm() {
		return mciRqsDtlTm;
	}

	public void setMciRqsDtlTm(String mciRqsDtlTm) {
		this.mciRqsDtlTm = mciRqsDtlTm;
	}

	public String getEaiLnknId() {
		return eaiLnknId;
	}

	public void setEaiLnknId(String eaiLnknId) {
		this.eaiLnknId = eaiLnknId;
	}

	public String getEaiRcvPgmId() {
		return eaiRcvPgmId;
	}

	public void setEaiRcvPgmId(String eaiRcvPgmId) {
		this.eaiRcvPgmId = eaiRcvPgmId;
	}

	public String getEaiTrnPgmId() {
		return eaiTrnPgmId;
	}

	public void setEaiTrnPgmId(String eaiTrnPgmId) {
		this.eaiTrnPgmId = eaiTrnPgmId;
	}

	public String getEaiTrnBzTpcd() {
		return eaiTrnBzTpcd;
	}

	public void setEaiTrnBzTpcd(String eaiTrnBzTpcd) {
		this.eaiTrnBzTpcd = eaiTrnBzTpcd;
	}

	public String getEaiRcvBzTpcd() {
		return eaiRcvBzTpcd;
	}

	public void setEaiRcvBzTpcd(String eaiRcvBzTpcd) {
		this.eaiRcvBzTpcd = eaiRcvBzTpcd;
	}

	public String getEaiLnknTpcd() {
		return eaiLnknTpcd;
	}

	public void setEaiLnknTpcd(String eaiLnknTpcd) {
		this.eaiLnknTpcd = eaiLnknTpcd;
	}

	public String getOsdRqsChnlCd() {
		return osdRqsChnlCd;
	}

	public void setOsdRqsChnlCd(String osdRqsChnlCd) {
		this.osdRqsChnlCd = osdRqsChnlCd;
	}

	public String getOsdIncd() {
		return osdIncd;
	}

	public void setOsdIncd(String osdIncd) {
		this.osdIncd = osdIncd;
	}

	public String getOsdTlgId() {
		return osdTlgId;
	}

	public void setOsdTlgId(String osdTlgId) {
		this.osdTlgId = osdTlgId;
	}

	public String getOsdTrId() {
		return osdTrId;
	}

	public void setOsdTrId(String osdTrId) {
		this.osdTrId = osdTrId;
	}

	public String getOsdSrvNodNo() {
		return osdSrvNodNo;
	}

	public void setOsdSrvNodNo(String osdSrvNodNo) {
		this.osdSrvNodNo = osdSrvNodNo;
	}

	public String getTrRqsChnlCd() {
		return trRqsChnlCd;
	}

	public void setTrRqsChnlCd(String trRqsChnlCd) {
		this.trRqsChnlCd = trRqsChnlCd;
	}

	public String getOgTrRqsChnlCd() {
		return ogTrRqsChnlCd;
	}

	public void setOgTrRqsChnlCd(String ogTrRqsChnlCd) {
		this.ogTrRqsChnlCd = ogTrRqsChnlCd;
	}

	public int getTrPrcsRslCd() {
		return trPrcsRslCd;
	}

	public void setTrPrcsRslCd(int trPrcsRslCd) {
		this.trPrcsRslCd = trPrcsRslCd;
	}

	public String getXaTrDscd() {
		return xaTrDscd;
	}

	public void setXaTrDscd(String xaTrDscd) {
		this.xaTrDscd = xaTrDscd;
	}

	public String getOgTrCd() {
		return ogTrCd;
	}

	public void setOgTrCd(String ogTrCd) {
		this.ogTrCd = ogTrCd;
	}

	public String getReserved1() {
		return reserved1;
	}

	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	public byte[] toBytes() throws Exception {
		byte[] destBytes = new byte[LENGTH];
		IOUtil.bytecopy(this.getStndTlgThwhLen(), destBytes, 0,
				STND_TLG_THWH_LEN_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTlgDscd(), destBytes, STND_TLG_THWH_LEN_LENGTH,
				TLG_DSCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getItnIncd(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH, ITN_INCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTrCd(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH, TR_CD_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getScrnNo(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH,
				SCRN_NO_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getSysDscd(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH, SYS_DSCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTrIdChCode(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH,
				TR_ID_CH_CODE_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTrIdPid(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH,
				TR_ID_PID_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTrIdReqDt(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH,
				TR_ID_REQ_DT_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTrIdReqTm(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH, TR_ID_REQ_TM_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getTrIdSeq(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH,
				TR_ID_SEQ_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getLnkgSno(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH, LNKG_SNO_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getOgTrId(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH, OG_TR_ID_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getInpTlgRcvgDt(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH,
				INP_TLG_RCVG_DT_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getInpTlgRcvgDtlTm(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH, INP_TLG_RCVG_DTL_TM_LENGTH,
				' ', charsetName);
		IOUtil.bytecopy(this.getPoutTlgTrnDt(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH,
				POUT_TLG_TRN_DT_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getPoutTlgTrnDtlTm(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH, POUT_TLG_TRN_DTL_TM_LENGTH,
				' ', charsetName);
		IOUtil.bytecopy(this.getCdVlStupDscd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH,
				CD_VL_STUP_DSCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getSyncDscd(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH, SYNC_DSCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getAsyncTpcd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH,
				ASYNC_TPCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getRspTpcd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH, RSP_TPCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTlgPoutTpcd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH,
				TLG_POUT_TPCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getNxtTrYn(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH, NXT_TR_YN_LENGTH,
				' ', charsetName);
		IOUtil.bytecopy(this.getLqPoutSno(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH,
				LQ_POUT_SNO_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTmnlIp(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH, TMNL_IP_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTmnlNo(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH, TMNL_NO_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getTmnlTpcd(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH,
				TMNL_TPCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getMciSrvId(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
				+ TMNL_TPCD_LENGTH, MCI_SRV_ID_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getMciRqsDt(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
				+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH, MCI_RQS_DT_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getMciRqsDtlTm(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH, MCI_RQS_DTL_TM_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getEaiLnknId(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH,
				EAI_LNKN_ID_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getEaiRcvPgmId(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH, EAI_RCV_PGM_ID_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getEaiTrnPgmId(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH,
				EAI_TRN_PGM_ID_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getEaiTrnBzTpcd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH, EAI_TRN_BZ_TPCD_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getEaiRcvBzTpcd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH,
				EAI_RCV_BZ_TPCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getEaiLnknTpcd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH, EAI_LNKN_TPCD_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getOsdRqsChnlCd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH,
				OSD_RQS_CHNL_CD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getOsdIncd(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
				+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH + MCI_RQS_DT_LENGTH
				+ MCI_RQS_DTL_TM_LENGTH + EAI_LNKN_ID_LENGTH
				+ EAI_RCV_PGM_ID_LENGTH + EAI_TRN_PGM_ID_LENGTH
				+ EAI_TRN_BZ_TPCD_LENGTH + EAI_RCV_BZ_TPCD_LENGTH
				+ EAI_LNKN_TPCD_LENGTH + OSD_RQS_CHNL_CD_LENGTH,
				OSD_INCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getOsdTlgId(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
				+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH + MCI_RQS_DT_LENGTH
				+ MCI_RQS_DTL_TM_LENGTH + EAI_LNKN_ID_LENGTH
				+ EAI_RCV_PGM_ID_LENGTH + EAI_TRN_PGM_ID_LENGTH
				+ EAI_TRN_BZ_TPCD_LENGTH + EAI_RCV_BZ_TPCD_LENGTH
				+ EAI_LNKN_TPCD_LENGTH + OSD_RQS_CHNL_CD_LENGTH
				+ OSD_INCD_LENGTH, OSD_TLG_ID_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getOsdTrId(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
				+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH + MCI_RQS_DT_LENGTH
				+ MCI_RQS_DTL_TM_LENGTH + EAI_LNKN_ID_LENGTH
				+ EAI_RCV_PGM_ID_LENGTH + EAI_TRN_PGM_ID_LENGTH
				+ EAI_TRN_BZ_TPCD_LENGTH + EAI_RCV_BZ_TPCD_LENGTH
				+ EAI_LNKN_TPCD_LENGTH + OSD_RQS_CHNL_CD_LENGTH
				+ OSD_INCD_LENGTH + OSD_TLG_ID_LENGTH, OSD_TR_ID_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getOsdSrvNodNo(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH,
				OSD_SRV_NOD_NO_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTrRqsChnlCd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH, TR_RQS_CHNL_CD_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getOgTrRqsChnlCd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH,
				OG_TR_RQS_CHNL_CD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getTrPrcsRslCd(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
						+ OG_TR_RQS_CHNL_CD_LENGTH, TR_PRCS_RSL_CD_LENGTH, ' ',
				charsetName);
		IOUtil.bytecopy(this.getXaTrDscd(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
				+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH + MCI_RQS_DT_LENGTH
				+ MCI_RQS_DTL_TM_LENGTH + EAI_LNKN_ID_LENGTH
				+ EAI_RCV_PGM_ID_LENGTH + EAI_TRN_PGM_ID_LENGTH
				+ EAI_TRN_BZ_TPCD_LENGTH + EAI_RCV_BZ_TPCD_LENGTH
				+ EAI_LNKN_TPCD_LENGTH + OSD_RQS_CHNL_CD_LENGTH
				+ OSD_INCD_LENGTH + OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
				+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
				+ OG_TR_RQS_CHNL_CD_LENGTH + TR_PRCS_RSL_CD_LENGTH,
				XA_TR_DSCD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getOgTrCd(), destBytes, STND_TLG_THWH_LEN_LENGTH
				+ TLG_DSCD_LENGTH + ITN_INCD_LENGTH + TR_CD_LENGTH
				+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH + TR_ID_CH_CODE_LENGTH
				+ TR_ID_PID_LENGTH + TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
				+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
				+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
				+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
				+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH + ASYNC_TPCD_LENGTH
				+ RSP_TPCD_LENGTH + TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
				+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
				+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH + MCI_RQS_DT_LENGTH
				+ MCI_RQS_DTL_TM_LENGTH + EAI_LNKN_ID_LENGTH
				+ EAI_RCV_PGM_ID_LENGTH + EAI_TRN_PGM_ID_LENGTH
				+ EAI_TRN_BZ_TPCD_LENGTH + EAI_RCV_BZ_TPCD_LENGTH
				+ EAI_LNKN_TPCD_LENGTH + OSD_RQS_CHNL_CD_LENGTH
				+ OSD_INCD_LENGTH + OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
				+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
				+ OG_TR_RQS_CHNL_CD_LENGTH + TR_PRCS_RSL_CD_LENGTH
				+ XA_TR_DSCD_LENGTH, OG_TR_CD_LENGTH, ' ', charsetName);
		IOUtil.bytecopy(this.getReserved1(), destBytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
						+ OG_TR_RQS_CHNL_CD_LENGTH + TR_PRCS_RSL_CD_LENGTH
						+ XA_TR_DSCD_LENGTH + OG_TR_CD_LENGTH,
				RESERVED1_LENGTH, ' ', charsetName);

		return destBytes;
	}

	public void fromBytes(byte[] bytes) throws Exception {
		setStndTlgThwhLen(Integer.parseInt(IOUtil.substr(bytes, 0,
				STND_TLG_THWH_LEN_LENGTH, charsetName).trim()));
		setTlgDscd(IOUtil.substr(bytes, STND_TLG_THWH_LEN_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH, charsetName).trim());
		setItnIncd(IOUtil.substr(bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH,
				charsetName).trim());
		setTrCd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH, charsetName).trim());
		setScrnNo(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH, charsetName).trim());
		setSysDscd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH,
				charsetName).trim());
		setTrIdChCode(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH, charsetName).trim());
		setTrIdPid(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH, charsetName)
				.trim());
		setTrIdReqDt(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH, charsetName).trim());
		setTrIdReqTm(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH,
				charsetName).trim());
		setTrIdSeq(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH, charsetName).trim());
		setLnkgSno(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_SEQ_LENGTH
						+ TR_ID_REQ_TM_LENGTH + LNKG_SNO_LENGTH, charsetName)
				.trim());
		setOgTrId(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH,
				charsetName).trim());
		setInpTlgRcvgDt(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH, charsetName).trim());
		setInpTlgRcvgDtlTm(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH,
				charsetName).trim());
		setPoutTlgTrnDt(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH, charsetName).trim());
		setPoutTlgTrnDtlTm(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH,
				charsetName).trim());
		setCdVlStupDscd(Integer.parseInt(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH, charsetName).trim()));
		setSyncDscd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH,
				charsetName).trim());
		setAsyncTpcd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH, charsetName).trim());
		setRspTpcd(Integer.parseInt(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH, charsetName)
				.trim()));
		setTlgPoutTpcd(Integer.parseInt(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH, charsetName).trim()));
		setNxtTrYn(Integer.parseInt(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH, charsetName)
				.trim()));
		setLqPoutSno(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH, charsetName).trim());
		setTmnlIp(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH, charsetName)
				.trim());
		setTmnlNo(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH,
				charsetName).trim());
		setTmnlTpcd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH, charsetName).trim());
		setMciSrvId(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH, charsetName)
				.trim());
		setMciRqsDt(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH, charsetName).trim());
		setMciRqsDtlTm(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH,
				charsetName).trim());
		setEaiLnknId(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH, charsetName).trim());
		setEaiRcvPgmId(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH,
				charsetName).trim());
		setEaiTrnPgmId(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH, charsetName).trim());
		setEaiTrnBzTpcd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH,
				charsetName).trim());
		setEaiRcvBzTpcd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH, charsetName).trim());
		setEaiLnknTpcd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH,
				charsetName).trim());
		setOsdRqsChnlCd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH, charsetName).trim());
		setOsdIncd(IOUtil
				.substr(
						bytes,
						STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH
								+ ITN_INCD_LENGTH + TR_CD_LENGTH
								+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH
								+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
								+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
								+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH
								+ OG_TR_ID_LENGTH + INP_TLG_RCVG_DT_LENGTH
								+ INP_TLG_RCVG_DTL_TM_LENGTH
								+ POUT_TLG_TRN_DT_LENGTH
								+ POUT_TLG_TRN_DTL_TM_LENGTH
								+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
								+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
								+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
								+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH
								+ TMNL_NO_LENGTH + TMNL_TPCD_LENGTH
								+ MCI_SRV_ID_LENGTH + MCI_RQS_DT_LENGTH
								+ MCI_RQS_DTL_TM_LENGTH + EAI_LNKN_ID_LENGTH
								+ EAI_RCV_PGM_ID_LENGTH + EAI_TRN_PGM_ID_LENGTH
								+ EAI_TRN_BZ_TPCD_LENGTH
								+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
								+ OSD_RQS_CHNL_CD_LENGTH,
						STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH
								+ ITN_INCD_LENGTH + TR_CD_LENGTH
								+ SCRN_NO_LENGTH + SYS_DSCD_LENGTH
								+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
								+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
								+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH
								+ OG_TR_ID_LENGTH + INP_TLG_RCVG_DT_LENGTH
								+ INP_TLG_RCVG_DTL_TM_LENGTH
								+ POUT_TLG_TRN_DT_LENGTH
								+ POUT_TLG_TRN_DTL_TM_LENGTH
								+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
								+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
								+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
								+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH
								+ TMNL_NO_LENGTH + TMNL_TPCD_LENGTH
								+ MCI_SRV_ID_LENGTH + MCI_RQS_DT_LENGTH
								+ MCI_RQS_DTL_TM_LENGTH + EAI_LNKN_ID_LENGTH
								+ EAI_RCV_PGM_ID_LENGTH + EAI_TRN_PGM_ID_LENGTH
								+ EAI_TRN_BZ_TPCD_LENGTH
								+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
								+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH,
						charsetName).trim());
		setOsdTlgId(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH, charsetName).trim());
		setOsdTrId(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH, charsetName)
				.trim());
		setOsdSrvNodNo(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH, charsetName).trim());
		setTrRqsChnlCd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH,
				charsetName).trim());
		setOgTrRqsChnlCd(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
						+ OG_TR_RQS_CHNL_CD_LENGTH, charsetName).trim());
		setTrPrcsRslCd(Integer.parseInt(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
						+ OG_TR_RQS_CHNL_CD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
						+ OG_TR_RQS_CHNL_CD_LENGTH + TR_PRCS_RSL_CD_LENGTH,
				charsetName).trim()));
		setReserved1(IOUtil.substr(
				bytes,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
						+ OG_TR_RQS_CHNL_CD_LENGTH + TR_PRCS_RSL_CD_LENGTH,
				STND_TLG_THWH_LEN_LENGTH + TLG_DSCD_LENGTH + ITN_INCD_LENGTH
						+ TR_CD_LENGTH + SCRN_NO_LENGTH + SYS_DSCD_LENGTH
						+ TR_ID_CH_CODE_LENGTH + TR_ID_PID_LENGTH
						+ TR_ID_REQ_DT_LENGTH + TR_ID_REQ_TM_LENGTH
						+ TR_ID_SEQ_LENGTH + LNKG_SNO_LENGTH + OG_TR_ID_LENGTH
						+ INP_TLG_RCVG_DT_LENGTH + INP_TLG_RCVG_DTL_TM_LENGTH
						+ POUT_TLG_TRN_DT_LENGTH + POUT_TLG_TRN_DTL_TM_LENGTH
						+ CD_VL_STUP_DSCD_LENGTH + SYNC_DSCD_LENGTH
						+ ASYNC_TPCD_LENGTH + RSP_TPCD_LENGTH
						+ TLG_POUT_TPCD_LENGTH + NXT_TR_YN_LENGTH
						+ LQ_POUT_SNO_LENGTH + TMNL_IP_LENGTH + TMNL_NO_LENGTH
						+ TMNL_TPCD_LENGTH + MCI_SRV_ID_LENGTH
						+ MCI_RQS_DT_LENGTH + MCI_RQS_DTL_TM_LENGTH
						+ EAI_LNKN_ID_LENGTH + EAI_RCV_PGM_ID_LENGTH
						+ EAI_TRN_PGM_ID_LENGTH + EAI_TRN_BZ_TPCD_LENGTH
						+ EAI_RCV_BZ_TPCD_LENGTH + EAI_LNKN_TPCD_LENGTH
						+ OSD_RQS_CHNL_CD_LENGTH + OSD_INCD_LENGTH
						+ OSD_TLG_ID_LENGTH + OSD_TR_ID_LENGTH
						+ OSD_SRV_NOD_NO_LENGTH + TR_RQS_CHNL_CD_LENGTH
						+ OG_TR_RQS_CHNL_CD_LENGTH + TR_PRCS_RSL_CD_LENGTH
						+ RESERVED1_LENGTH, charsetName).trim());
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

		retValue.append("SystemHeaderDTO ( ").append(super.toString()).append(
				TAB).append("asyncTpcd = ").append(this.asyncTpcd).append(TAB)
				.append("cdVlStupDscd = ").append(this.cdVlStupDscd)
				.append(TAB).append("eaiLnknId = ").append(this.eaiLnknId)
				.append(TAB).append("eaiLnknTpcd = ").append(this.eaiLnknTpcd)
				.append(TAB).append("eaiRcvBzTpcd = ")
				.append(this.eaiRcvBzTpcd).append(TAB).append("eaiRcvPgmId = ")
				.append(this.eaiRcvPgmId).append(TAB).append("eaiTrnBzTpcd = ")
				.append(this.eaiTrnBzTpcd).append(TAB).append("eaiTrnPgmId = ")
				.append(this.eaiTrnPgmId).append(TAB).append("inpTlgRcvgDt = ")
				.append(this.inpTlgRcvgDt).append(TAB).append(
						"inpTlgRcvgDtlTm = ").append(this.inpTlgRcvgDtlTm)
				.append(TAB).append("itnIncd = ").append(this.itnIncd).append(
						TAB).append("lnkgSno = ").append(this.lnkgSno).append(
						TAB).append("lqPoutSno = ").append(this.lqPoutSno)
				.append(TAB).append("mciRqsDt = ").append(this.mciRqsDt)
				.append(TAB).append("mciRqsDtlTm = ").append(this.mciRqsDtlTm)
				.append(TAB).append("mciSrvId = ").append(this.mciSrvId)
				.append(TAB).append("nxtTrYn = ").append(this.nxtTrYn).append(
						TAB).append("ogTrCd = ").append(this.ogTrCd)
				.append(TAB).append("ogTrId = ").append(this.ogTrId)
				.append(TAB).append("ogTrRqsChnlCd = ").append(
						this.ogTrRqsChnlCd).append(TAB).append("osdIncd = ")
				.append(this.osdIncd).append(TAB).append("osdRqsChnlCd = ")
				.append(this.osdRqsChnlCd).append(TAB).append("osdSrvNodNo = ")
				.append(this.osdSrvNodNo).append(TAB).append("osdTlgId = ")
				.append(this.osdTlgId).append(TAB).append("osdTrId = ").append(
						this.osdTrId).append(TAB).append("poutTlgTrnDt = ")
				.append(this.poutTlgTrnDt).append(TAB).append(
						"poutTlgTrnDtlTm = ").append(this.poutTlgTrnDtlTm)
				.append(TAB).append("reserved1 = ").append(this.reserved1)
				.append(TAB).append("rspTpcd = ").append(this.rspTpcd).append(
						TAB).append("scrnNo = ").append(this.scrnNo)
				.append(TAB).append("stndTlgThwhLen = ").append(
						this.stndTlgThwhLen).append(TAB).append("syncDscd = ")
				.append(this.syncDscd).append(TAB).append("sysDscd = ").append(
						this.sysDscd).append(TAB).append("tlgDscd = ").append(
						this.tlgDscd).append(TAB).append("tlgPoutTpcd = ")
				.append(this.tlgPoutTpcd).append(TAB).append("tmnlIp = ")
				.append(this.tmnlIp).append(TAB).append("tmnlNo = ").append(
						this.tmnlNo).append(TAB).append("tmnlTpcd = ").append(
						this.tmnlTpcd).append(TAB).append("trCd = ").append(
						this.trCd).append(TAB).append("trIdChCode = ").append(
						this.trIdChCode).append(TAB).append("trIdPid = ")
				.append(this.trIdPid).append(TAB).append("trIdReqDt = ")
				.append(this.trIdReqDt).append(TAB).append("trIdReqTm = ")
				.append(this.trIdReqTm).append(TAB).append("trIdSeq = ")
				.append(this.trIdSeq).append(TAB).append("trPrcsRslCd = ")
				.append(this.trPrcsRslCd).append(TAB).append("trRqsChnlCd = ")
				.append(this.trRqsChnlCd).append(TAB).append("xaTrDscd = ")
				.append(this.xaTrDscd).append(TAB).append(" )");

		return retValue.toString();
	}
}