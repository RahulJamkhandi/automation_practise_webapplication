package com.comcast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream stream = new FileInputStream("./testData/VtigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(stream);
		String value = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		workbook.close();
		return value;
	}

	public int rowCount(String sheetName) throws Throwable {
		FileInputStream stream = new FileInputStream("./testData/VtigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(stream);
		workbook.close();
		return workbook.getSheet(sheetName).getLastRowNum();
	}

	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream stream = new FileInputStream("./testData/VtigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(stream);
		workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum);

		FileOutputStream outputStream = new FileOutputStream("./testData/VtigerTestData.xlsx");
		workbook.write(outputStream);
		workbook.close();
	}

}
