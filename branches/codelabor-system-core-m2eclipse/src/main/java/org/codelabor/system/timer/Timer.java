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
package org.codelabor.system.timer;

import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author "Shin Sangjae"
 * 
 */
public class Timer extends Thread {
	private final Logger logger = LoggerFactory.getLogger(Timer.class);
	protected final int intervalTime = 100;
	protected int elapsedTime = 0;
	protected int timeout = 1000 * 60;

	public Timer(int timeout) {
		super();
		this.timeout = timeout;
	}

	public synchronized void reset() {
		elapsedTime = 0;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			try {
				Thread.sleep(intervalTime);
			} catch (InterruptedException e) {
				continue;
			}

			synchronized (this) {
				elapsedTime += intervalTime;
				if (elapsedTime > timeout) {
					try {
						timeout();
					} catch (TimeoutException e) {
						logger.equals(e);
						e.printStackTrace();
					}
				}
			}

		}
	}

	public void timeout() throws TimeoutException {
		StringBuilder sb = new StringBuilder();
		sb.append("time exceeded: ").append(timeout);
		throw new TimeoutException(sb.toString());
	}
}
