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
 * 타이머
 * 
 * @author "Shin Sang-jae"
 * 
 */
public class Timer extends Thread {
	/**
	 * 로거
	 */
	private final Logger logger = LoggerFactory.getLogger(Timer.class);
	/**
	 * 인터벌 타임</br>기본값은 100이다.
	 */
	protected final int intervalTime = 100;
	/**
	 * 실행 시간</br>기본 값은 0이다.
	 */
	protected int elapsedTime = 0;
	/**
	 * 타임 아웃</br>기본 값은 60000밀리세턴드(1분)이다.
	 */
	protected int timeout = 1000 * 60;

	/**
	 * 생성자
	 * 
	 * @param timeout
	 */
	public Timer(int timeout) {
		super();
		this.timeout = timeout;
	}

	/**
	 * 초기화한다.
	 */
	public synchronized void reset() {
		elapsedTime = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
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

	/**
	 * 타임 아웃 시킨다.
	 * 
	 * @throws TimeoutException
	 *             타임 아웃 예외
	 */
	public void timeout() throws TimeoutException {
		StringBuilder sb = new StringBuilder();
		sb.append("time exceeded: ").append(timeout);
		throw new TimeoutException(sb.toString());
	}
}
