package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExceldata {

	@DataProvider(name="Testdata")
	public static String[][] createjobdata(ITestNGMethod M) throws IOException {
	//public static void main(String[] args) throws IOException {
		String classname=M.getRealClass().getSimpleName();
		String[][] arrayObject = getExcelData("TestData.xlsx",classname);
	
		return arrayObject;
	}


	public static String[][] getExcelData(String fileName, String sheetName) throws IOException {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet(sheetName);
			XSSFRow row;
			int totalNoOfRows = sh.getLastRowNum();
			System.out.println(totalNoOfRows);
			row=sh.getRow(totalNoOfRows);
			int totalNoOfCols = row.getLastCellNum();
		
			
			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];
			
			for (int i= 1 ; i <= totalNoOfRows; i++) {

				for (int j=0; j <totalNoOfCols; j++) {
					
				XSSFCell cell = sh.getRow(i).getCell(j);
				System.out.println("Celldata"+cell);
				DataFormatter formatter=new DataFormatter();
				String celldata=formatter.formatCellValue(cell);
				arrayExcelData[i-1][j]=celldata;
				System.out.println(arrayExcelData[i-1][j]);
				
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return arrayExcelData;
	}

	}

