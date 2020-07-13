	package helper;

	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriverException;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class utility {
		public static void highLightElement(WebDriver driver, WebElement element)
			{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		 
		try 
		{
		Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
		 
		System.out.println(e.getMessage());
		} 
		 
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
		 
		}
		public static WebDriver StartBrowser(String browsertype, String url)
		{ 
			WebDriver driver=null;
		
			if(browsertype.equalsIgnoreCase("Chrome"))
			{
			
				System.setProperty("webdriver.chrome.driver", "D:/selinium/chromedriver/chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browsertype.equalsIgnoreCase("IE"))
			
			{		
				System.setProperty("webdriver.ie.driver", "D:/selinium/IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			return driver;
		}
		
		// using xpath
		public static void WaitAndTypeValue(WebDriver driver, String value, String xpath )
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			ele.clear();
			highLightElement(driver, ele);
				ele.sendKeys(value);
				System.out.println("**** Value Entered in the field****");
		}
		public static String WaitAndGetText(WebDriver driver, String xpath )
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
				WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				System.out.println("**** Get the text****");
				highLightElement(driver, ele);
				return driver.findElement(By.xpath(xpath)).getText();
		}
		
		//using BY element
		public static void WaitAndTypeValue(WebDriver driver, String value, By ele  )
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement elem=wait.until(ExpectedConditions.elementToBeClickable(ele));
				highLightElement(driver, elem);
				elem.sendKeys(value);
				System.out.println("**** Value Entered in the field****");
		}

		public static String Screenshoot(WebDriver driver)
		{
			TakesScreenshot ts= (TakesScreenshot)driver;
			File src =ts.getScreenshotAs(OutputType.FILE);
			
			File dest=new File(System.getProperty("user.dir")+"/screenshot/selenium.img");
			try {
				FileHandler.copy(src,dest);
				}
			catch (IOException e) {
				
				System.out.println("File not copied"+e.getMessage());
				
			}
			return System.getProperty("user.dir")+"/screenshot/selenium.img";
		}
		//using BY 
		public static void WaitAndClick(WebDriver driver, By ele)
		{
			WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			WebElement elem=wait.until(ExpectedConditions.elementToBeClickable(ele));
			highLightElement(driver, elem);
			elem.click();
			System.out.println("****Click performed****");
		}
		public static void WaitAndSelectFromDropdown(WebDriver driver, By ele, String VisibleText )
		{
			WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			//new Select(driver.findElement()).selectByVisibleText("Admin");
			WebElement selectdropdown =wait.until(ExpectedConditions.elementToBeClickable(ele));
			highLightElement(driver, selectdropdown );
			Select dropdown=new Select(selectdropdown);
			dropdown.selectByValue(VisibleText);
			System.out.println("****Dropdown Value selected****");
		}

		
		//using path
	public static void WaitAndClick(WebDriver driver, String xpath)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		highLightElement(driver, ele);
		ele.click();
		System.out.println("****Click performed****");
	}
	public static void WaitAndClick(WebDriver driver, WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		highLightElement(driver, ele);
		ele.click();
		System.out.println("****Click performed****");
	}
	}


