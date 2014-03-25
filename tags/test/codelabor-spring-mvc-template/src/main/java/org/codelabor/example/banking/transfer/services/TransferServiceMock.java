package org.codelabor.example.banking.transfer.services;

import java.util.Calendar;
import java.util.List;

import org.codelabor.example.banking.customer.dtos.CustomerDTO;
import org.codelabor.example.banking.customer.managers.CustomerManager;
import org.codelabor.example.banking.transfer.dtos.PasswordDTO;
import org.codelabor.example.banking.transfer.dtos.TransferDTO;
import org.codelabor.system.services.BaseServiceImpl;

public class TransferServiceMock extends BaseServiceImpl implements TransferService {

	private CustomerManager customerManager;

	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

	public TransferDTO createTransfer(String senderId) throws Exception {
		CustomerDTO customerDTO = customerManager.selectCustomer(senderId);
		TransferDTO transferDTO = new TransferDTO();
		transferDTO.setSenderId(senderId);
		transferDTO.setSenderName(customerDTO.getName());
		transferDTO.setExecutionDate(Calendar.getInstance().getTime());
		return transferDTO;
	}

	public PasswordDTO createPassword(String senderId) throws Exception {
		PasswordDTO passwordDTO = new PasswordDTO();
		CustomerDTO customerDTO = customerManager.selectCustomer(senderId);

		switch (customerDTO.getSecurityType()) {
		case OTP:
			passwordDTO.setOtpTokenSerialNumber(customerDTO.getOtpTokenSerialNumber());
			break;
		case SECURITY_CARD:
			passwordDTO.setSecurityCardSerialNumber(customerDTO.getSecurityCardSerialNumber());
			break;
		}
		return passwordDTO;
	}

	public int transfer(TransferDTO transfer) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int transfer(List<TransferDTO> transferList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}