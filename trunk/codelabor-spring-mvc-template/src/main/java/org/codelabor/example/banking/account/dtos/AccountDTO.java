package org.codelabor.example.banking.account.dtos;

import java.io.Serializable;
import java.util.Date;

public class AccountDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -626786559778871841L;

	private String customerId;
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

}
