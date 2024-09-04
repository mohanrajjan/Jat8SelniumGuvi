package org.excel.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteEx {
public static void main(String[] args) throws IOException {
	File src= new File("Utils\\Mydata.xlsx");
	//FileInputStream fs = new FileInputStream(src);
	XSSFWorkbook res= new XSSFWorkbook();
	XSSFSheet sheet1=res.createSheet("Employees");
	
	//FileOutputStream fos = new FileOutputStream(src);
	XSSFRow row1 = sheet1.createRow(0);
	row1.createCell(0).setCellValue("EmpName");
	row1.createCell(1).setCellValue("Age");
	row1.createCell(2).setCellValue("Dept");
	
	XSSFRow row2 = sheet1.createRow(1);
	row2.createCell(0).setCellValue("Mani");
	row2.createCell(1).setCellValue("30");
	row2.createCell(2).setCellValue("IT");
	
	XSSFRow row3 = sheet1.createRow(2);
	row3.createCell(0).setCellValue("Raj");
	row3.createCell(1).setCellValue("27");
	row3.createCell(2).setCellValue("RPA");
	
	FileOutputStream fos = new FileOutputStream(src);
	res.write(fos);
	//res.close();
	int size =sheet1.getLastRowNum();
	int column=sheet1.getRow(0).getLastCellNum();
	for(int i=0; i<=size; i++) {
		for(int j=0; j<column; j++) {
		String data=sheet1.getRow(i).getCell(j).getStringCellValue();
		System.out.print(data +" ");
	}
		System.out.println();
}
}
}
