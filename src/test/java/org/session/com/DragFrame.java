package org.session.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DragFrame {
public static void main(String[] args) {
	/*iframes used to insert any contents from other sources
	1)Swith to frame(index of frame)
    2)Swith to frame(id of frame)
    3)Swith to frame(webelement)*/
	
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demo.guru99.com/test/guru99home/");
	driver.manage().window().maximize();
	List<WebElement> Iframeelements = driver.findElements(By.tagName("iframe"));
	int n = Iframeelements.size();
	System.out.println("Number of frames on the page are "+n);
	driver.switchTo().frame("a077aa5e");
	driver.findElement(By.xpath("//html/body/a/img")).click();
    //driver.close();
    driver.quit();
}
}
