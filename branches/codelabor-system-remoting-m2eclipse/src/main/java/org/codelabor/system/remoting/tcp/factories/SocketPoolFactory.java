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
package org.codelabor.system.remoting.tcp.factories;

import java.net.Socket;

import org.apache.commons.pool.BasePoolableObjectFactory;

/**
 * @author Shin Sangjae
 * 
 */
public class SocketPoolFactory extends BasePoolableObjectFactory {

	protected String host;
	protected int port;

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public void activateObject(Object obj) throws Exception {
		super.activateObject(obj);
	}

	@Override
	public void destroyObject(Object obj) throws Exception {
		super.destroyObject(obj);
	}

	@Override
	public void passivateObject(Object obj) throws Exception {
		super.passivateObject(obj);
	}

	@Override
	public boolean validateObject(Object obj) {
		return (!((Socket) obj).isClosed());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.pool.BasePoolableObjectFactory#makeObject()
	 */
	@Override
	public Object makeObject() throws Exception {
		return new Socket(host, port);
	}

}
