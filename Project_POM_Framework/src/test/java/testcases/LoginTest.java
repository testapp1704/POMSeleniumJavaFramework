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
public class LoginTest extends BasePage
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
	    lp.doLogin("suyash.trivedi", "Travel1234");
		test.log(Status.PASS, "Login Successfully ");
	}
	//@Test(enabled=false) 
	@Test(priority=2 )
	public void logoutfunction() throws IOException, InterruptedException, AWTException
	{
		HomePage hp1 = new HomePage(driver);
	    test=reports.createTest("Logout Test");
		hp1.Logout();
		test.log(Status.INFO, "Logout From  ContentOne Application ");
	}
	
	@AfterClass
	public void quit()
	{
		driver.close();
		reports.flush(); //generate the reports
	}
}

	

