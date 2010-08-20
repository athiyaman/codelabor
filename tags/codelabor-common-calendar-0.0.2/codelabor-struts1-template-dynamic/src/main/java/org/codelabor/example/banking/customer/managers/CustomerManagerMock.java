package org.codelabor.example.banking.customer.managers;

import java.util.ArrayList;
import java.util.List;

import org.codelabor.example.banking.customer.dtos.CustomerDTO;
import org.codelabor.system.banking.InformType;
import org.codelabor.system.banking.SecurityType;
import org.codelabor.system.managers.BaseManagerImpl;

public class CustomerManagerMock extends BaseManagerImpl implements CustomerManager {

	private final List<CustomerDTO> customerDTOList;

	public CustomerManagerMock() {
		customerDTOList = new ArrayList<CustomerDTO>();

		CustomerDTO customer1 = new CustomerDTO();
		customer1.setCustomerId("user1");
		customer1.setName("user1");
		customer1.setSecurityType(SecurityType.OTP);
		customer1.setOtpTokenSerialNumber("11111111");
		List<InformType> informTypes = new ArrayList<InformType>();
		informTypes.add(InformType.SMS);
		informTypes.add(InformType.EMAIL);
		customer1.setInformTypes(informTypes);
		customer1.setSmsCellPhoneNumber("010-1111-1111");

		CustomerDTO customer2 = new CustomerDTO();
		customer2.setCustomerId("user2");
		customer2.setName("user2");
		customer2.setSecurityType(SecurityType.SECURITY_CARD);
		customer2.setSecurityCardSerialNumber("22222222");
		informTypes = new ArrayList<InformType>();
		informTypes.add(InformType.LETTER);
		customer2.setInformTypes(informTypes);
		customer2.setSmsCellPhoneNumber("010-2222-2222");

		customerDTOList.add(customer1);
		customerDTOList.add(customer2);

	}

	public CustomerDTO selectCustomer(String customerId) throws Exception {
		for (CustomerDTO customerDTO : customerDTOList) {
			if (customerDTO.getCustomerId().equals(customerId))
				return customerDTO;
		}
		return null;
	}

	public List<CustomerDTO> selectCustomerList() throws Exception {
		return customerDTOList;
	}
}
