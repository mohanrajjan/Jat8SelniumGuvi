package org.testpack.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class JatTask10Drag {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		List<WebElement> iframeelements = driver.findElements(By.tagName("iframe"));
		int n = iframeelements.size();
		System.out.println("Number of frames on the page are "+n);
		Thread.sleep(2000);
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		Actions aa= new Actions(driver);
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Des = driver.findElement(By.id("droppable"));
		aa.dragAndDrop(Source, Des).build().perform();
		WebElement ele1= driver.findElement(By.id("droppable"));
		String backcolor = ele1.getCssValue("background");
		System.out.println(backcolor);
		String text = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		System.out.println(text);
		Assert.assertEquals("Dropped!", text);
		
	}

}
