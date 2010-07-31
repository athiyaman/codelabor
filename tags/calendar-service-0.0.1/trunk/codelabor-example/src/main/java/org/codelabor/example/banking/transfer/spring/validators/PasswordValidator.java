package org.codelabor.example.banking.transfer.spring.validators;

import org.codelabor.example.banking.transfer.dtos.PasswordDTO;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageResolver;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {
	public void validateEnterSecurityCardNo(PasswordDTO password, MessageContext messageContext) {
		if (!password.getSecurityCardNumber1().equals(password.getSecurityCardNumber2())) {
			String code = "password.securityCardNumber.notIdentical";
			String defaultText = "Two security card number is not identical";
			MessageResolver messageResolver = new MessageBuilder().error().code(code).defaultText(defaultText).build();
			messageContext.addMessage(messageResolver);
		}
	}
}
