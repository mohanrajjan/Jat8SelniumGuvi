package org.testpack.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Task11FrmeCls {

	public static void main(String[] args) {
		/*iframes used to insert any contents from other sources
		1)Swith to frame(index of frame)
	    2)Swith to frame(id or name)
	    3)Swith to frame(webelement)*/
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		List<WebElement> Iframeelements = driver.findElements(By.tagName("frame"));
		int n = Iframeelements.size();
		System.out.println("Number of frames in the webpage are "+n);
		WebElement ele1 = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		//Switching to top frame using name
		driver.switchTo().frame("frame-top");
		List<WebElement> topframe = driver.findElements(By.tagName("frame"));
		int topsize = topframe.size();
		System.out.println("Number of frames in TopFrame is: " +topsize);
		//locating webelement using xpath
		WebElement leftframe = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		//Switching left frame using webelement
		driver.switchTo().frame(leftframe);
		String ltext = driver.findElement(By.tagName("body")).getText();
		System.out.println("Inside the frame: "+ltext);
		//Using hard Assertion to verify the frame using string
		Assert.assertEquals(ltext, "LEFT");
		//Switching back to top frame using parent frame method
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		WebElement middleframe = driver.findElement(By.id("content"));
		String mtext = middleframe.getText();
		Assert.assertEquals(mtext, "MIDDLE");
		System.out.println("Inside the frame: "+mtext);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-right");
		String rtext = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(rtext, "RIGHT");
		System.out.println("Inside the frame: "+rtext);
		driver.switchTo().parentFrame();
		//Switching back to web page using default content method
		driver.switchTo().defaultContent();
		//Switching to bottom frame using name
		driver.switchTo().frame("frame-bottom");
		String btext = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(btext, "BOTTOM");
		System.out.println("Inside the frame: "+btext);
		//Switching back to web page using default content method
		driver.switchTo().defaultContent();
	}

}
