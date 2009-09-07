package org.codelabor.example.banking.transfer.services;

import java.util.List;

import org.codelabor.example.banking.transfer.dtos.TransferDTO;
import org.codelabor.system.services.BaseServiceImpl;

public class TransferServiceMock extends BaseServiceImpl implements TransferService {

	public TransferDTO createTransfer(String senderId) throws Exception {
		TransferDTO transferDTO = new TransferDTO();
		transferDTO.setSenderId(senderId);
		return transferDTO;
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