package org.codelabor.example.banking.bank.managers;

import java.util.List;

import org.codelabor.example.banking.bank.dtos.BankDTO;

public interface BankManager {
	public List<BankDTO> getBankList() throws Exception;

	public BankDTO getBank(String code) throws Exception;

	public List<BankDTO> getUnavailableBankList() throws Exception;

	public List<BankDTO> getAvailableBankList() throws Exception;
}
