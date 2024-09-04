package org.session.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTabCls {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
		int colssize = cols.size();
		System.out.println(colssize);
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		int rowssize = rows.size();
		System.out.println(rowssize);
		//reading the valuefrom the table
		String text = driver.findElement(By.xpath("//table/tbody/tr[3]/td[4]"))
				.getText();
		System.out.println(text);
	}

}
