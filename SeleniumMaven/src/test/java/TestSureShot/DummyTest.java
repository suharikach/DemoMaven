package TestSureShot;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DummyTest extends BaseClass
{
	//WebDriver driver;
	MoneyControlProject mp;
	MoneyControlTopGainers mp1;
	@Test
	public void loginWIthAdmin()
	{
		
		System.out.println("Log info **** load test case ******");
		mp=new MoneyControlProject(driver);
		//login=PageFactory.initElements(driver, LoginPage.class);
		logger=Reports.createTest("test","Login into CRM application description");
		mp=PageFactory.initElements(driver, MoneyControlProject.class);
		Assert.assertEquals(mp, "true");
		
	}
	
	
	
}