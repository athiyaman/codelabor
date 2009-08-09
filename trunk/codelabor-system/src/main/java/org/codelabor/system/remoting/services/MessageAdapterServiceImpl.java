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

import org.apache.commons.lang.ArrayUtils;
import org.codelabor.system.remoting.dtos.DataDTO;
import org.codelabor.system.remoting.dtos.HeaderDTO;
import org.codelabor.system.remoting.tcp.services.SocketAdapterService;

/**
 * @author bomber
 * 
 */
public class MessageAdapterServiceImpl implements MessageAdapterService {

	private SocketAdapterService socketAdapterService;

	public void setSocketAdapterService(
			SocketAdapterService socketAdapterService) {
		this.socketAdapterService = socketAdapterService;
	}

	public void call(HeaderDTO inputHeaderDTO, DataDTO inputDataDTO,
			HeaderDTO outputHeaderDTO, DataDTO outputDataDTO) throws Exception {
		byte[] inputHeaderBytes = inputHeaderDTO.toBytes();
		byte[] inputDataBytes = inputDataDTO.toBytes();
		byte[] inputMessageBytes = ArrayUtils.addAll(inputHeaderBytes,
				inputDataBytes);
		String outputMessage = socketAdapterService.send(new String(
				inputMessageBytes));

		byte[] outputMessageBytes = outputMessage.getBytes();
		byte[] outputHeaderBytes = ArrayUtils.subarray(outputMessageBytes, 0,
				outputHeaderDTO.getLength());
		byte[] outputDataBytes = ArrayUtils.subarray(outputMessageBytes,
				outputHeaderDTO.getLength(), outputMessageBytes.length);
		outputHeaderDTO.fromBytes(outputHeaderBytes);
		outputDataDTO.fromBytes(outputDataBytes);
	}
}
