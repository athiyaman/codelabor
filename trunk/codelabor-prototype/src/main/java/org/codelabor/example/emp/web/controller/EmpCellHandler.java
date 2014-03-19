package org.codelabor.example.emp.web.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.cellwalk.CellHandler;
import org.apache.poi.ss.util.cellwalk.CellWalkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmpCellHandler implements CellHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(EmpCellHandler.class);

	@Override
	public void onCell(Cell cell, CellWalkContext ctx) {
		int rowIndex = cell.getRowIndex();
		int columnIndex = cell.getColumnIndex();
		CellReference cellRef = new CellReference(rowIndex, columnIndex);
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			logger.debug(
					"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: blank, value: {}",
					cellRef.formatAsString(), rowIndex, columnIndex, cell
							.getRichStringCellValue().toString());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			logger.debug(
					"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: boolean, value: {}",
					cellRef.formatAsString(), rowIndex, columnIndex,
					cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_ERROR:
			logger.debug(
					"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: error, value: {}",
					cellRef.formatAsString(), rowIndex, columnIndex,
					cell.getErrorCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			logger.debug(
					"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: formula, value: {}",
					cellRef.formatAsString(), rowIndex, columnIndex,
					cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				logger.debug(
						"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: numeric, value: {}",
						cellRef.formatAsString(), rowIndex, columnIndex,
						cell.getDateCellValue());
			} else {
				logger.debug(
						"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: numeric, value: {}",
						cellRef.formatAsString(), rowIndex, columnIndex,
						cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_STRING:
			logger.debug(
					"cellRef: {} (rowIndex: {}, columnIndex: {}), cellType: string, value: {}",
					cellRef.formatAsString(), rowIndex, columnIndex,
					cell.getRichStringCellValue());
			break;
		default:
			break;
		}
	}

}
