package org.codelabor.example.banking.account.managers;

import java.util.List;

import org.codelabor.example.banking.account.dtos.AccountDTO;

public interface AccountManager {
	public List<AccountDTO> getFrequenUsedAccountList(String customerId);

	public List<AccountDTO> getWithdrawalAccountList(String customerId);

	public AccountDTO getWithdrawalAccount(String accountNo);
}
