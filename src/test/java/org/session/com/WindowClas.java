package org.session.com;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowClas {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		Thread.sleep(1000);//windowButton tabButton
		driver.findElement(By.id("windowButton")).click();
		int winsize = driver.getWindowHandles().size();
		System.out.println(winsize);
		String parentWin = driver.getWindowHandle();
		System.out.println(parentWin);
		//getting handles of all window opened
		Set<String> allWindow = driver.getWindowHandles();
		//Iterator through the SET
		Iterator<String> iterator = allWindow.iterator();
		while(iterator.hasNext()) {
		String childWindow = iterator.next();
		if(!parentWin.equals(childWindow)) {
			driver.switchTo().window(childWindow);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			String text = driver.findElement(By.id("sampleHeading")).getText();
			System.out.println(text);
		}
	}
		driver.switchTo().window(parentWin);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		driver.close();
	}
}
