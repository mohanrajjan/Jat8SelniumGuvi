package POMObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffLoginPage {
	
	  WebDriver driver;
	  public RediffLoginPage(WebDriver driver) { this.driver =
	  driver; }
	 
By username=By.id("login1");
By Passwd=By.id("password");
By link=By.linkText("rediff.com");
By SignButton=By.xpath("//input[@type='submit']");

public void EnterData(String uname, String pass) {
	driver.findElement(username).sendKeys(uname);
	driver.findElement(Passwd).sendKeys(pass);
	//driver.findElement(SignButton).click();
}
public void clickLogo() {
	driver.findElement(link).click();
}
}
