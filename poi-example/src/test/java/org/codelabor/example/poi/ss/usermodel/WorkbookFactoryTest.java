package org.codelabor.example.poi.ss.usermodel;

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
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.cellwalk.CellWalk;
import org.codelabor.example.poi.ss.util.cellwalk.EmpCellHandler;
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
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BLANK:
						logger.debug(
								"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: blank, value: {}",
								cellRef.formatAsString(), rowIndex,
								columnIndex, cell.getRichStringCellValue()
										.toString());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						logger.debug(
								"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: boolean, value: {}",
								cellRef.formatAsString(), rowIndex,
								columnIndex, cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_ERROR:
						logger.debug(
								"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: error, value: {}",
								cellRef.formatAsString(), rowIndex,
								columnIndex, cell.getErrorCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						logger.debug(
								"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: formula, value: {}",
								cellRef.formatAsString(), rowIndex,
								columnIndex, cell.getCellFormula());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							logger.debug(
									"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: numeric, value: {}",
									cellRef.formatAsString(), rowIndex,
									columnIndex, cell.getDateCellValue());
						} else {
							logger.debug(
									"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: numeric, value: {}",
									cellRef.formatAsString(), rowIndex,
									columnIndex, cell.getNumericCellValue());
						}
						break;
					case Cell.CELL_TYPE_STRING:
						logger.debug(
								"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: string, value: {}",
								cellRef.formatAsString(), rowIndex,
								columnIndex, cell.getRichStringCellValue());
						break;
					default:
						break;
					}
				}
			}
		}
	}

	@Test
	public void testTraverseWithCellWalk() throws InvalidFormatException,
			IOException, URISyntaxException {

		URL url = getClass().getResource("/emp-data.xlsx");
		logger.debug("url: {}", url);
		File file = new File(url.toURI());
		logger.debug("file: {}", file);

		Workbook wb = WorkbookFactory.create(file);
		int numberOfSheets = wb.getNumberOfSheets();
		logger.debug("numberOfSheets: {}", numberOfSheets);

		int firstRowNum = 0;
		int lastRowNum = 0;
		int firstCellNum = 0;
		int lastCellNum = 0;

		// int effectiveFirstRowNum = 0;
		// int effectiveLastRowNum = 0;
		// int effectiveFirstCellNum = 0;
		// int effectiveLastCellNum = 0;

		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = wb.getSheetAt(i);
			String sheetName = sheet.getSheetName();
			logger.debug("sheetName: {}", sheetName);
			firstRowNum = sheet.getFirstRowNum();
			lastRowNum = sheet.getLastRowNum();
			logger.debug("firstRowNum: {},  lastRowNum: {}", firstRowNum,
					lastRowNum);

			for (Row row : sheet) {
				int rowNum = row.getRowNum();
				firstCellNum = row.getFirstCellNum();
				lastCellNum = row.getLastCellNum();
				logger.debug("rowNum: {}, firstCellNum: {},  lastCellNum: {}",
						rowNum, firstCellNum, lastCellNum);

			}

			logger.debug(
					"firstRowNum: {}, lastRowNum: {}, firstCellNum: {}, lastCellNum: {}",
					firstRowNum, lastRowNum, firstCellNum, lastCellNum);

			// effective 값으로 보정하기
			// logger.debug(
			// "effectiveFirstRowNum: {}, effectiveLastRowNum: {}, effectiveFirstCellNum: {}, effectiveLastCellNum: {}",
			// effectiveFirstRowNum, effectiveLastRowNum,
			// effectiveFirstCellNum, effectiveLastCellNum);

			CellRangeAddress cellRangeAddress = new CellRangeAddress(
					firstRowNum, lastRowNum, firstCellNum, lastCellNum);
			logger.debug("cellRangeAddress: {}",
					cellRangeAddress.formatAsString());

			CellWalk cellWalk = new CellWalk(sheet, cellRangeAddress);
			cellWalk.traverse(new EmpCellHandler());

		}

	}
}
