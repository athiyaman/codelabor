package org.codelabor.example.banking.customer.services;

import org.codelabor.example.banking.customer.dtos.CustomerDTO;
import org.codelabor.example.banking.customer.managers.CustomerManager;
import org.codelabor.system.banking.SecurityType;
import org.codelabor.system.services.BaseServiceImpl;

public class CustomerServiceMock extends BaseServiceImpl implements CustomerService {

	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

	private CustomerManager customerManager;

	public String getName(String customerId) throws Exception {
		CustomerDTO customerDTO = customerManager.selectCustomer(customerId);
		return customerDTO.getName();
	}

	public SecurityType getSecurityType(String customerId) throws Exception {
		CustomerDTO customerDTO = customerManager.selectCustomer(customerId);
		return customerDTO.getSecurityType();
	}

	public boolean isOTPUser(String customerId) throws Exception {
		if (customerManager.selectCustomer(customerId).getSecurityType() == SecurityType.OTP)
			return true;
		else
			return false;
	}

	public boolean isSecurityCardUser(String customerId) throws Exception {
		if (customerManager.selectCustomer(customerId).getSecurityType() == SecurityType.SECURITY_CARD)
			return true;
		else
			return false;
	}

}
