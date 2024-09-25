package org.excel.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAdvanEx {
	public static void main(String[] args) throws IOException {
		File sr= new File("Utils//student.xlsx");
		//inputsteam reads files with form of bytes- image too
		FileInputStream xs = new FileInputStream(sr);
		//opening the workbook
		XSSFWorkbook wk = new XSSFWorkbook(xs);
		
		//opening the excel sheet with index
		XSSFSheet sheet=wk.getSheetAt(0);
		
		//XSSFSheet re=wk.getSheet("sheet"); 
		//opening with sheet name
		
		//reading no of rows in the sheet
		//int rowsize =sheet.getLastRowNum();
		int rowsize1 =sheet.getPhysicalNumberOfRows();
		
		
//		reading no of columns in the sheet
			
		for(int i=0; i<rowsize1; i++) {
			XSSFRow row = sheet.getRow(i);
			int column=sheet.getRow(0).getLastCellNum();

			System.out.println(column);
			for(int j=0; j<column; j++) {
			String data=sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.print(data +" ");
		}
		System.out.println();
	}
		wk.close();
	}
		
	/*
	 * public static String getCellValue(XSSFCell cell) { switch
	 * (cell.getCellType()) { case NUMERIC: return
	 * String.valueOf(cell.getNumericCellValue()); case BOOLEAN: return
	 * String.valueOf(cell.getBooleanCellValue()); case STRING: return
	 * cell.getStringCellValue(); default: return cell.getStringCellValue();
	 * 
	 * }
	 */

	
	
	}
	
