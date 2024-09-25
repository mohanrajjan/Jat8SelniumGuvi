package org.session.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelRWSelenium {
	public static void main(String[] args) {

	 //Calling getExcelData method to read the data from excel
	ExcelRWSelenium x=new ExcelRWSelenium();
	WebDriver driver = new ChromeDriver();
	for (int i=0;i<4;i++) {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		for (int j=0;j<2;j++) {
			String uname=x.getExcelData("Sheet1", i, j);
			driver.findElement(By.id("login1")).sendKeys(uname); // Amit
			j=j+1;
			String psw=x.getExcelData("Sheet1", i, j);
			driver.findElement(By.id("password")).sendKeys(psw); //Reddy
			
			driver.findElement(By.linkText("rediff.com")).click();
			
			String ExpectedTitle="Rediff.com: News | Rediffmail | Stock Quotes | Shopping";
			String ActualTitle=driver.getTitle();
			System.out.println(ActualTitle);
			if (ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
				String result="Pass";
				x.writeToExcel("Sheet1", i, 2, result);
			} else {
				String result="Fail";
				x.writeToExcel("Sheet1", i, 2, result);
			}
		} //  row pass done 
		
	}

	/*
	 * for (int i=0;i<4;i++) { for (int j=0;j<2;j++) {
	 * System.out.print(x.getExcelData("Sheet1", i, j) + " "); }
	 * System.out.println(" "); }
	 * 
	 * x.writeToExcel("Sheet1", 0, 2, "Pass"); x.writeToExcel("Sheet1", 1, 2,
	 * "Fail"); x.writeToExcel("Sheet1", 2, 2, "Pass"); x.writeToExcel("Sheet1", 3,
	 * 2, "Pass");
	 */
}

public void writeToExcel(String sheetName, int rowNum, int cellNum, String desc) {
	FileInputStream fis;
	XSSFWorkbook wb;
	try {
		fis = new FileInputStream("Utils//Student.xlsx");
		wb = new XSSFWorkbook(fis);
		XSSFSheet s=wb.getSheet(sheetName);
		XSSFRow r=s.getRow(rowNum);
		XSSFCell c=r.createCell(cellNum);
		c.setCellValue(desc);
		FileOutputStream fos=new FileOutputStream("Utils//Student.xlsx");
		wb.write(fos);
		fos.close();
		fis.close();
		wb.close();
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
		retVal=ExcelRWSelenium.getCellValue(c);
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
