package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	public String getDataFromExcel(String sheetName, int rownum, int cellnum) throws Exception {
	FileInputStream fis = new FileInputStream("./testdata/TestScriptnew.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	wb.close();
	return data;
	}
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/TestScriptnew.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}
	public void setDataIntoExcel(String sheetName, int rownum, int cellnum, String data) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("/testdata/TestScript12.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rownum).createCell(cellnum);
		FileOutputStream fos = new FileOutputStream("./testdata/TestScript12.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
}
