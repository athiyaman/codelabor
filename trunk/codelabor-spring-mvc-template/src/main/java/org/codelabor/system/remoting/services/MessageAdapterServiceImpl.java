/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.system.remoting.services;

import org.codelabor.system.remoting.dtos.Header;

import com.sds.anyframe.abstractlayer.vo.AbstractMVO;

/**
 * @author bomber
 * 
 */
public class MessageAdapterServiceImpl implements MessageAdapterService {

	private SocketAdapterService socketApapter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.services.MessageAdapterService#call(org.codelabor
	 * .system.dtos.Header, com.sds.anyframe.abstractlayer.vo.AbstractMVO,
	 * org.codelabor.system.dtos.Header,
	 * com.sds.anyframe.abstractlayer.vo.AbstractMVO)
	 */
	public void call(Header inputHeader, AbstractMVO inputData,
			Header outputHeader, AbstractMVO outputData) throws Exception {
		// concatenate header and data
		byte[] inputHeaderBytes = inputHeader.toBytes();
		byte[] inputDataBytes = inputData.toBytes();
		StringBuilder sb = new StringBuilder();
		sb.append(new String(inputHeaderBytes));
		sb.append(new String(inputDataBytes));

		// send and receive
		String inputMessage = sb.toString();
		String outputMessage = socketApapter.send(inputMessage);

		// separate header and data
		// byte[] outputHeaderBytes = outputMessage
		// .substring(0, HeaderImpl.LENGTH).getBytes();
		// byte[] outputDataBytes = outputMessage.substring(HeaderImpl.LENGTH)
		// .getBytes();

		// outputHeader.fromBytes(outputHeaderBytes);
		// outputData.fromBytes(outputDataBytes);
	}

	public void setSocketApapter(SocketAdapterService socketApapter) {
		this.socketApapter = socketApapter;
	}

}
