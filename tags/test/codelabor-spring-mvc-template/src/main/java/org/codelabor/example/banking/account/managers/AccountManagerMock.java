package org.codelabor.example.banking.account.managers;

import java.util.ArrayList;
import java.util.List;

import org.codelabor.example.banking.account.dtos.AccountDTO;
import org.codelabor.system.managers.BaseManagerImpl;

public class AccountManagerMock extends BaseManagerImpl implements AccountManager {
	private List<AccountDTO> frequenUsedAccountList;
	private List<AccountDTO> withdrawalAccountList;

	public AccountManagerMock() {
		frequenUsedAccountList = new ArrayList<AccountDTO>();
		withdrawalAccountList = new ArrayList<AccountDTO>();

		// setup frequenUsedAccountList
		AccountDTO accountDTO1 = new AccountDTO();
		accountDTO1.setAccountNo("111-0000-0000-000");
		accountDTO1.setBankName("우리은행");
		accountDTO1.setCustomerName("삼성래미안 관리사무소");
		accountDTO1.setNick("관리비");

		AccountDTO accountDTO2 = new AccountDTO();
		accountDTO2.setAccountNo("222-0000-0000-000");
		accountDTO2.setBankName("경남은행");
		accountDTO2.setCustomerName("에어보드");
		accountDTO2.setNick("동호회");

		AccountDTO accountDTO3 = new AccountDTO();
		accountDTO3.setAccountNo("333-0000-0000-000");
		accountDTO3.setBankName("광주은행");
		accountDTO3.setCustomerName("월드비전");
		accountDTO3.setNick("기부금");

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

	public List<AccountDTO> getFrequentUsedAccountList(String customerId) {
		return frequenUsedAccountList;
	}

	public List<AccountDTO> getWithdrawalAccountList(String customerId) {
		return withdrawalAccountList;
	}

	public AccountDTO getWithdrawalAccount(String accountNo) {
		for (AccountDTO accountDTO : withdrawalAccountList) {
			if (accountDTO.getAccountNo().equals(accountNo))
				return accountDTO;
		}
		return null;
	}

	public AccountDTO getReceivingAccount(String bankCode, String accountNo) {
		AccountDTO receivingAccount = new AccountDTO();
		receivingAccount.setAccountNo(accountNo);
		receivingAccount.setCustomerName("foo");
		return receivingAccount;
	}
}
