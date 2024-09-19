package org.testpack.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framecs {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		List<WebElement> Ifel = driver.findElements(By.tagName("frame"));
		int n = Ifel.size();
		System.out.println("Number of frames in the webpage are "+n);
		WebElement e1 = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame("frame-top");
	}
}
