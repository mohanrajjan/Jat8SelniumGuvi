package org.session.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://demo.guru99.com/test/newtours/register.php");
//		WebElement ele1 = driver.findElement(By.name("country"));
//		//Creating object of select class and associating with Select tag webelement
//		Select ss= new Select(ele1);
//		ss.selectByValue("INDIA");
//		//ss.selectByIndex(0);
//		//ss.selectByVisibleText("INDIA");
//		//deselect methods are not supported in single-select
//		//ss.deselectByVisibleText("INDIA");
//		//ss.deselectAll();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.get("https://demoqa.com/select-menu");
    	WebElement ele2 = driver.findElement(By.name("cars"));
    	Select s1= new Select(ele2);
    	if(s1.isMultiple()) {
    		s1.selectByIndex(0);
    		s1.selectByVisibleText("Opel");
    		s1.selectByValue("audi");
    	}
    	else{
    		s1.selectByValue("opel");
    	}
    	List<WebElement> options = s1.getOptions();
    	List<WebElement> options1 = s1.getAllSelectedOptions();
    	
    	int size = options.size();
    	int size1 = options1.size();
    	System.out.println(size);
    	System.out.println(size1);
    	for(int i=0;i<size;i++) {
    		String opt = options.get(i).getText();
    		System.out.println(opt);
    	}
    	
	}

}
