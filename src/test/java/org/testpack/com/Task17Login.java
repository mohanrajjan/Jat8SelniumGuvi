package org.testpack.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task17Login {
public static void main(String[] args) {
	//Creating driver interface for chrome browser
	WebDriver driver = new ChromeDriver();
	//Applying implicitwait method for synchronizing browser & Selenium
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.get("https://www.demoblaze.com/");
	//Maximize window
	driver.manage().window().maximize();
	//Locating element by using linktext
	WebElement ele1 = driver.findElement(By.linkText("Log in"));
	//Actions class is used to handle keyboard and mouse functionality
	Actions aa= new Actions(driver);
	//using click method in action class with moving cusor to the specific location
	aa.moveToElement(ele1).click()
	.build()//Asking Actions class to work with webdriver to perform the actions
	.perform();//Asking Actions class to excute the tasks
	driver.findElement(By.id("loginusername")).sendKeys("Mohan0191");
	WebElement passwd = driver.findElement(By.id("loginpassword"));
	//using sendkeys to send data to the element
		aa.sendKeys(passwd, "Mohan@123").build().perform();
	driver.findElement(By.xpath("//button[text()='Log in']")).click();
	WebElement userdetails = driver.findElement(By.partialLinkText("Welcome"));
	//gettext method is used to get the text from the element located
	String text = userdetails.getText();
	System.out.println(text);
	
	
}
}
