package day9;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	@Test
	public void crm()
	{
	ExtentHtmlReporter html= new ExtentHtmlReporter("report.html");
	ExtentReports report=new ExtentReports();
	report.attachReporter(html);
	ExtentTest logger1=report.createTest("Login to application");
	logger1.log(Status.PASS, "Login  sucess");
	logger1.log(Status.INFO, "details");
	logger1.log(Status.SKIP, "skipped details");
	report.flush();
	}
}
