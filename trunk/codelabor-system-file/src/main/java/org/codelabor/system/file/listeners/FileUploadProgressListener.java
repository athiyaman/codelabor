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

package org.codelabor.system.file.listeners;

import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Sang Jae Shin
 * 
 */
public class FileUploadProgressListener implements ProgressListener {
	private long megaBytes = -1;
	private final Log log = LogFactory.getLog(FileUploadProgressListener.class);

	public void update(long bytesRead, long contentLength, int items) {
		long mBytes = bytesRead / 1000000;
		if (megaBytes == mBytes) {
			return;
		}
		megaBytes = mBytes;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("reading item: ").append(items);
		if (log.isInfoEnabled()) {
			log.info(stringBuilder.toString());
		}

		stringBuilder = new StringBuilder();
		stringBuilder.append(bytesRead);
		if (contentLength == -1) {
			stringBuilder.append(" bytes have been read.");
		} else {
			stringBuilder.append(" of ");
			stringBuilder.append(contentLength);
			stringBuilder.append(" bytes have been read.");
		}
		if (log.isInfoEnabled()) {
			log.info(stringBuilder.toString());
		}
	}
}
