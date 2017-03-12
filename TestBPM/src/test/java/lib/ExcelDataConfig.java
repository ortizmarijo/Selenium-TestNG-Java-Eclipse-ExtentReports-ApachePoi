package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataConfig(String ExcelPath) throws FileNotFoundException{
		
		try {
			File src= new File(ExcelPath);
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}


public String GetData(int sheetNumber, int row, int colunm){
	
	sheet1 = wb.getSheetAt(sheetNumber);
	
	String data=sheet1.getRow(row).getCell(colunm).getStringCellValue();
	
	return data;
	
}

public int GetRowCount(int sheetIndex)
{
	int row = wb.getSheetAt(sheetIndex).getLastRowNum()+1;
	
	return row;
}



}