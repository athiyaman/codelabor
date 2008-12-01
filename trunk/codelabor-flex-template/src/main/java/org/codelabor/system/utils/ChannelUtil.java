package org.codelabor.system.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelUtil {

	public static int copy(ReadableByteChannel inputChannel,
			WritableByteChannel outputChannel) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
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
