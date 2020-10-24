package testcases;
import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;
import pages.HomePage;
import pages.LoginPage;
import reports.ExtentManager;
public class LogTest2 extends BasePage
{
	
	ExtentReports reports = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
	ExtentTest test ;
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException 
	{
		test=reports.createTest("Login Test");
		init();
		openBrowser("Chrome");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		test.log(Status.INFO, "Enter the credentials ");
		test.log(Status.FAIL, "Invalid Credentials ");
	    lp.doLogin("suyash.trivedi@ttc.com", "Travel1234");
	}
	//@Test(enabled=false) 
	@AfterClass
	public void quit()
	{
		driver.close();
		reports.flush(); //generate the reports
	}
}

	

