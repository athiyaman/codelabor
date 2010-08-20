package org.codelabor.example.banking.bank.managers;

import java.util.ArrayList;
import java.util.List;

import org.codelabor.example.banking.bank.dtos.BankDTO;
import org.codelabor.system.managers.BaseManagerImpl;

public class BankManagerMock extends BaseManagerImpl implements BankManager {

	private List<BankDTO> bankList;

	public BankManagerMock() {
		bankList = new ArrayList<BankDTO>();

		BankDTO bankDTO1 = new BankDTO();
		bankDTO1.setCode("001");
		bankDTO1.setName("우리은행");
		bankDTO1.setAvailable(true);

		BankDTO bankDTO2 = new BankDTO();
		bankDTO2.setCode("002");
		bankDTO2.setName("경남은행");
		bankDTO2.setAvailable(true);

		BankDTO bankDTO3 = new BankDTO();
		bankDTO3.setCode("003");
		bankDTO3.setName("광주은행");
		bankDTO3.setAvailable(true);

		BankDTO bankDTO4 = new BankDTO();
		bankDTO4.setCode("004");
		bankDTO4.setName("국민(주택)은행");
		bankDTO4.setAvailable(false);

		BankDTO bankDTO5 = new BankDTO();
		bankDTO5.setCode("005");
		bankDTO5.setName("기업은행");
		bankDTO5.setAvailable(false);

		bankList.add(bankDTO1);
		bankList.add(bankDTO2);
		bankList.add(bankDTO3);
		bankList.add(bankDTO4);
		bankList.add(bankDTO5);
	}

	public BankDTO getBank(String code) throws Exception {
		for (BankDTO bankDTO : bankList) {
			if (bankDTO.getCode().equals(code))
				return bankDTO;
		}
		return null;
	}

	public List<BankDTO> getBankList() throws Exception {
		return bankList;
	}

	public List<BankDTO> getAvailableBankList() throws Exception {
		List<BankDTO> availableBankList = new ArrayList<BankDTO>();
		for (BankDTO bankDTO : bankList) {
			if (bankDTO.isAvailable()) {
				availableBankList.add(bankDTO);
			}
		}
		return availableBankList;
	}

	public List<BankDTO> getUnavailableBankList() throws Exception {
		List<BankDTO> unavailableBankList = new ArrayList<BankDTO>();
		for (BankDTO bankDTO : bankList) {
			if (!bankDTO.isAvailable()) {
				unavailableBankList.add(bankDTO);
			}
		}
		return unavailableBankList;
	}

}
