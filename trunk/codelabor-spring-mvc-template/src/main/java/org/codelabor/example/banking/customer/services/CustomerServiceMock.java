package org.codelabor.example.banking.customer.services;

import org.codelabor.example.banking.customer.dtos.CustomerDTO;
import org.codelabor.example.banking.customer.managers.CustomerManager;
import org.codelabor.system.banking.SecurityType;

public class CustomerServiceMock implements CustomerService {

	private CustomerManager customerManager;

	public String getName(String customerId) throws Exception {
		CustomerDTO customerDTO = customerManager.selectCustomer(customerId);
		return customerDTO.getName();
	}

	public SecurityType getSecurityType(String customerId) throws Exception {
		CustomerDTO customerDTO = customerManager.selectCustomer(customerId);
		return customerDTO.getSecurityType();
	}

}
