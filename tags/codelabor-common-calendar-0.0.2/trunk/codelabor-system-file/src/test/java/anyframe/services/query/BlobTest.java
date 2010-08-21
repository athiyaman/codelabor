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

import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.utils.ChannelUtils;
import org.springframework.test.AbstractSingleSpringContextTests;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.query.IQueryService;

public class BlobTest extends AbstractSingleSpringContextTests {

	protected IQueryService queryService;
	protected IIdGenerationService uuidGenerationService;
	protected IIdGenerationService sequenceMapIdGenerationService;
	protected IIdGenerationService sequenceFileIdGenerationService;

	private File sourceFile;
	private File targetFile;

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:/**/applicationContext*.xml" };
	}

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		queryService = (IQueryService) applicationContext
				.getBean("oracleQueryService");
		uuidGenerationService = (IIdGenerationService) applicationContext
				.getBean("uniqueFileNameGenerationService");
		sequenceFileIdGenerationService = (IIdGenerationService) applicationContext
				.getBean("sequenceFileIdGenerationService");
		sequenceMapIdGenerationService = (IIdGenerationService) applicationContext
				.getBean("sequenceMapIdGenerationService");

		// prepare data
		sourceFile = new File("C:/WINDOWS/Help/Tours/htmlTour/intro_logo.jpg");

		// clear data
		// queryService.remove("system.delete.file.list", new Object[] {});
	}

	@SuppressWarnings("unchecked")
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

			fileId = sequenceFileIdGenerationService.getNextStringId();
			mapId = sequenceMapIdGenerationService.getNextStringId();
			String uniqueFileName = uuidGenerationService.getNextStringId();

			// test
			FileDTO fileDTO = new FileDTO();
			fileDTO.setFileId(fileId);
			fileDTO.setMapId(mapId);
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
			int targetFileSize = ChannelUtils.copy(inputChannel, outputChannel);

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
		String fileId;
		String mapId;
		try {
			inputStream = new FileInputStream(sourceFile);
			outputStream = new ByteArrayOutputStream();
			inputChannel = Channels.newChannel(inputStream);
			outputChannel = Channels.newChannel(outputStream);
			int sourceFileSize = ChannelUtils.copy(inputChannel, outputChannel);

			fileId = sequenceFileIdGenerationService.getNextStringId();
			mapId = sequenceMapIdGenerationService.getNextStringId();
			String uniqueFileName = uuidGenerationService.getNextStringId();

			// test
			String queryId = "system.insert.file";
			Object[] params = new Object[] { fileId, mapId,
					sourceFile.getName(), uniqueFileName, null, "image/jpeg",
					sourceFileSize,
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
			int targetFileSize = ChannelUtils.copy(inputChannel, outputChannel);

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
