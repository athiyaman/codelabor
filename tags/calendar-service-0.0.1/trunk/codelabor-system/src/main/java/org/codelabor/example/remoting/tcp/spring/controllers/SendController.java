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
package org.codelabor.example.remoting.tcp.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.codelabor.example.remoting.tcp.dtos.MessageDTO;
import org.codelabor.system.remoting.tcp.services.SocketAdapterService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * @author Shin Sang Jae
 * 
 */
public class SendController extends SimpleFormController {

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		MessageDTO messageDTO = (MessageDTO) command;
		String sentMessage = messageDTO.getMessage();
		String receivedMessage = socketAdapterService.send(sentMessage);
		ModelAndView mav = new ModelAndView(this.getSuccessView(), "receivedMessage", receivedMessage);
		return mav;
	}

	protected SocketAdapterService socketAdapterService;
	protected String successView;

	public void setSocketAdapterService(SocketAdapterService socketAdapterService) {
		this.socketAdapterService = socketAdapterService;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setMessage(message);
		return messageDTO;
	}
}
