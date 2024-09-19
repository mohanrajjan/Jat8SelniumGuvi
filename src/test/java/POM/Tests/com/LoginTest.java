package POM.Tests.com;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POMObjectRepository.RediffLoginPage;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		RediffLoginPage rr = new RediffLoginPage(driver);
		rr.EnterData("Mohan", "Raj");
		rr.clickLogo();
	}

}
