package TestSureShot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import helper.utility;

public class GetTopGainers 
{
	WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet ws;
	FileInputStream fs;
	FileOutputStream fo;
	By HighestPrice =By.xpath("//div[@class='bsr_table hist_tbl_hm']//tr//span[@class='gld13 disin']/a/ancestor::td/following-sibling::td[1]");
	By TopGainerLink = By.xpath("//a[@title='Top Gainers']");
	By shareName=By.xpath("//div[@class='bsr_table hist_tbl_hm']//span[@class='gld13 disin']/a");
	@Test
	public void LaunchBrouser() throws InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver", "D:/selinium/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getTopgainers();
		
	}
	private void write(String sharename, String shareprice, int row) 
	{
		System.out.println(row+"st share name is "+sharename+"  Highest Price for the day is "+shareprice);
			File src1=new File("./TestData/DataTest.xlsx");
		
		try {
			fs = new FileInputStream(src1);
			
			 wb=new XSSFWorkbook(fs);
			XSSFSheet ws=wb.getSheet("Sheet1");
			fo=new FileOutputStream(src1);
			 ws.getRow(row).createCell(0).setCellValue(sharename);
			// ws1.getRow(row).createCell(1).setCellValue(shareprice);
			 wb.write(fo);
			 //wb.close();
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public void read()
	{	
		
			try {
				wb = new XSSFWorkbook(new FileInputStream(new File("./TestData/DataTest.xlsx")));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			ws=wb.getSheet("Sheet1");
		//System.out.println(ws.getLastRowNum());
		
		
		
		XSSFRow xr=ws.getRow(0);
		XSSFCell xc=xr.getCell(0); 
		
		System.out.println(xc.getStringCellValue());
			

	}
	public void getTopgainers()
	{
		String sn,sp;
		utility.WaitAndClick(driver, TopGainerLink);
		List<WebElement> sharenames= driver.findElements(shareName);
		List<WebElement> DayHigh= driver.findElements(HighestPrice);
		System.out.println(sharenames.size());
		read();
		for(int i=0;i<sharenames.size();i++)
		{
			sn=sharenames.get(i).getText();
			sp=DayHigh.get(i).getText();
			System.out.println(i+"st share name is "+sn+"Highest Price for the day is "+sp);
		write(sn, sp, i);
		}
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
