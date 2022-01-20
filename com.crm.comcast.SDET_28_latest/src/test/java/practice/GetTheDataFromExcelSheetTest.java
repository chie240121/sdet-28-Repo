package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetTheDataFromExcelSheetTest {

	//get string cell value using apache poi
		
	public static void main(String[] args) throws Throwable {
		//java object representation for physical excel sheet
		 FileInputStream fis =	new FileInputStream("./src/test/resources/vtigerTestData.xlsx");
		 //create a work book for physical file object representation
		Workbook workbook = WorkbookFactory.create(fis);
		
		//get the control of sheet
		Sheet sheet = workbook.getSheet("Sheet1");
		//get the control of row and cell
		Cell rcell = sheet.getRow(1).getCell(2);
		String orgName = rcell.getStringCellValue();
		System.out.println(orgName);
		//close the workbook
		workbook.close();
		
	}

}
