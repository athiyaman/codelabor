package anyframe.services.query;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;

import org.codelabor.system.dtos.FileDTO;
import org.codelabor.system.test.BaseTestCase;
import org.codelabor.system.utils.ChannelUtil;
import org.junit.Test;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.query.IQueryService;

public class BlobTest extends BaseTestCase {

	protected IQueryService queryService;

	protected IIdGenerationService uuidGenerationService;

	protected IIdGenerationService sequenceIdGenerationService;

	private File sourceFile;
	private File targetFile;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		queryService = (IQueryService) applicationContext
				.getBean("queryService");
		uuidGenerationService = (IIdGenerationService) applicationContext
				.getBean("uniqueFileNameGenerationService");
		sequenceIdGenerationService = (IIdGenerationService) applicationContext
				.getBean("sequenceFileIdGenerationService");

		// prepare data
		sourceFile = new File("C:/WINDOWS/Help/Tours/htmlTour/intro_logo.jpg");

		// clear data
		queryService.remove("system.delete.file.list", new Object[] {});
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testInsertBlobByDTO() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;
		int fileId = 0;
		try {
			inputStream = new FileInputStream(sourceFile);
			outputStream = new ByteArrayOutputStream();
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			int sourceFileSize = ChannelUtil.copy(inputChannel, outputChannel);

			fileId = sequenceIdGenerationService.getNextIntegerId();
			String uniqueFileName = uuidGenerationService.getNextStringId();

			// test
			FileDTO fileDTO = new FileDTO();
			fileDTO.setFileId(fileId);
			fileDTO.setRealFileName(sourceFile.getName());
			fileDTO.setUniqueFileName(uniqueFileName);
			fileDTO.setRepositoryPath(null);
			fileDTO.setContentType("image/jpeg");
			fileDTO.setFileSize(sourceFileSize);
			fileDTO.setBytes(((ByteArrayOutputStream) outputStream)
					.toByteArray());

			queryService.create(fileDTO);

			// assert
			List<FileDTO> fileDTOList = (List) queryService.find(fileDTO);
			FileDTO returnedFileDTO = fileDTOList.get(0);
			targetFile = new File("C:/" + returnedFileDTO.getRealFileName());
			byte[] bytes = returnedFileDTO.getBytes();
			inputStream = new ByteArrayInputStream(bytes);
			outputStream = new FileOutputStream(targetFile);
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			int targetFileSize = ChannelUtil.copy(inputChannel, outputChannel);

			assertEquals(sourceFileSize, targetFileSize);
			assertEquals(fileDTO.getUniqueFileName(), returnedFileDTO
					.getUniqueFileName());
		} catch (Exception e) {
			e.printStackTrace();
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

	@SuppressWarnings("unchecked")
	public void testInsertBlobByObjectArray() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;
		int fileId = 0;
		try {
			inputStream = new FileInputStream(sourceFile);
			outputStream = new ByteArrayOutputStream();
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			int sourceFileSize = ChannelUtil.copy(inputChannel, outputChannel);

			fileId = sequenceIdGenerationService.getNextIntegerId();
			String uniqueFileName = uuidGenerationService.getNextStringId();

			// test
			String queryId = "system.insert.file";
			Object[] params = new Object[] { fileId, sourceFile.getName(),
					uniqueFileName, null, "image/jpeg", sourceFileSize,
					((ByteArrayOutputStream) outputStream).toByteArray() };
			queryService.create(queryId, params);

			// assert
			FileDTO fileDTO = new FileDTO();
			fileDTO.setFileId(fileId);
			List<FileDTO> fileDTOList = (List) queryService.find(fileDTO);
			FileDTO returnedFileDTO = fileDTOList.get(0);
			targetFile = new File("C:/" + returnedFileDTO.getRealFileName());
			byte[] bytes = returnedFileDTO.getBytes();
			inputStream = new ByteArrayInputStream(bytes);
			outputStream = new FileOutputStream(targetFile);
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			int targetFileSize = ChannelUtil.copy(inputChannel, outputChannel);

			assertEquals(sourceFileSize, targetFileSize);
			assertEquals(uniqueFileName, returnedFileDTO.getUniqueFileName());
		} catch (Exception e) {
			e.printStackTrace();
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
