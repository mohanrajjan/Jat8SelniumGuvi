package org.testpack.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task18Sel {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("User");
		
		
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  
		  WebElement email = driver.findElement(By.xpath("//div[text()='Mobile number or email address']"));
		  wait.until(ExpectedConditions.invisibilityOf(email));
		email.sendKeys("testuser18@test.com");
		WebElement pass = driver.findElement(By.xpath("//div[text()='New password']"));
		wait.until(ExpectedConditions.visibilityOf(pass));
		pass.sendKeys("Manhat@123");
		WebElement day = driver.findElement(By.id("day"));
		Select dy= new Select(day);
		dy.selectByIndex(10);
		WebElement mon = driver.findElement(By.id("month"));
		Select mm= new Select(mon);
		mm.selectByValue("5");
		WebElement Year = driver.findElement(By.id("year"));
		Select yy = new Select(Year);
		yy.selectByVisibleText("1985");
		driver.findElement(By.xpath("//label[text()='Male']")).click();
//https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver
	}

}
