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

public class MoneyControlProject {
WebDriver driver;
XSSFWorkbook wb = null;
XSSFSheet ws;
int col=0;
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
Date date = new Date();
String date1= dateFormat.format(date);
//@Test
public String[] read()
{	
	String[] xs;
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File("./TestData/Data1.xlsx")));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		ws=wb.getSheet("Sheet1");
	System.out.println(ws.getLastRowNum());
	int row=ws.getLastRowNum();
	xs=new String[row+1];
	col=ws.getRow(0).getLastCellNum();
	System.out.println(col);
	for(int i=1;i<=row;i++)
{
		//System.out.println("entered the loop"+i);
	XSSFRow xr=ws.getRow(i);
	XSSFCell xc=xr.getCell(0); 
	xs[i]=xc.getStringCellValue();
	System.out.println(xs[i]);
		
} 
	return xs;
}
//@Test
private void write(String text,int row) 
{
		File src1=new File("./TestData/Data1.xlsx");
	FileInputStream fs;
	FileOutputStream fo;
	try {
		fs = new FileInputStream(src1);
		
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet ws1=wb.getSheet("Sheet1");
		fo=new FileOutputStream(src1);
		 ws1.getRow(row).createCell(col).setCellValue(text);
		 wb.write(fo);
		 
	} catch (IOException e)
	{
		System.out.println(e.getMessage());
	}
	
}
@Test(priority=2)
	public void atest() throws IOException, InterruptedException
	{
System.out.println("test2 started");
	String result[]=read();
	System.out.println(date1);
	write(date1,0);
	for(int i=1;i<result.length;i++)
	{
		System.out.println(result[i]);
		//driver.findElement(By.xpath("//form[@name='form_topsearch']//input[@id='search_str']")).;
		utility.WaitAndTypeValue(driver, result[i], "//form[@name='form_topsearch']//input[@id='search_str']");
		Thread.sleep(3000);
		utility.WaitAndClick(driver, "//ul[@class='suglist  scrollBar  jspScrollable'or @class='suglist  scrollBar'] //li[1]/a");
		String value=utility.WaitAndGetText(driver,"//div[@class='bsedata_bx'] //div[@class='pcnsb div_live_price_wrap']/span[1]");
		//driver.findElement(By.xpath("//ul[@class='suglist  scrollBar  jspScrollable'or @class='suglist  scrollBar'] //li[1]/a")).click();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//System.out.println(driver.findElement(By.xpath("//div[@class='bsedata_bx'] //div[@class='pcnsb div_live_price_wrap']/span[1]")).getText());
		//=driver.findElement(By.xpath("//div[@class='bsedata_bx'] //div[@class='pcnsb div_live_price_wrap']/span[1]")).getText();
	write(value,i);
	wb.close();
	
	}
	
	//System.out.println(result[i]);
	}	

@Test(priority=1)
	public void LaunchBrouser() throws InterruptedException
	{
	
	
	ChromeOptions opt= new ChromeOptions();
	opt.setAcceptInsecureCerts(false);
	opt.addArguments("--disable-notifications");
	
	//opt.merge(capabilities);
	System.setProperty("webdriver.chrome.driver", "D:/selinium/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(opt);
		driver.get("https://www.moneycontrol.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*utility.WaitAndClick(driver, "//a[@title='Log In']");
		driver.switchTo().frame("myframe");
		utility.WaitAndTypeValue(driver, "suharika.ch@gmail.com","//div[@class='signinblock'] //*[@id='email']");
		utility.WaitAndTypeValue(driver, "Manognya@1", "//div[@class='textfieldbox PR usepwd']/input[@name='pwd']");
		utility.WaitAndClick(driver, "//button[@id='ACCT_LOGIN_SUBMIT']");
		*/
	}
}
