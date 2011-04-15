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
package org.codelabor.system.mime.service;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * ����Ÿ�� Ž�� ���� �������̽�
 * 
 * @author Shin Sangjae
 * 
 */
public interface MimeDetectService {
	/**
	 * ����Ÿ���� �����´�.
	 * 
	 * @param inputStream
	 *            �Է� ��Ʈ��
	 * @return ����Ÿ��
	 */
	public String getMimeType(InputStream inputStream) throws Exception;

	/**
	 * ����Ÿ���� �����´�.
	 * 
	 * @param file
	 *            ����
	 * @return ����Ÿ��
	 */
	public String getMimeType(File file) throws Exception;

	/**
	 * ����Ÿ���� �����´�.
	 * 
	 * @param url
	 *            URL
	 * @return ����Ÿ��
	 */
	public String getMimeType(URL url) throws Exception;

	/**
	 * ����Ÿ���� �����´�.
	 * 
	 * @param byteArray
	 *            ����Ʈ �迭
	 * @return ����Ÿ��
	 */
	public String getMimeType(byte[] byteArray) throws Exception;

	/**
	 * ����Ÿ���� �����´�.
	 * 
	 * @param path
	 *            ���� ���
	 * @return ����Ÿ��
	 */
	public String getMimeType(String path) throws Exception;
}
