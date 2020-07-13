package day9;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest02 {
	WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:/selinium/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		driver.manage().window().maximize();

	}
  @Test
  public void launchURL() {
driver.get("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
//locating username field
WebElement username=driver.findElement(By.id("userName"));
//sending input to username field
username.sendKeys("Lalitha");

driver.findElement(By.id("password")).sendKeys("Password123");
driver.findElement(By.name("Login")).click();

	  }
  
  @AfterClass
  public void close() {
	  driver.close();
  }
}
