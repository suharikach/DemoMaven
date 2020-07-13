package day9;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Amazon {
	WebDriver driver;
	@Test
	public void LaunchBrouser() throws InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver", "D:/selinium/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Actions a=new Actions(driver);
		driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();
		//Thread.sleep(2000);
	//	driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner' and text()='Sign in']")).click();
		
		String expected=driver.getTitle();
		String actual="Amazon Sign In";
		
		
		//System.out.println(sh);
	//	JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele=driver.findElement(By.xpath("//input[@id='ap_email']"));
		ele.sendKeys("suharika.ch@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Manognya@1");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		driver.findElement(By.xpath("//input[@name='s-ref-checkbox-10440599031']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='brandsRefinements']  //li[@aria-label='OnePlus'] //a")).click();
		driver.findElement(By.xpath("//h2[1]")).click();
		
		String paren=driver.getWindowHandle();
		String child;
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> i1= windows.iterator();
		while(i1.hasNext())
		{
			child=i1.next();
			if(!paren.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
		}
		}
			driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();

			driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Manognya@1");
			driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	}
}
