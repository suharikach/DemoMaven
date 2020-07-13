package day9;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
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
	  }
}
