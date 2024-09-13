package org.session.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExplicitCls {

	public static void main(String[] args) {
		//Selnium class to wait explicitly use Webdriver wait class
		WebDriver driver = new ChromeDriver();
		//Global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		WebElement element = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		
		//Explicit Wait - local to webelement
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println(element.getText());

	}

}
