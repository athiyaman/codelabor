package org.codelabor.example.emp.web.view;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.codelabor.example.emp.dto.EmpDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.google.common.net.HttpHeaders;

public class EmpListExcelView extends AbstractExcelView {

	private static final Logger logger = LoggerFactory
			.getLogger(EmpListExcelView.class);

	// http://www.codejava.net/frameworks/spring/spring-mvc-with-excel-view-example-apache-poi-and-jexcelapi
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) {
		@SuppressWarnings("unchecked")
		List<EmpDto> empDtoList = (List<EmpDto>) model.get("empDtoList");
		String filename = (String) model.get("filename");

		HSSFSheet sheet = workbook.createSheet("Emp List");
		int rowIndex = 0;
		for (EmpDto empDto : empDtoList) {
			logger.debug("empDto: {}", empDto);

			HSSFRow row = sheet.createRow(rowIndex++);

			Integer empNo = empDto.getEmpNo();
			String ename = empDto.getEname();
			String job = empDto.getJob();
			Integer mgr = empDto.getMgr();
			Date hireDate = empDto.getHireDate();
			BigDecimal sal = empDto.getSal();
			BigDecimal comm = empDto.getComm();
			Integer deptNo = empDto.getDeptNo();

			HSSFCell cell = row.createCell(0);
			if (empNo == null) {
				cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
			} else {
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cell.setCellValue(empNo);
			}
			cell = row.createCell(1);
			if (ename == null) {
				cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
			} else {
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(ename);
			}

			cell = row.createCell(2);
			if (job == null) {
				cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
			} else {
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(job);
			}

			cell = row.createCell(3);
			if (mgr == null) {
				cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
			} else {
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cell.setCellValue(mgr);
			}

			cell = row.createCell(4);
			if (hireDate == null) {
				cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
			} else {
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				HSSFDataFormat dataFormat = workbook.createDataFormat();
				CellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setDataFormat(dataFormat
						.getFormat("yyyy-MM-dd HH:mm:ss"));
				cell.setCellStyle(cellStyle);
				cell.setCellValue(hireDate);
			}

			cell = row.createCell(5);
			if (sal == null) {
				cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
			} else {
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cell.setCellValue(sal.doubleValue());
			}

			cell = row.createCell(6);
			if (comm == null) {
				cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
			} else {
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cell.setCellValue(sal.doubleValue());
			}

			cell = row.createCell(7);
			if (deptNo == null) {
				cell.setCellType(HSSFCell.CELL_TYPE_BLANK);
			} else {
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cell.setCellValue(deptNo);
			}
		}

		// auto size column
		for (int columnIndex = 0; columnIndex <= 7; columnIndex++) {
			sheet.autoSizeColumn(columnIndex);
		}

		// set filename
		StringBuilder sb = new StringBuilder();
		sb.append("attachment; filename=\"");
		sb.append(filename);
		sb.append('\"');
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, sb.toString());
	}
}
