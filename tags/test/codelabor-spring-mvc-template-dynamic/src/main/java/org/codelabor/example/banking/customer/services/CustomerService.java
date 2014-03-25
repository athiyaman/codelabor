package org.codelabor.example.banking.customer.services;

import org.codelabor.system.banking.SecurityType;

public interface CustomerService {
	public SecurityType getSecurityType(String customerId) throws Exception;

	public String getName(String customerId) throws Exception;

	public boolean isOTPUser(String customerId) throws Exception;

	public boolean isSecurityCardUser(String customerId) throws Exception;
}
