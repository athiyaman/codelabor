package org.codelabor.example.poi.ss.util.cellwalk;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.cellwalk.CellHandler;
import org.apache.poi.ss.util.cellwalk.CellWalkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmpCellHandler implements CellHandler {

	private final Logger logger = LoggerFactory.getLogger(EmpCellHandler.class);

	@Override
	public void onCell(Cell cell, CellWalkContext ctx) {
		int rowIndex = cell.getRowIndex();
		int columnIndex = cell.getColumnIndex();
		CellReference cellRef = new CellReference(rowIndex, columnIndex);
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
			logger.debug("cellType: error, value: {}", cell.getErrorCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			logger.debug("cellType: formula, value: {}", cell.getCellFormula());
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
