package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CheckFirstCellValueAndGetSecondCellValueTest {
	//if first cell has expected value fetch second cell data 
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		String cellData = "createOrganization";
		int rowNo = sheet.getLastRowNum();
		for (int i = 1; i <=rowNo; i++) {
		Row row = sheet.getRow(i);
		String firtCellData = row.getCell(0).getStringCellValue();
		if(firtCellData.equals(cellData)) {
			String secondCellValue = row.getCell(1).getStringCellValue();
			System.out.println(secondCellValue);
		}
		workbook.close();
		}
		
		
		
	
	}

	
	}

