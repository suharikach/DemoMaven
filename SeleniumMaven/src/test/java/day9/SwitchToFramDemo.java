package day9;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToFramDemo {
	
	WebDriver driver;
	
	public static WebElement switchToFrameDemo1(WebDriver driver, String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement framea=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		if(framea != null)
		{
			return framea;
		}
		else 
			return null;
	}
	
}
