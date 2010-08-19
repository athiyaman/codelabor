package org.codelabor.example.banking.customer.managers;

import java.util.List;

import org.codelabor.example.banking.customer.dtos.CustomerDTO;

public interface CustomerManager {
	public CustomerDTO selectCustomer(String customerId) throws Exception;

	public List<CustomerDTO> selectCustomerList() throws Exception;
}
