package com.crm.comcast.GenricUtility;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author kajal
 *
 */
public class ExcelUtilityPurchase {
	
	/**
	 * This method will return the string value from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
		public String getStringData(String sheetName, int rowNo , int cellNo) throws Throwable {
			FileInputStream file = new FileInputStream(IpathConstants.EXCEL_SHEET_PATH_PURCHASE);
			Workbook workbook = WorkbookFactory.create(file);
		return	workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();		
}
		/**
		 * This method will return numeric cell value
		 * @param sheetNo
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws Throwable
		 */
		public double getNumericCellData(String sheetNo, int rowNo, int cellNo) throws Throwable {
			
			FileInputStream file = new FileInputStream(IpathConstants.EXCEL_SHEET_PATH_PURCHASE);
			Workbook workbook = WorkbookFactory.create(file);
		return	workbook.getSheet(sheetNo).getRow(rowNo).getCell(cellNo).getNumericCellValue();
		
		}
			
		/**
		 * this method will multiple set of data from excel sheet
		 * @param sheetNum
		 * @return 
		 * @throws Throwable
		 */
		public Object[][] getMultipleData(String sheetNum ) throws Throwable {
			FileInputStream file = new FileInputStream(IpathConstants.EXCEL_SHEET_PATH_PURCHASE);
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet(sheetNum);
			int rowNo = sheet.getLastRowNum();
			int cellNo = sheet.getRow(0).getLastCellNum();
			Object[][]data = new Object[rowNo][cellNo];
			for (int i = 0; i < rowNo; i++) {
				for (int j = 0; j < cellNo; j++) {
					data[i][j] = sheet.getRow(i).getCell(j).toString();
					
				}
			}
			
			return data;
			
		}
		/**
		 * this method will write the data into excel sheet
		 * @param sheetName
		 * @param rowNo
		 * @param cellNo
		 * @param value
		 * @throws Throwable
		 */
		public void writeDataIntoExcel(String sheetName, int rowNo , int cellNo , String value) throws Throwable {
			FileInputStream readfile = new FileInputStream(IpathConstants.EXCEL_SHEET_PATH_PURCHASE);
			Workbook workbook = WorkbookFactory.create(readfile);
			workbook.createSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(value);
			FileOutputStream writefile = new FileOutputStream(IpathConstants.EXCEL_SHEET_PATH_PURCHASE);
			workbook.write(writefile);
			workbook.close();
		}
}
