package org.testpack.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExce {
public static void main(String[] args) throws IOException {
	//Referring to the file read and write
	File sr= new File("Utils\\student.xlsx");
	//inputsteam reads files with form of bytes- image too
	FileInputStream xs = new FileInputStream(sr);
	//opening the workbook
	XSSFWorkbook wk = new XSSFWorkbook(xs);
	
	//opening the excel sheet with index
	XSSFSheet re=wk.getSheetAt(0);
	//XSSFSheet re=wk.getSheet("sheet1"); opening with sheet name
	//reading no of rows in the sheet
	int size =re.getLastRowNum();
	
	//reading no of columns in the sheet
	int column=re.getRow(0).getLastCellNum();
	//System.out.println(column);	
	for(int i=0; i<=size; i++) {
		for(int j=0; j<column; j++) {
			//opening cell to read
		String data=re.getRow(i).getCell(j).getStringCellValue();
		System.out.print(data +" ");
	}
		System.out.println();
}
}
}