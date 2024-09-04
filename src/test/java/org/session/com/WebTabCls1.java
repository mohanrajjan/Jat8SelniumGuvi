package org.session.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTabCls1 {

	public static void main(String[] args) {
		
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://demo.guru99.com/test/table.html");
		  driver.manage().window().maximize(); List<WebElement> rows =
		  driver.findElements(By.xpath("//table/tbody/tr"));
		 
		int rowcount = rows.size();
		System.out.println(rowcount);
		//Asserting the test on number of rows
		Assert.assertEquals(5, rowcount);
		for(int i=0;i<rowcount;i++) {
		List<WebElement> cols= rows.get(i).findElements(By.tagName("td"));
		int colsize = cols.size();
		System.out.println("Number of cells in row" +i+ "are " +colsize);
		}
	}

}
