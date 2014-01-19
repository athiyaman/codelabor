package org.codelabor.example.poi;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkbookFactoryTest {

	private static final Logger logger = LoggerFactory
			.getLogger(WorkbookFactoryTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTraverse() throws InvalidFormatException, IOException,
			URISyntaxException {

		URL url = getClass().getResource("/emp-data.xlsx");
		logger.debug("url: {}", url);
		File file = new File(url.toURI());
		logger.debug("file: {}", file);

		Workbook wb = WorkbookFactory.create(file);
		int numberOfSheets = wb.getNumberOfSheets();
		logger.debug("numberOfSheets: {}", numberOfSheets);

		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = wb.getSheetAt(i);
			String sheetName = sheet.getSheetName();
			logger.debug("sheetName: {}", sheetName);
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();
			logger.debug("firstRowNum: {},  lastRowNum: {}", firstRowNum,
					lastRowNum);

			for (Row row : sheet) {
				int rowNum = row.getRowNum();
				int firstCellNum = row.getFirstCellNum();
				int lastCellNum = row.getLastCellNum();
				logger.debug("rowNum: {}, firstCellNum: {},  lastCellNum: {}",
						rowNum, firstCellNum, lastCellNum);
				for (Cell cell : row) {
					int rowIndex = cell.getRowIndex();
					int columnIndex = cell.getColumnIndex();
					CellReference cellRef = new CellReference(rowIndex,
							columnIndex);
					logger.debug("cellRef: {} (rowIndex: {}, columnIndex: {})",
							cellRef.formatAsString(), rowIndex, columnIndex);
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BLANK:
						logger.debug("cellType: blank, value: {}", cell
								.getRichStringCellValue().toString());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						logger.debug("cellType: boolean, value: {}",
								cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_ERROR:
						logger.debug("cellType: error, value: {}",
								cell.getErrorCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						logger.debug("cellType: formula, value: {}",
								cell.getCellFormula());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							logger.debug("cellType: numeric, value: {}",
									cell.getDateCellValue());
						} else {
							logger.debug("cellType: numeric, value: {}",
									cell.getNumericCellValue());
						}
						break;
					case Cell.CELL_TYPE_STRING:
						logger.debug("cellType: string, value: {}",
								cell.getRichStringCellValue());
						break;
					default:
						break;
					}

				}
			}

		}

	}
}
