package TestSureShot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.utility;

public class MoneyControlTopGainers {
WebDriver driver;
XSSFWorkbook wb = null;
XSSFSheet ws;
int col=0;
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
Date date = new Date();
String date1= dateFormat.format(date);
By HighestPrice =By.xpath("//div[@class='bsr_table hist_tbl_hm']//tr//span[@class='gld13 disin']/a/ancestor::td/following-sibling::td[1]");
By LowestPrice =By.xpath("//div[@class='bsr_table hist_tbl_hm']//tr//span[@class='gld13 disin']/a/ancestor::td/following-sibling::td[2]");

By TopGainerLink = By.xpath("//a[@title='Top Gainers']");
By shareName=By.xpath("//div[@class='bsr_table hist_tbl_hm']//span[@class='gld13 disin']/a");

private void write(String text,int row,int col) 
{
		File src1=new File("./TestData/MarketGainers.xlsx");
	FileInputStream fs;
	FileOutputStream fo;
	try {
		fs = new FileInputStream(src1);
		
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet ws1=wb.getSheet("Sheet1");
		fo=new FileOutputStream(src1);
		 ws1.getRow(row).createCell(col).setCellValue(text);
		 wb.write(fo);
		 wb.close();
	} catch (IOException e)
	{
		System.out.println(e.getMessage());
	}
	
}
@Test(priority=2)
	public void atest() throws IOException, InterruptedException
	{
	System.out.println("test2 started");
	
	
	write(date1,0,0);
	write("sharename",1,0);
	write("Day high",1,1);
	write("Day Low",1,2);
	String sn,sp,spl;
	utility.WaitAndClick(driver, TopGainerLink);
	List<WebElement> sharenames= driver.findElements(shareName);
	List<WebElement> DayHigh= driver.findElements(HighestPrice);
	List<WebElement> DayLow= driver.findElements(LowestPrice);
	System.out.println("Topgainers "+sharenames.size());
	for(int i=0;i<sharenames.size();i++)
	{
		col=0;
		sn=sharenames.get(i).getText();
		sp=DayHigh.get(i).getText();
		spl=DayLow.get(i).getText();
		System.out.println(i+"st share name is "+sn+"Highest Price for the day is "+sp);
	write(sn,i+2,col);
	col=1;
	write(sp,i+2,col);
	col=2;
	write(spl,i+2,col);
	
	}
	
	}	

@Test(priority=1)
	public void LaunchBrouser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:/selinium/chromedriver/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//options.addArguments("-–disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.moneycontrol.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
