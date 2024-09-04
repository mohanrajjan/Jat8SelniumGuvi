package org.testpack.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelfFireFox {

	public static void main(String[] args) {
		//FireFoxDriver is used to initialize the firefox browser
		WebDriver driver = new FirefoxDriver();
//using Manage method with window and maximize, we can maximize the window
		driver.manage().window().maximize();
		//get() method is used to navigate to the webpages.
		driver.get("http://google.com");
		//getCurrentURL method is used to get the current page URl
		String currentUrl = driver.getCurrentUrl();
		//It is used to print the statements
		System.out.println(currentUrl);
		//Using navigate we can do forward, backward and refresh the current window
		driver.navigate().refresh();
		//close method is used to close the current browser window
		driver.close();
		//Quit is used to close all the opened browser
		//driver.quit();
	}
}
