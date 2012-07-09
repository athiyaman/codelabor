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
package org.codelabor.example.poi;

import static org.junit.Assert.fail;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

public class XSSFWorkbookTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWrite() {
		String path = "C:/temp/workbook1.xlsx";
		OutputStream outputStream = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			outputStream = new FileOutputStream(path);
			workbook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testCreateSheet() {
		String path = "C:/temp/workbook2.xlsx";
		OutputStream outputStream = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook.createSheet("Sheet1");
			workbook.createSheet("Sheet2");

			outputStream = new FileOutputStream(path);
			workbook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testCreateCell() {
		String path = "C:/temp/workbook3.xlsx";
		OutputStream outputStream = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			Sheet sheet1 = workbook.createSheet("Sheet1");
			CreationHelper creationHelper = workbook.getCreationHelper();

			Row row = sheet1.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue(1);
			cell = row.createCell(1);
			cell.setCellValue(1.2);
			cell = row.createCell(2);
			cell.setCellValue(creationHelper
					.createRichTextString("This is a string"));
			cell = row.createCell(3);
			cell.setCellValue(true);

			outputStream = new FileOutputStream(path);
			workbook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testSetCellStyle() {
		String path = "C:/temp/workbook4.xlsx";
		OutputStream outputStream = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			Sheet sheet1 = workbook.createSheet("Sheet1");
			CreationHelper creationHelper = workbook.getCreationHelper();
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setDataFormat(creationHelper.createDataFormat()
					.getFormat("yyyy-mm-dd hh:mm"));

			Row row = sheet1.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue(new Date());

			cell = row.createCell(1);
			cell.setCellValue(new Date());
			cell.setCellStyle(cellStyle);

			cell = row.createCell(2);
			cell.setCellValue(Calendar.getInstance());
			cell.setCellStyle(cellStyle);

			outputStream = new FileOutputStream(path);
			workbook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
