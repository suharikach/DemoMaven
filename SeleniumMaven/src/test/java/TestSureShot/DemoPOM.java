package TestSureShot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.LoginPage;
import TestSureShot.ExcelDataProvider;
import helper.utility;


public class DemoPOM {
	WebDriver driver;
	LoginPage login;
	
	@Test
	public void test1()
	{
		driver=utility.StartBrowser("Chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		login= new LoginPage(driver);
		ExcelDataProvider excel= new ExcelDataProvider();
		System.out.println(excel.ExcelDataValue("CRM", 0, 0));
	login.LogintoApplication(excel.ExcelDataValue("CRM", 0, 0)
			,				excel.ExcelDataValue("CRM",0,1));
	
	}
}
