package org.codelabor.example.banking.account.managers;

import java.util.ArrayList;
import java.util.List;

import org.codelabor.example.banking.account.dtos.AccountDTO;
import org.codelabor.system.managers.BaseManagerImpl;

public class AccountManagerMock extends BaseManagerImpl implements AccountManager {
	private List<AccountDTO> frequenUsedAccountList;
	private List<AccountDTO> withdrawalAccountList;

	public AccountManagerMock() {
		frequenUsedAccountList = new ArrayList();
		withdrawalAccountList = new ArrayList();

		// setup frequenUsedAccountList
		AccountDTO accountDTO1 = new AccountDTO();
		accountDTO1.setAccountNo("111-0000-0000-000");
		AccountDTO accountDTO2 = new AccountDTO();
		accountDTO2.setAccountNo("222-0000-0000-000");
		AccountDTO accountDTO3 = new AccountDTO();
		accountDTO3.setAccountNo("333-0000-0000-000");
		frequenUsedAccountList.add(accountDTO1);
		frequenUsedAccountList.add(accountDTO2);
		frequenUsedAccountList.add(accountDTO3);

		// setup withdrawalAccountList
		accountDTO1 = new AccountDTO();
		accountDTO1.setAccountNo("000-0000-0000-000");
		accountDTO2 = new AccountDTO();
		accountDTO2.setAccountNo("000-0000-0000-001");
		accountDTO3 = new AccountDTO();
		accountDTO3.setAccountNo("000-0000-0000-002");
		withdrawalAccountList.add(accountDTO1);
		withdrawalAccountList.add(accountDTO2);
		withdrawalAccountList.add(accountDTO3);
	}

	public List<AccountDTO> getFrequenUsedAccountList(String customerId) {
		// TODO get list from MCI
		return frequenUsedAccountList;
	}

	public List<AccountDTO> getWithdrawalAccountList(String customerId) {
		// TODO get list from MCI
		return withdrawalAccountList;
	}

	public AccountDTO getWithdrawalAccount(String accountNo) {
		for (AccountDTO accountDTO : withdrawalAccountList) {
			if (accountDTO.getAccountNo().equals(accountNo))
				return accountDTO;
		}
		return null;
	}
}
