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
package org.codelabor.system.mime.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;

/**
 * 마임타입 탐지 서비스 구현 클래스<br/>
 * Apache Tika를 활용한 구현 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class TikaMimeDetectUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(TikaMimeDetectUtils.class);

	public static String getMimeType(InputStream inputStream) throws Exception {
		ContentHandler contentHandler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		Parser parser = new AutoDetectParser();
		ParseContext parseContext = new ParseContext();
		parser.parse(inputStream, contentHandler, metadata, parseContext);
		String contentType = metadata.get(Metadata.CONTENT_TYPE);
		logger.debug("content type: {}", contentType);
		return contentType;
	}

	public static String getMimeType(File file) throws Exception {
		InputStream inputStream = new FileInputStream(file);
		return getMimeType(inputStream);
	}

	public static String getMimeType(URL url) throws Exception {
		InputStream inputStream = url.openStream();
		return getMimeType(inputStream);
	}

	public static String getMimeType(byte[] byteArray) throws Exception {
		InputStream inputStream = new ByteArrayInputStream(byteArray);
		return getMimeType(inputStream);
	}

	public static String getMimeType(String path) throws Exception {
		InputStream inputStream = new FileInputStream(new File(path));
		return getMimeType(inputStream);
	}

}
