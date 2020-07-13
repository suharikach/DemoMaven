package pages;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import helper.utility;

	public class LoginPage 
	{
	
		WebDriver driver;
		
		By username=By.id("txtUsername");
		By password=By.xpath("//input[@id='txtPassword']");
		By LoginButton=By.id("btnLogin");
		
		public LoginPage(WebDriver driver)
		{
			System.out.println("Log info:   ***** Login page ******");
			this.driver=driver;
			//System.out.println(driver.getTitle());
		}

		public void enterUserName(String user)
		{
			utility.WaitAndTypeValue(driver,user, username);
			
		//driver.findElement(username).sendKeys(user);
		}
		public void enterPassword(String pass)
		{
			utility.WaitAndTypeValue(driver, pass , password);
			//driver.findElement(password).sendKeys(pass);
		}
		public void clickLoginButton()
		{
			utility.WaitAndClick(driver, LoginButton);
			//driver.findElement(LoginButton).click();
		}
	
		public void LogintoApplication(String user, String pass)
		{
			System.out.println(user+"      "+pass);
			utility.WaitAndTypeValue(driver,user, username);
			utility.WaitAndTypeValue(driver, pass , password);
			utility.WaitAndClick(driver, LoginButton);
		}

	}



