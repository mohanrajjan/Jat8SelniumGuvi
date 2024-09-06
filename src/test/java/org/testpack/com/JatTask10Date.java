package org.testpack.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JatTask10Date {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		//using iframe tag name we can able to get total no of frames in web page
		List<WebElement> frameele = driver.findElements(By.tagName("iframe"));
		int FrameNo = frameele.size();
		System.out.println(FrameNo);
		WebElement fram = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		Thread.sleep(2000);
		//SwitchTo frame method we switching to the frame inside web page
		driver.switchTo().frame(fram);
		//using click method we can choose date from the calendar
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//a[text()='10']")).click();
		Thread.sleep(2000);
		WebElement datetex= driver.findElement(By.id("datepicker"));
		//getText method is used to print the text of the WebElement
		//get value, attributetype, cssvalue, attribute name
		String text = datetex.getAttribute("value");
		System.out.println(text);
		//close method is used to close the current window
		//driver.close();
		//quit method is used to close all associated window
		driver.quit();

	}

}
