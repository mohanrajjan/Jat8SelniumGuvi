package org.testpack.com;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class Task11Window {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Click Here")).click();
		//Using getWindowHandle method to locate parent window
		String Parent = driver.getWindowHandle();
		String parenttitle = driver.getTitle();
		System.out.println(parenttitle);
		//using get window handles method to get all windows in the browser
		Set<String> AllWindows = driver.getWindowHandles();
		Iterator<String> iterat = AllWindows.iterator();
		while(iterat.hasNext()) {
			String childWindow = iterat.next();
			//using if condition switching to new window
			if(!Parent.equals(childWindow)) {
	//using switch to & window method to switch from one window to another
				driver.switchTo().window(childWindow);
				driver.manage().window().maximize();
		//using get text method to get the value from web page
		  String text = driver.findElement(By.xpath("//h3[text()='New Window']"))
		.getText();
		  System.out.println(text);
		  //using Assert equals we verify the new window
		  Assert.assertEquals(text, "New Window");
			}
	}
		//close method is used to close the current window
		driver.close();
		driver.switchTo().window(Parent);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(parenttitle, title);
		//Using quit method we can close browser instance
		driver.quit();
	}
}
