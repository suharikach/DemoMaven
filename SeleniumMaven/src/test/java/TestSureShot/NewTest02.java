 package TestSureShot;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest02 {
  @Test
  public void f() {
	  try
	  {
		  Assert.assertEquals("selenium","Selenium");
		  
	  }
	  catch(AssertionError e) 
	  {
		  System.out.println("Error");
	  }
	  
  Assert.assertEquals("selenium","Selenium");
  }
}
