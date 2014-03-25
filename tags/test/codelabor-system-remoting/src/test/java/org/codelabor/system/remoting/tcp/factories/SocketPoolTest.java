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
import java.util.NoSuchElementException;

import org.apache.commons.pool.impl.SoftReferenceObjectPool;
import org.apache.commons.pool.impl.StackObjectPool;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shin Sangjae
 * 
 */
public class SocketPoolTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.codelabor.system.remoting.tcp.factories.SocketPoolFactory#makeObject()}
	 * .
	 * 
	 * @throws Exception
	 * @throws IllegalStateException
	 * @throws NoSuchElementException
	 */
	@Test
	public void testSoftReferenceObjectPool() throws Exception {
		SoftReferenceObjectPool socketPool = new SoftReferenceObjectPool();
		SocketPoolFactory socketPoolFactory = new SocketPoolFactory();
		socketPoolFactory.setHost("localhost");
		socketPoolFactory.setPort(8080);
		socketPool.setFactory(socketPoolFactory);
		Socket sockets[] = new Socket[10];

		for (int i = 0; i < 10; i++) {
			sockets[i] = (Socket) socketPool.borrowObject();
			System.out.println("borrowObject: " + sockets[i].hashCode());
			System.out.println("active: " + socketPool.getNumActive()
					+ ", idle: " + socketPool.getNumIdle());

		}
		for (int i = 0; i < 10; i++) {
			System.out.println("returnbject: " + sockets[i].hashCode());
			socketPool.returnObject(sockets[i]);
			sockets[i] = null;
			System.out.println("active: " + socketPool.getNumActive()
					+ ", idle: " + socketPool.getNumIdle());
		}
		// while (true) {
		// Thread.sleep(1000);
		// System.out.println("active: " + socketPool.getNumActive()
		// + ", idle: " + socketPool.getNumIdle());
		// }

	}

	@Test
	public void testStackObjectPool() throws Exception {
		SocketPoolFactory socketPoolFactory = new SocketPoolFactory();
		socketPoolFactory.setHost("localhost");
		socketPoolFactory.setPort(8080);

		StackObjectPool socketPool = new StackObjectPool(socketPoolFactory, 10,
				5);

		Socket sockets[] = new Socket[10];
		for (int i = 0; i < 10; i++) {
			sockets[i] = (Socket) socketPool.borrowObject();
			System.out.println("borrowObject: " + sockets[i].hashCode());
			System.out.println("active: " + socketPool.getNumActive()
					+ ", idle: " + socketPool.getNumIdle());

		}
		for (int i = 0; i < 10; i++) {
			System.out.println("returnbject: " + sockets[i].hashCode());
			socketPool.returnObject(sockets[i]);
			sockets[i] = null;
			System.out.println("active: " + socketPool.getNumActive()
					+ ", idle: " + socketPool.getNumIdle());
		}

		// while (true) {
		// Thread.sleep(1000);
		// System.out.println("active: " + socketPool.getNumActive()
		// + ", idle: " + socketPool.getNumIdle());
		// }

	}

}
