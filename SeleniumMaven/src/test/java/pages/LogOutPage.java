package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {
	WebDriver driver;
	By welcomLink=By.id("welcome");
	By LogoutButton= By.linkText("Logout");
	public LogOutPage(WebDriver ldriver)
	{
		driver=ldriver;
	}
	
	public void ClickWelcomeLink()
	{
		driver.findElement(welcomLink).click();
	}
	public void ClickLogOutButton()
	{
		driver.findElement(LogoutButton).click();
	}
	

}
