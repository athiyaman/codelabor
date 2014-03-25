package org.codelabor.example.remoting.message.dtos;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.codelabor.system.remoting.message.dtos.HeaderDTO;
import org.codelabor.system.remoting.message.dtos.MessageHeaderDTO;
import org.codelabor.system.remoting.message.dtos.SystemHeaderDTO;
import org.codelabor.system.remoting.message.dtos.TransactionHeaderDTO;

public class KsfcHeaderDTO extends HeaderDTO {

	private static final Logger log = Logger.getLogger(KsfcHeaderDTO.class.getName());
	private SystemHeaderDTO systemHeaderDTO;
	private MessageHeaderDTO messageHeaderDTO;
	private TransactionHeaderDTO transactionHeaderDTO;

	public SystemHeaderDTO getSystemHeaderDTO() {
		return systemHeaderDTO;
	}

	public void setSystemHeaderDTO(SystemHeaderDTO systemHeaderDTO) {
		this.systemHeaderDTO = systemHeaderDTO;
	}

	public MessageHeaderDTO getMessageHeaderDTO() {
		return messageHeaderDTO;
	}

	public void setMessageHeaderDTO(MessageHeaderDTO messageHeaderDTO) {
		this.messageHeaderDTO = messageHeaderDTO;
	}

	public TransactionHeaderDTO getTransactionHeaderDTO() {
		return transactionHeaderDTO;
	}

	public void setTransactionHeaderDTO(TransactionHeaderDTO transactionHeaderDTO) {
		this.transactionHeaderDTO = transactionHeaderDTO;
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

		retValue.append("HeaderDTO ( ").append(super.toString()).append(TAB).append("messageHeaderDTO = ").append(this.messageHeaderDTO).append(TAB).append("systemHeaderDTO = ").append(this.systemHeaderDTO).append(TAB).append("transactionHeaderDTO = ").append(this.transactionHeaderDTO).append(TAB)
				.append(" )");

		return retValue.toString();
	}

	@Override
	public byte[] toBytes() throws Exception {
		String systemHeader = new String(systemHeaderDTO.toBytes(), "EUC-KR");
		String transactionHeader = new String(transactionHeaderDTO.toBytes(), "EUC-KR");
		String messageHeader = new String(messageHeaderDTO.toBytes(), "EUC-KR");
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append(System.getProperty("line.separator"));
			sb.append("systemHeader: ").append(systemHeader);
			sb.append(System.getProperty("line.separator"));
			sb.append("transactionHeader: ").append(transactionHeader);
			sb.append(System.getProperty("line.separator"));
			sb.append("messageHeader: ").append(messageHeader);
			sb.append(System.getProperty("line.separator"));
		}
		StringBuilder sb = new StringBuilder();
		sb.append(systemHeader).append(transactionHeader).append(messageHeader);
		return sb.toString().getBytes("EUC-KR");
	}

	@Override
	public void fromBytes(byte[] bytes) throws Exception {
		this.systemHeaderDTO = new SystemHeaderDTO();
		this.systemHeaderDTO.fromBytes(ArrayUtils.subarray(bytes, 0, SystemHeaderDTO.LENGTH));
		this.transactionHeaderDTO = new TransactionHeaderDTO();
		this.transactionHeaderDTO.fromBytes(ArrayUtils.subarray(bytes, SystemHeaderDTO.LENGTH, SystemHeaderDTO.LENGTH + TransactionHeaderDTO.LENGTH));
		this.messageHeaderDTO = new MessageHeaderDTO();
		this.messageHeaderDTO.fromBytes(ArrayUtils.subarray(bytes, SystemHeaderDTO.LENGTH + TransactionHeaderDTO.LENGTH, SystemHeaderDTO.LENGTH + TransactionHeaderDTO.LENGTH + MessageHeaderDTO.LENGTH));

	}

	@Override
	public int getLength() {
		return SystemHeaderDTO.LENGTH + MessageHeaderDTO.LENGTH + TransactionHeaderDTO.LENGTH;
	}

	@Override
	public boolean isError() {
		if (systemHeaderDTO.getTrPrcsRslCd() > 1)
			return true;
		else
			return false;
	}
}
