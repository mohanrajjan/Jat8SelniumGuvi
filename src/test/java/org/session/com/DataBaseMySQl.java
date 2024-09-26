package org.session.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataBaseMySQl {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
       //"jdbc:mysql://"+host+":"+port+"/databasename
		String URL="jdbc:mysql://localhost:3306/GuviJat910";
		String UserName="root";
		String Password="Mohan@123";
		//Creating coonection to mysql

	
		//Create statement object to create the statement
		Connection con= DriverManager.getConnection(URL, UserName, Password);
		Statement s=con.createStatement();
		
		
		//Execute the query on stement
		ResultSet rs=s.executeQuery("Select * from Credential");
		//Goto next record as it points to the record before the first record
	
		rs.next();
		
		//Reading the values from result set - method - getString()
		
		String username=rs.getString("username");
		String password=rs.getString("password");
		
		rs.next();
		String username1=rs.getString("username");
		String password1=rs.getString("password");
		
		System.out.println(username);
		System.out.println(password);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.navigate().back();
		driver.findElement(By.id("user-name")).sendKeys(username1);
		driver.findElement(By.id("password")).sendKeys(password1);
		driver.findElement(By.id("login-button")).click();
			
	}

}
