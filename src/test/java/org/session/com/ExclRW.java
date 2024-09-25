package org.session.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExclRW {

	public static void main(String[] args) {
		ExclRW x=new ExclRW();
		
		for (int i=0; i<4; i++) {
			for (int j=0;j<2;j++) {
		     String data= x.getExcelData("Sheet1", i, j);
		     System.out.println(data);
			}
	}
	}
	
	
	public String getExcelData(String sheetName, int rowNum, int colNum) {
		String retVal=null;
		
		try {
			FileInputStream fis=new FileInputStream("Utils//Student.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet s=wb.getSheet(sheetName);
			XSSFRow r=s.getRow(rowNum);
			XSSFCell c=r.getCell(colNum);
			retVal=ExclRW.getCellValue(c);
			fis.close();
			wb.close();
			} 			
			 catch (FileNotFoundException e) {
			e.printStackTrace();
	    	
			 }  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		     }
		return retVal;
		
	}
	
	public static String getCellValue(XSSFCell c) {
		switch (c.getCellType()) {
		case NUMERIC:
			return String.valueOf(c.getNumericCellValue());  //10   -> "10"
		case BOOLEAN:
			return String.valueOf(c.getBooleanCellValue());
		case STRING:
			return c.getStringCellValue();
		default :	
			return c.getStringCellValue();
		}
				
	}



}
