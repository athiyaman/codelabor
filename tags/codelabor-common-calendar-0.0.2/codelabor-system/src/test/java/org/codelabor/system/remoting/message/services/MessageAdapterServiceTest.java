package org.codelabor.system.remoting.message.services;

import org.codelabor.example.remoting.message.dtos.KsfcHeaderDTO;
import org.codelabor.example.remoting.message.dtos.Saaa020005rInputDTO;
import org.codelabor.example.remoting.message.dtos.Saaa020005rOutputDTO;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.codelabor.system.remoting.message.dtos.MessageHeaderDTO;
import org.codelabor.system.remoting.message.dtos.SystemHeaderDTO;
import org.codelabor.system.remoting.message.dtos.TransactionHeaderDTO;
import org.codelabor.system.remoting.message.services.MessageAdapterService;
import org.springframework.context.MessageSource;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

@SuppressWarnings("deprecation")
public class MessageAdapterServiceTest extends AbstractDependencyInjectionSpringContextTests {

	protected MessageAdapterService messageAdapterService;
	protected MessageSource messageSource;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		messageAdapterService = (MessageAdapterService) applicationContext.getBean("exampleRemotingMessageAdapterService");
		messageSource = (MessageSource) applicationContext.getBean("messageSource");
	}

	public void testLogin() throws Exception {
		// input data
		Saaa020005rInputDTO inputData = new Saaa020005rInputDTO();

		// 개인
		inputData.setInbkId("KSY4607");
		inputData.setInbkPwd("1111");

		// 법인

		// prepare header data
		// input header - system header
		SystemHeaderDTO systemHeaderDTO = new SystemHeaderDTO();
		systemHeaderDTO.setTrCd("SAAA020005R");
		systemHeaderDTO.setScrnNo("00000000");

		// input header - transaction header
		TransactionHeaderDTO transactionHeaderDTO = new TransactionHeaderDTO();

		// input header - message header
		MessageHeaderDTO messageHeaderDTO = new MessageHeaderDTO();

		// input header
		KsfcHeaderDTO inputHeader = new KsfcHeaderDTO();
		inputHeader.setSystemHeaderDTO(systemHeaderDTO);
		inputHeader.setTransactionHeaderDTO(transactionHeaderDTO);
		inputHeader.setMessageHeaderDTO(messageHeaderDTO);

		// output header
		KsfcHeaderDTO outputHeader = new KsfcHeaderDTO();

		// output data
		Saaa020005rOutputDTO outputData = new Saaa020005rOutputDTO();

		// call
		messageAdapterService.call(inputHeader, inputData, outputHeader, outputData);

		if (outputHeader.isError()) {
			messageHeaderDTO = outputHeader.getMessageHeaderDTO();
			String messageCode = messageHeaderDTO.getMsgCd();
			String messageDescription = messageHeaderDTO.getMsgDesc();
			throw new RollbackCommonException(messageSource, messageCode, messageDescription);
		} else {
			logger.info(outputData);
		}

	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:/**/applicationContext-*.xml"};
	}
}
