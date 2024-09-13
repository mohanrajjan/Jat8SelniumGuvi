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
		//using iframe tag name we can able to find the number of frmaes in webpage
		List<WebElement> iframeelements = driver.findElements(By.tagName("iframe"));
		int n = iframeelements.size();
		System.out.println("Number of frames on the page are "+n);
		Thread.sleep(2000);
		//We can switch to frame using
		//SwitchToframe using index, id, Webelement
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		//switching frame using webelement
		driver.switchTo().frame(frame);
		//using Actions class to drag & drop the element
		//Drag&drop method has two arguments source and destinations
		Actions aa= new Actions(driver);
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Des = driver.findElement(By.id("droppable"));
		aa.dragAndDrop(Source, Des).build().perform();
		WebElement ele1= driver.findElement(By.id("droppable"));
		//using Css value wecan able to pull background, front size&color of the webelement
		String backcolor = ele1.getCssValue("background");
		System.out.println(backcolor);
		//getText method is used to get the text of the webelement
		String text = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		System.out.println(text);
		//Using Assertion we can able to verify the text of the webelement
		//Assertion are with 3 types, AssertEquals, true & False
		//for hardAssertion if its failed program will terminate then and there
		//for Softassertion it will continue the program and after execution it will
		//show where the program is failed
		Assert.assertEquals("Dropped!", text);	
	}

}
