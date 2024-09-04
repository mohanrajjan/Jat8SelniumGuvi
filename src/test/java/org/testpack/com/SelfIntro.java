package org.testpack.com;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelfIntro {
public static void main(String[] args) throws InterruptedException {
	//Creating driver interface for chrome browser
	WebDriver driver = new ChromeDriver();
	//Applying implicitwait method for synchronizing browser & Selenium
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	driver.manage().window().maximize();
	//driver.findElement(By.id("inputUsername")).sendKeys("mohanraj");
	//Locating element by using CssSelector-> id#id value
	driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("mohanraj");
	driver.findElement(By.name("inputPassword")).sendKeys("Mohan@123");
	//Locating element by using CssSelevtor-> tagname.classname
	driver.findElement(By.cssSelector("button.submit")).click();
	
	System.out.println(driver.findElement((By.cssSelector("p.error"))).getText());
	
	// Clicking on the link by Linktext locator
	driver.findElement(By.linkText("Forgot your password?")).click();
	
	//Partial linktext Locator
	//driver.findElement(By.partialLinkText("Forgot")).click();
	
	//Xpath locator //tagname[@attribute="attributename"]
	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("mohanraj");
	 //Css Selector using Xpath //tagname[@Attribute='Attribute name']
	driver.findElement(By.cssSelector("input[placeholder=Email]")).sendKeys("mohanraj@gmail");
    //
	driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("9896");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
	
	String Ftext = driver.findElement(By.cssSelector("p.infoMsg")).getText();
    System.out.println(Ftext);
    String pswd = Ftext.substring(31, 49);

    driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
    driver.findElement(By.id("inputUsername")).sendKeys("mohanraj");
    //using regex for locators
    driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys(pswd);
   Thread.sleep(2000);
   //Clicking on the check box
   driver.findElement(By.id("chkboxOne")).click();
    driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
    Thread.sleep(1000);
    String text = driver.findElement(By.tagName("p")).getText();
    System.out.println(text);
    Assert.assertEquals("You are successfully logged in.", text);
}
}
