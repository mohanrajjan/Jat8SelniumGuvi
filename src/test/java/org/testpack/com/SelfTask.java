package org.testpack.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelfTask {

	public static void main(String[] args) {
		//ChromeDriver is used to initialize the Chrome browser
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				//get() method is used to navigate to the webpages.
				driver.get("https://www.wikipedia.org/");
		//using Manage method with window and maximize, we can maximize the window
				driver.manage().window().maximize();
		driver.findElement(By.id("searchInput")).sendKeys("Artificial Intelligence");
		driver.findElement(By.xpath("//i[text()='Search']")).click();
		driver.findElement(By.xpath("(//span[text()='View history'])[1]")).click();
		//using get title we can get the current page title
				String title = driver.getTitle();
	//printing the page title
				System.out.println(title);
				
	}

}
