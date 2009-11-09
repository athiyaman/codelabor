package org.codelabor.example.integration.mci.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.example.remoting.message.dtos.KsfcHeaderDTO;
import org.codelabor.example.remoting.message.dtos.Saaa001001rInputDTO;
import org.codelabor.example.remoting.message.dtos.Saaa001001rOutputDTO;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.codelabor.system.remoting.message.dtos.MessageHeaderDTO;
import org.codelabor.system.remoting.message.dtos.SystemHeaderDTO;
import org.codelabor.system.remoting.message.dtos.TransactionHeaderDTO;
import org.codelabor.system.services.BaseServiceImpl;

public class FinancialServiceImpl extends BaseServiceImpl implements
		FinancialService {

	@SuppressWarnings("unused")
	private final Log log = LogFactory.getLog(FinancialServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List search(Date fromDate, Date toDate) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale
				.getDefault());

		// input data
		Saaa001001rInputDTO inputData = new Saaa001001rInputDTO();
		String fromDateString = dateFormat.format(fromDate);
		String toDateString = dateFormat.format(toDate);
		inputData.setInqStDt(fromDateString);
		inputData.setInqNdDt(toDateString);

		// prepare header data
		// input header - system header
		SystemHeaderDTO systemHeaderDTO = new SystemHeaderDTO();
		systemHeaderDTO.setTrCd("SAAA001001R");
		systemHeaderDTO.setScrnNo("10000100");
		// systemHeaderDTO.setSysDscd("UA");
		// systemHeaderDTO.setTrIdChCode("IUS");
		// systemHeaderDTO.setTrIdPid("ep133000");
		// systemHeaderDTO.setTrIdReqDt("09081815");
		// systemHeaderDTO.setTrIdReqTm("15332237");
		// systemHeaderDTO.setTrIdSeq("06");
		systemHeaderDTO.setLnkgSno("000");
		// systemHeaderDTO.setOgTrId("IUSep1330000908181533223706");
		// systemHeaderDTO.setCdVlStupDscd(0);
		// systemHeaderDTO.setSyncDscd("S");
		systemHeaderDTO.setTlgPoutTpcd(0);
		systemHeaderDTO.setNxtTrYn(0);
		systemHeaderDTO.setLqPoutSno("00000000");
		// systemHeaderDTO.setTmnlIp("124.233.17.64");
		systemHeaderDTO.setTmnlTpcd("1");
		systemHeaderDTO.setMciSrvId("DITEAI1_SC");
		systemHeaderDTO.setMciRqsDt("20090818");
		systemHeaderDTO.setMciRqsDtlTm("15331703");
		// systemHeaderDTO.setTrRqsChnlCd("IUS");
		// systemHeaderDTO.setOgTrRqsChnlCd("IUS");
		systemHeaderDTO.setTrPrcsRslCd(0);
		systemHeaderDTO.setOgTrCd("SAAA001001R");

		// input header - transaction header
		TransactionHeaderDTO transactionHeaderDTO = new TransactionHeaderDTO();
		transactionHeaderDTO.setHdbrBdcd("101");
		transactionHeaderDTO.setSctnBdcd("0150");
		transactionHeaderDTO.setTeamBdcd("1100");
		transactionHeaderDTO.setHndEmpno("ep133");
		transactionHeaderDTO.setOptrNm("정준호");
		// transactionHeaderDTO.setLgnYn(1);
		transactionHeaderDTO.setRsprAprvTrObjYn("0");
		transactionHeaderDTO.setCncTlgDscd(0);
		transactionHeaderDTO.setTlgTrTpcd(0);
		transactionHeaderDTO.setSlsDt("20090818");

		// input header - message header
		MessageHeaderDTO messageHeaderDTO = new MessageHeaderDTO();

		// input header
		KsfcHeaderDTO inputHeader = new KsfcHeaderDTO();
		inputHeader.setSystemHeaderDTO(systemHeaderDTO);
		inputHeader.setTransactionHeaderDTO(transactionHeaderDTO);
		inputHeader.setMessageHeaderDTO(messageHeaderDTO);

		// output header
		KsfcHeaderDTO outputHeader = new KsfcHeaderDTO();

		// output data
		Saaa001001rOutputDTO outputData = new Saaa001001rOutputDTO();

		// call
		messageAdapterService.call(inputHeader, inputData, outputHeader,
				outputData);

		if (outputHeader.isError()) {
			messageHeaderDTO = outputHeader.getMessageHeaderDTO();
			String messageCode = messageHeaderDTO.getMsgCd();
			String messageDescription = messageHeaderDTO.getMsgDesc();
			// String messageSupplementCode = messageHeaderDTO.getSplmMsgCd();
			// String messageSupplementDescription = messageHeaderDTO
			// .getSplmMsgDesc();
			throw new RollbackCommonException(this.messageSource, messageCode,
					messageDescription);
		} else {
			return outputData.getSaaa001001rOutstrSub();
		}
	}
}
