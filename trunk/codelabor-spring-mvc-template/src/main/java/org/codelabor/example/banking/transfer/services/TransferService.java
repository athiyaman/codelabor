package org.codelabor.example.banking.transfer.services;

import java.util.List;

import org.codelabor.example.banking.transfer.dtos.PasswordDTO;
import org.codelabor.example.banking.transfer.dtos.TransferDTO;

public interface TransferService {
	public TransferDTO createTransfer(String senderId) throws Exception;

	public PasswordDTO createPassword(String senderId) throws Exception;

	public int transfer(TransferDTO transfer) throws Exception;

	public int transfer(List<TransferDTO> transferList) throws Exception;
}
