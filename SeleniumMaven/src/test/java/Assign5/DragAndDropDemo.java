package Assign5;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import day9.SwitchToFramDemo;

public class DragAndDropDemo 
{
	WebDriver driver;
	@Test
	public void test2()
	{
		System.out.println("hehe");
	}
	@Test
	public void test()
	{
	 
	System.out.println("hello");
	System.setProperty("webdriver.chrome.driver", "D:/selinium/chromedriver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebElement ele=SwitchToFramDemo.switchToFrameDemo1(driver,"//input[@class='_8esa' and @value='1']");
	
	ele.click();
	FluentWait<WebDriver> w= new FluentWait<WebDriver>(driver)
			.pollingEvery(Duration.ofSeconds(2)).withTimeout(Duration.ofSeconds(10));
	
	w.until(new Function<WebDriver,WebElement>()
			{

				public WebElement apply(WebDriver arg0) {
					WebElement we=driver.findElement(By.xpath("//input[@class='_8esa' and @value='0']"));
					
					if(we != null)
					{
						we.click();
						return we;
					}
					else
						return null;
				}
		
			});
	driver.findElement(By.xpath("//input[@class='_8esa' and @value='2']")).click();
	//Actions act= new Actions(driver);
	//act.dragAndDrop(driver.findElement(By.xpath("//span[text()='Learning DHTMLX Suite UI']")), driver.findElement(By.xpath("//*[@class='dhx_widget dhx_list ']"))).perform();
	/*act.clickAndHold(driver.findElement(By.xpath("//span[text()='Learning DHTMLX Suite UI']"))).pause(5).
	moveToElement(driver.findElement(By.xpath("//*[@class='dhx_widget dhx_list ']")))
	.build().perform();*/
	
	
	}

}