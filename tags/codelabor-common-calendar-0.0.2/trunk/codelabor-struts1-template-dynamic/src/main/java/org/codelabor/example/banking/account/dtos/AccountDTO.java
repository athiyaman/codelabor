package org.codelabor.example.banking.account.dtos;

import java.io.Serializable;
import java.util.Date;

public class AccountDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -626786559778871841L;

	private String bankCode;
	private String bankName;
	private String customerId;
	private String customerName;
	private String managementBranch;
	private String accountNo;
	private String accountPassword;
	private String nick;
	private String depositType;
	private long currentBalance;
	private long withdrawAvailableAmount;
	private Date openingDate;
	private Date maturityDate;
	private Date lastTransactionDate;
	private boolean incidentReport;
	private boolean pledgeEstablishment;

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getManagementBranch() {
		return managementBranch;
	}

	public void setManagementBranch(String managementBranch) {
		this.managementBranch = managementBranch;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public long getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(long currentBalance) {
		this.currentBalance = currentBalance;
	}

	public long getWithdrawAvailableAmount() {
		return withdrawAvailableAmount;
	}

	public void setWithdrawAvailableAmount(long withdrawAvailableAmount) {
		this.withdrawAvailableAmount = withdrawAvailableAmount;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getLastTransactionDate() {
		return lastTransactionDate;
	}

	public void setLastTransactionDate(Date lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}

	public boolean isIncidentReport() {
		return incidentReport;
	}

	public void setIncidentReport(boolean incidentReport) {
		this.incidentReport = incidentReport;
	}

	public boolean isPledgeEstablishment() {
		return pledgeEstablishment;
	}

	public void setPledgeEstablishment(boolean pledgeEstablishment) {
		this.pledgeEstablishment = pledgeEstablishment;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
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

		retValue.append("AccountDTO ( ").append(super.toString()).append(TAB).append("accountNo = ").append(this.accountNo).append(TAB).append("accountPassword = ").append(this.accountPassword).append(TAB).append("bankCode = ").append(this.bankCode).append(TAB).append("bankName = ").append(
				this.bankName).append(TAB).append("currentBalance = ").append(this.currentBalance).append(TAB).append("customerId = ").append(this.customerId).append(TAB).append("customerName = ").append(this.customerName).append(TAB).append("depositType = ").append(this.depositType).append(TAB)
				.append("incidentReport = ").append(this.incidentReport).append(TAB).append("lastTransactionDate = ").append(this.lastTransactionDate).append(TAB).append("managementBranch = ").append(this.managementBranch).append(TAB).append("maturityDate = ").append(this.maturityDate).append(TAB)
				.append("nick = ").append(this.nick).append(TAB).append("openingDate = ").append(this.openingDate).append(TAB).append("pledgeEstablishment = ").append(this.pledgeEstablishment).append(TAB).append("withdrawAvailableAmount = ").append(this.withdrawAvailableAmount).append(TAB).append(
						" )");

		return retValue.toString();
	}

}
