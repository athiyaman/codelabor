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

package org.codelabor.system.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 채널 유틸리티 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class ChannelUtils {

	/**
	 * 채널을 복사한다.
	 * 
	 * @param inputChannel
	 *            입력 채널
	 * @param outputChannel
	 *            출력 채널
	 * @return 복사된 크기
	 * @throws IOException
	 *             IO 예외
	 */
	public static int copy(ReadableByteChannel inputChannel,
			WritableByteChannel outputChannel) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(128);
		int readSize = 0;
		int copySize = 0;

		while (true) {
			readSize = inputChannel.read(buffer);
			if (readSize == -1)
				break;
			copySize += readSize;

			buffer.flip();
			outputChannel.write(buffer);
			buffer.compact();
		}
		buffer.flip();
		while (buffer.hasRemaining()) {
			outputChannel.write(buffer);
		}
		return copySize;
	}
}
