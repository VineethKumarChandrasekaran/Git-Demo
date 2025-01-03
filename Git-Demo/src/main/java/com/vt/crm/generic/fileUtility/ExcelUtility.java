package com.vt.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
public String getDataFromExcelFile(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata/VtigerData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	String data = workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	workbook.close();
	return data;
}


public void writeDataToExcel(String sheet, int row, int cell, String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata/VtigerData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	  workbook.getSheet(sheet).getRow(row).createCell(cell).setCellValue(data);
	  
	  FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata/VtigerData.xlsx");
	  workbook.write(fos);
	  workbook.close();
	  
	
}


public int getRowCount(String Sheet) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata/VtigerData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	int count=workbook.getSheet(Sheet).getLastRowNum();
	workbook.close();
	return count;
	
}


}
