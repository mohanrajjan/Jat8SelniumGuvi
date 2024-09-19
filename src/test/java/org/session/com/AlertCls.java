package org.session.com;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertCls {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();
        alert.accept();
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		alert.dismiss();
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		String text=alert.getText();
		System.out.println(text);
		Thread.sleep(1000);
		alert.sendKeys("Vicky");
		Thread.sleep(3000);
		//alert.accept();
	}

}
