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

package anyframe.services.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;

import org.anyframe.exception.BaseException;
import org.anyframe.idgen.IdGenService;
import org.anyframe.query.QueryService;
import org.anyframe.query.QueryServiceException;
import org.codelabor.system.file.dto.FileDTO;
import org.codelabor.system.util.ChannelUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * BLOB 테스트 케이스
 * 
 * @author Shin Sang-jae
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/**/applicationContext*.xml")
public class BlobTest {

	private final Logger logger = LoggerFactory.getLogger(BlobTest.class);
	@Autowired
	private ApplicationContext context;

	/**
	 * 쿼리 서비스
	 */
	protected QueryService queryService;
	/**
	 * Unique Filename 제네레이션 서비스
	 */
	protected IdGenService uniqueFilenameGenerationService;
	/**
	 * Map Id 제네레이션 서비스
	 */
	protected IdGenService mapIdGenService;
	/**
	 * File Id 제네레이션 서비스
	 */
	protected IdGenService fileIdGenService;

	/**
	 * 원본 파일
	 */
	private File sourceFile;
	/**
	 * 대상 파일
	 */
	private File targetFile;

	@Before
	public void setUp() throws Exception {
		queryService = context.getBean("queryService", QueryService.class);
		uniqueFilenameGenerationService = context.getBean(
				"uniqueFilenameGenerationService", IdGenService.class);
		fileIdGenService = context.getBean("fileIdGenService",
				IdGenService.class);
		mapIdGenService = context.getBean("mapIdGenService",
				IdGenService.class);

		// prepare data
		URL url = this.getClass().getResource("/images/feather-small.gif");
		sourceFile = new File(url.toURI());

		// clear data
		// queryService.remove("system.delete.file.list", new Object[] {});
	}

	/**
	 * DTO로 BLOB에 입력한다.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testInsertBlobByDTO() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;
		String fileId;
		String mapId;
		try {
			inputStream = new FileInputStream(sourceFile);
			outputStream = new ByteArrayOutputStream();
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			int sourceFileSize = ChannelUtils.copy(inputChannel, outputChannel);

			fileId = fileIdGenService.getNextStringId();
			mapId = mapIdGenService.getNextStringId();
			String uniqueFilename = uniqueFilenameGenerationService
					.getNextStringId();

			// test
			FileDTO fileDTO = new FileDTO();
			fileDTO.setFileId(fileId);
			fileDTO.setMapId(mapId);
			fileDTO.setRealFilename(sourceFile.getName());
			fileDTO.setUniqueFilename(uniqueFilename);
			fileDTO.setRepositoryPath(null);
			fileDTO.setContentType("image/jpeg");
			fileDTO.setFileSize(sourceFileSize);
			fileDTO.setBytes(((ByteArrayOutputStream) outputStream)
					.toByteArray());

			logger.debug("fileDTO: {}", fileDTO);
			queryService.create(fileDTO);

			// assert
			List<FileDTO> fileDTOList = (List) queryService.find(fileDTO);
			FileDTO returnedFileDTO = fileDTOList.get(0);
			logger.debug("returnedFileDTO: {}", returnedFileDTO);

			targetFile = new File("target/" + returnedFileDTO.getRealFilename());
			byte[] bytes = returnedFileDTO.getBytes();
			inputStream = new ByteArrayInputStream(bytes);
			outputStream = new FileOutputStream(targetFile);
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			int targetFileSize = ChannelUtils.copy(inputChannel, outputChannel);

			assertEquals(sourceFileSize, targetFileSize);
			assertEquals(fileDTO.getUniqueFilename(),
					returnedFileDTO.getUniqueFilename());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			fail();
		} catch (BaseException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			fail();
		} finally {
			try {
				inputChannel.close();
				outputChannel.close();
				inputStream.close();
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 바이트 배열로 BLOB에 입력한다.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testInsertBlobByObjectArray() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;
		String fileId;
		String mapId;
		try {
			inputStream = new FileInputStream(sourceFile);
			outputStream = new ByteArrayOutputStream();
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			int sourceFileSize = ChannelUtils.copy(inputChannel, outputChannel);

			fileId = fileIdGenService.getNextStringId();
			mapId = mapIdGenService.getNextStringId();
			String uniqueFilename = uniqueFilenameGenerationService
					.getNextStringId();

			// test
			String queryId = "system.insert.file";
			Object[] params = new Object[] { fileId, mapId,
					sourceFile.getName(), uniqueFilename, null, "image/jpeg",
					sourceFileSize,
					((ByteArrayOutputStream) outputStream).toByteArray() };
			queryService.create(queryId, params);

			// assert
			FileDTO fileDTO = new FileDTO();
			fileDTO.setFileId(fileId);
			List<FileDTO> fileDTOList = (List) queryService.find(fileDTO);
			FileDTO returnedFileDTO = fileDTOList.get(0);
			logger.debug("fileDTO: {}", returnedFileDTO);

			targetFile = new File("C:/" + returnedFileDTO.getRealFilename());
			byte[] bytes = returnedFileDTO.getBytes();
			inputStream = new ByteArrayInputStream(bytes);
			outputStream = new FileOutputStream(targetFile);
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			int targetFileSize = ChannelUtils.copy(inputChannel, outputChannel);

			assertEquals(sourceFileSize, targetFileSize);
			assertEquals(uniqueFilename, returnedFileDTO.getUniqueFilename());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			fail();
		} catch (QueryServiceException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			fail();
		} catch (BaseException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			fail();
		} finally {
			try {
				inputChannel.close();
				outputChannel.close();
				inputStream.close();
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
