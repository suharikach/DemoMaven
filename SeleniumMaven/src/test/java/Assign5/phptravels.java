package Assign5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class phptravels  {
WebDriver driver;
JavascriptExecutor js;
	public static void main(String[] args) throws InterruptedException {
		phptravels s1= new phptravels();
		s1.launchBrowser();
		s1.launchURL();
		s1.Navigatelogin();
		s1.screenshot();
		s1.login();
		s1.screenshot();
		s1.flights();
		s1.selectdate();
		s1.selectPassengers();
		s1.flightResults();
		s1. BookFlight();
		s1.close();
	  }
	
	public void screenshot()
	{
		TakesScreenshot ss= (TakesScreenshot)driver;
		//File src=ss.getScreenshotAs(OutputType.FILE);
	//	File dest=new File("C:\\Users\\HP\\eclipse-workspace\\SeleniumMaven\\Screenshot\\1.png");
		try
		{
			FileHandler.copy(ss.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\HP\\eclipse-workspace\\SeleniumMaven\\Screenshot\\1.png"));
			
		} catch(IOException e)
		{
			System.out.println("unable to capture screenshot");
		}
		
	}
	public void Navigatelogin() 
	{
		driver.findElement(By.xpath("//div[@class='mini-menu'] //a[text()= ' My Account                  ']")).click();
		driver.findElement(By.xpath("//a[text()= 'Login']")).click();
		
		String url=driver.getCurrentUrl();
		if(url.contains("login"))
			System.out.println("URL Match");
		else
			System.out.println("URL mismatch");
	}
	public void login()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user@phptravels.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demouser");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@title='home']")).click();
		//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("CLicked on home");
		//driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
	}
	public void close()
	{
		//driver.quit();
	}
	public void flights() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='home']")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Flights\")]")).click();
		String title=driver.getTitle();
		if(title.contains("Flights"))
			System.out.println("Title Match"+title);
		else
			System.out.println("title mismatch"+title);
		
		
		System.out.println("Click on radio button");
		//driver.findElement(By.xpath("//div[@class="tab-content"]// input[@id='flightSearchRadio-1']")).click();
		//driver.findElement(By.xpath("//input[@id='flightSearchRadio-2']")).click();
		Thread.sleep(30);
		driver.findElement(By.xpath("//label[text()='From']//following::input[@id='s2id_autogen3']")).sendKeys("bang");
		System.out.println(" From Drpdown values");
		selectDropDown("Bangalore (BLR)");
		
		//select value in the to test field
		
		driver.findElement(By.xpath("//label[text()='To']// following::input[@id='s2id_autogen4']")).sendKeys("Del");
		System.out.println("To dropdown values");
		selectDropDown("Delhi (DEL)");
		}
	
	public void selectdate()
	{
		driver.findElement(By.id("FlightsDateStart")).click();
		driver.findElement(By.xpath("//*[@id='datepickers-container']/div[8]/nav/div[@class='datepicker--nav-title']/i")).click();

		String year= driver.findElement(By.xpath("//*[@id='datepickers-container']/div[8]/nav/div[@class='datepicker--nav-title']")).getText();
		System.out.println(year);
		driver.findElement(By.xpath("//*[@id='datepickers-container']/div[8]/nav/div[@class='datepicker--nav-title']")).click();
		List<WebElement> yearlist=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[8]//div[@class='datepicker--cell datepicker--cell-year']"));
		for(WebElement ele:yearlist)
		{
			if(ele.getText().equalsIgnoreCase("2021"))
			{
				System.out.println(ele.getText());
				ele.click();
				break;
			}
				
		}
		List<WebElement> month=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[8]//div[@class='datepicker--cell datepicker--cell-month']"));
		for(WebElement ele1:month)
		{
			if(ele1.getText().equalsIgnoreCase("Jan"))
			{
				System.out.println(ele1.getText());
				ele1.click();
				break;
				
			}
		}
		 js=(JavascriptExecutor)driver;
		List<WebElement> day=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[8]//div[@class='datepicker--cells datepicker--cells-days']/div"));
		for(WebElement ele2:day)
		{
			System.out.println(ele2.getText());
			if(ele2.getText().equalsIgnoreCase("20"))
			{
				System.out.println(ele2.getText());
				js.executeScript("arguments[0].click()", ele2);
				//ele2.click();
				break;
			}
		}
		
    
      
       
	}
	public void selectPassengers()
	{
		String adultcount;
			do
			{
				driver.findElement(By.xpath("//*[@id=\"flights\"]//label[contains(text(),'Adults')]//following-sibling::div[@class='form-icon-left']//button[@class='btn btn-white bootstrap-touchspin-up ']")).click();
			adultcount=driver.findElement(By.xpath("//input[@name='fadults']")).getAttribute("value");
			//System.out.println(adultcount);	
			}while(!adultcount.equals("2"));
			System.out.println("Adults added"+driver.findElement(By.xpath("//input[@name='fadults']")).getAttribute("value"));	
			
			String infants;
			do
			{
				driver.findElement(By.xpath("//*[@id=\"flights\"]//label[contains(text(),'infant ')]//following-sibling::div[@class='form-icon-left']//button[@class='btn btn-white bootstrap-touchspin-up ']")).click();
				infants=driver.findElement(By.xpath("//input[@name='finfant']")).getAttribute("value");
			}while(!infants.equals("2"));
			System.out.println("Infants added"+infants);
			driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-12']//button[@class='btn-primary btn btn-block' and contains(text(),'Search')]")).click();
			
	}
	public void flightResults()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement>flightCharge=driver.findElements(By.xpath("//p[@class='theme-search-results-item-price-tag']/strong"));
	
		List<WebElement>flightName=driver.findElements(By.xpath("//h5[@class='theme-search-results-item-flight-section-airline-title']"));
		//WebElement we1=flightName.get(index)
		for(int i=0; i<flightCharge.size();i++ )
		{
			System.out.println("The ticket fair for "+flightName.get(i).getText()+" is "+flightCharge.get(i).getText());
		}
		
		
	}
	public void BookFlight()
	{
		driver.findElement(By.xpath("//ul[@id='LIST']/li[1]//button")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[text()='Booking Summary']")));
		if(driver.getCurrentUrl().contains("checkout"))
		{
			System.out.println("URL contains checkout");
		}
		else
			System.out.println("URL do not contains checkout");
	}
	
		public void selectDropDown(String city)
		{
			List<WebElement>from=driver.findElements(By.xpath("//div[@id='select2-drop'] //ul[@class='select2-results']/li/div"));
			for(WebElement we:from)
			{
				
				String f=we.getText();
				
				System.out.println(f);
			}
			for(WebElement we:from)
			{
				//System.out.println(we);
				if(we.getText().equalsIgnoreCase(city))
				{
				we.click();
				System.out.println("Click performed");
				break;
				}
			}
		}
	
	public void launchURL() {
		driver.get("https://www.phptravels.net/index.php");
		String title=driver.getTitle();
		if(title.contains("Travel"))
			System.out.println("Title Match");
		else
			System.out.println("title mismatch");
		}
	  public void launchBrowser() {
			System.setProperty("webdriver.chrome.driver", "D:/selinium/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			//System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
			//driver = new InternetExplorerDriver();
			driver.manage().window().maximize();

		}
}
