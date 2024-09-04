package org.session.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Radio {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/radio.html");
		driver.manage().window().maximize();
		WebElement rd=driver.findElement(By.id("vfb-7-2"));
		rd.click();
		driver.findElement(By.id("vfb-6-0")).click();
		driver.findElement(By.id("vfb-6-1")).click();
        // Three method we can use on any webelement 
		// .isSelected()
		// .isDisplayed()
		// .isEnabled()
		if (rd.isSelected()) {
			System.out.println("Radio button is selected ");
		}
		else {
			System.out.println("Radio button not selected");
		}		
	 Assert.assertTrue(rd.isSelected());

	}

}
