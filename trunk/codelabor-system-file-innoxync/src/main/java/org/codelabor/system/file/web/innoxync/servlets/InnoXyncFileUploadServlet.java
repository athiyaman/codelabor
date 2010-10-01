package org.codelabor.system.file.web.innoxync.servlets;

import static org.codelabor.system.daos.DAOConstants.AFFECTED_ROW_COUNT;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.codelabor.system.file.RepositoryType;
import org.codelabor.system.file.dtos.FileDTO;
import org.codelabor.system.file.utils.UploadUtils;
import org.codelabor.system.file.web.servlets.FileUploadServlet;
import org.codelabor.system.web.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import anyframe.common.util.StringUtil;

import com.ixync.IXyncDataColumn;
import com.ixync.IXyncDataRow;
import com.ixync.IXyncDataSet;
import com.ixync.http.HttpIXyncRequest;
import com.ixync.http.HttpIXyncResponse;
import com.ixync.io.IXyncInputStream;
import com.ixync.io.IXyncOutputStream;

public class InnoXyncFileUploadServlet extends FileUploadServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 6060491747750865553L;
	private final static Logger logger = LoggerFactory
			.getLogger(InnoXyncFileUploadServlet.class);

	public enum Parameter {
		save, download, list, getMapId
	};

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String parameterValue = request.getParameter(parameterName);
			switch (Parameter.valueOf(parameterValue)) {
			case save:
				save(request, response);
				break;
			case download:
				download(request, response);
				break;
			case list:
				list(request, response);
				break;
			case getMapId:
				getMapId(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void getMapId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap: {}", paramMap.toString());

		IXyncOutputStream gos = null;

		try {
			// innoxync stream
			gos = ((HttpIXyncResponse) response).getIXyncOutputStream();

			// TODO get map id
			String mapId = this.mapIdGenerationService.getNextStringId();
			logger.debug("mapId: {}", mapId);

			// make dataset
			IXyncDataSet dataset = new IXyncDataSet("mapId");
			dataset.addDataColumn(new IXyncDataColumn("map_id",
					IXyncDataColumn.TB_STRING, 255));
			IXyncDataRow dataRow = dataset.newDataRow();
			dataRow.addColumnValue(mapId);
			dataset.addDataRow(dataRow);

			logger.debug("dataset: {}", dataset);
			logger.debug("dataset row count: {}", dataset.getDataRowCnt());
			logger.debug("dataset column count: {}", dataset.getDataColCnt());

			gos.write(dataset);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (gos != null) {
				gos.close();
			}
		}
	}

	protected void save(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap: {}", paramMap);

		RepositoryType acceptedRepositoryType = repositoryType;
		String requestedRepositoryType = (String) paramMap
				.get("repositoryType");
		if (StringUtil.isNotEmpty(requestedRepositoryType)) {
			acceptedRepositoryType = RepositoryType
					.valueOf(requestedRepositoryType);
		}

		IXyncInputStream gis = null;
		IXyncOutputStream gos = null;

		try {
			// innoxync stream
			gis = ((HttpIXyncRequest) request).getIXyncInputStream();
			gos = ((HttpIXyncResponse) response).getIXyncOutputStream();

			// get dataset
			IXyncDataSet dataset = gis.read("dsetFile");

			if (dataset == null) {
			} else {
				int mapIdIndex = dataset.indexOfColumn("map_id");
				int fileIdIndex = dataset.indexOfColumn("file_id");
				int fileNameIndex = dataset.indexOfColumn("file_name");
				int fileReferenceIndex = dataset
						.indexOfColumn("file_reference");
				IXyncDataRow[] dataRows = dataset.getDataRows();

				for (IXyncDataRow dataRow : dataRows) {
					switch (dataRow.getJobType()) {
					case IXyncDataRow.TB_JOB_INSERT:
						String mapId = dataRow.getString(mapIdIndex);
						String fileName = dataRow.getString(fileNameIndex);
						InputStream is = dataRow
								.getInputStream(fileReferenceIndex);

						FileDTO fileDTO = null;
						fileDTO = new FileDTO();
						fileDTO.setMapId(mapId);
						fileDTO.setRealFileName(UploadUtils
								.stripPathInfo(fileName));
						fileDTO
								.setUniqueFileName(uniqueFileNameGenerationService
										.getNextStringId());
						// fileDTO.setContentType(fileItem.getContentType());
						fileDTO.setRepositoryPath(realRepositoryPath);
						UploadUtils.processFile(acceptedRepositoryType, is,
								fileDTO);
						if (fileDTO != null)
							fileManager.insertFile(fileDTO);
						break;
					case IXyncDataRow.TB_JOB_DELETE:
						String fileId = dataRow.getString(fileIdIndex);
						fileManager.deleteFile(fileId);
						break;
					}
				}
			}
		} catch (Exception e) {
		} finally {
			if (gos != null) {
				gos.close();
			}
		}
	}

	@Override
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> paramMap = RequestUtils.getParameterMap(request);
		logger.debug("paramMap: {}", paramMap.toString());

		String mapId = (String) paramMap.get("mapId");
		String repositoryType = (String) paramMap.get("repositoryType");

		IXyncOutputStream gos = null;

		List<FileDTO> fileDTOList = null;
		try {
			// innoxync stream
			gos = ((HttpIXyncResponse) response).getIXyncOutputStream();
			if (StringUtils.isEmpty(repositoryType)) {
				if (StringUtils.isEmpty(mapId)) {
					fileDTOList = fileManager.selectFile();
				} else {
					fileDTOList = fileManager.selectFileByMapId(mapId);
				}
			} else {
				switch (RepositoryType.valueOf(repositoryType)) {
				case DATABASE:
					fileDTOList = fileManager
							.selectFileByRepositoryType(RepositoryType.DATABASE);
					break;
				case FILE_SYSTEM:
					fileDTOList = fileManager
							.selectFileByRepositoryType(RepositoryType.FILE_SYSTEM);
					break;
				}
			}
			logger.debug("file count: {}", fileDTOList.size());

			// make dataset
			IXyncDataSet dataset = new IXyncDataSet("dsetFile");
			// dsetFile.SetDataHeader("chk:STRING(1),map_id:STRING(255),file_id:STRING(255),file_name:STRING(255),file_reference:URL(255), size:DECIMAL(10)");
			dataset.addDataColumn(new IXyncDataColumn("chk",
					IXyncDataColumn.TB_STRING, 1));
			dataset.addDataColumn(new IXyncDataColumn("map_id",
					IXyncDataColumn.TB_STRING, 255));
			dataset.addDataColumn(new IXyncDataColumn("file_id",
					IXyncDataColumn.TB_STRING, 255));
			dataset.addDataColumn(new IXyncDataColumn("file_name",
					IXyncDataColumn.TB_STRING, 255));
			dataset.addDataColumn(new IXyncDataColumn("file_reference",
					IXyncDataColumn.TB_URL, 255));
			dataset.addDataColumn(new IXyncDataColumn("size",
					IXyncDataColumn.TB_DECIMAL, 10));

			for (FileDTO fileDTO : fileDTOList) {
				IXyncDataRow dataRow = dataset.newDataRow();
				dataRow.addColumnValue("F");
				dataRow.addColumnValue(fileDTO.getMapId());
				dataRow.addColumnValue(fileDTO.getFileId());
				dataRow.addColumnValue(fileDTO.getRealFileName());
				dataRow.addColumnValue("");
				dataRow.addColumnValue(fileDTO.getFileSize());
				dataset.addDataRow(dataRow);
			}
			logger.debug("dataset: {}", dataset);
			logger.debug("dataset row count: {}", dataset.getDataRowCnt());
			logger.debug("dataset column count: {}", dataset.getDataColCnt());

			gos.write(dataset);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (gos != null) {
				gos.close();
			}
		}
	}

	@Override
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int affectedRowCount = 0;
		String[] fileIdList = request.getParameterValues("fileId");
		try {
			affectedRowCount = fileManager.deleteFile(fileIdList);
			request.setAttribute(AFFECTED_ROW_COUNT, affectedRowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
