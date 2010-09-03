package org.codelabor.example.banking.transfer.dtos;

import java.io.Serializable;
import java.util.Date;

import org.codelabor.system.banking.CurrencyCode;
import org.codelabor.system.banking.TransferType;

public class TransferDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4504512854094963584L;

	private String senderId;
	private String senderName;
	private String receiverName;

	private String withdrawalAccountNo;
	private String withdrawalAccountMemo;

	private String receivingBankCode;
	private String receivingAccountNo;
	private String receivingAccountMemo;

	private String transferPassword;
	private long fee;
	private long transferAmount;
	private CurrencyCode currencyCode;
	private Date executionDate;
	private TransferType transferType;
	private String cmsNo;

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	public long getFee() {
		return fee;
	}

	public void setFee(long fee) {
		this.fee = fee;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceivingBankCode() {
		return receivingBankCode;
	}

	public void setReceivingBankCode(String receivingBankCode) {
		this.receivingBankCode = receivingBankCode;
	}

	public String getWithdrawalAccountNo() {
		return withdrawalAccountNo;
	}

	public void setWithdrawalAccountNo(String withdrawalAccountNo) {
		this.withdrawalAccountNo = withdrawalAccountNo;
	}

	public String getReceivingAccountNo() {
		return receivingAccountNo;
	}

	public void setReceivingAccountNo(String receivingAccountNo) {
		this.receivingAccountNo = receivingAccountNo;
	}

	public String getTransferPassword() {
		return transferPassword;
	}

	public void setTransferPassword(String transferPassword) {
		this.transferPassword = transferPassword;
	}

	public long getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(long transferAmount) {
		this.transferAmount = transferAmount;
	}

	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public String getWithdrawalAccountMemo() {
		return withdrawalAccountMemo;
	}

	public void setWithdrawalAccountMemo(String memo) {
		this.withdrawalAccountMemo = memo;
	}

	public String getCmsNo() {
		return cmsNo;
	}

	public void setCmsNo(String cmsNo) {
		this.cmsNo = cmsNo;
	}

	public String getReceivingAccountMemo() {
		return receivingAccountMemo;
	}

	public void setReceivingAccountMemo(String receivingAccountMemo) {
		this.receivingAccountMemo = receivingAccountMemo;
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

		retValue.append("TransferDTO ( ").append(super.toString()).append(TAB).append("cmsNo = ").append(this.cmsNo).append(TAB).append("currencyCode = ").append(this.currencyCode).append(TAB).append("executionDate = ").append(this.executionDate).append(TAB).append("fee = ").append(this.fee)
				.append(TAB).append("receiverName = ").append(this.receiverName).append(TAB).append("receivingAccountMemo = ").append(this.receivingAccountMemo).append(TAB).append("receivingAccountNo = ").append(this.receivingAccountNo).append(TAB).append("receivingBankCode = ").append(
						this.receivingBankCode).append(TAB).append("senderId = ").append(this.senderId).append(TAB).append("senderName = ").append(this.senderName).append(TAB).append("transferAmount = ").append(this.transferAmount).append(TAB).append("transferPassword = ").append(
						this.transferPassword).append(TAB).append("transferType = ").append(this.transferType).append(TAB).append("withdrawalAccountMemo = ").append(this.withdrawalAccountMemo).append(TAB).append("withdrawalAccountNo = ").append(this.withdrawalAccountNo).append(TAB).append(" )");

		return retValue.toString();
	}
}
