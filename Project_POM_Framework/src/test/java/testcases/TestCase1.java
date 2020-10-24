package testcases;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;
import pages.HomePage;
import pages.LoginPage;
import reports.ExtentManager;

    public class TestCase1 extends BasePage{
	ExtentReports reports = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
	ExtentTest test ;
	Properties prop;
	 
	@Test(priority=1,dataProviderClass = dataprovider.TestDataProvider.class , dataProvider = "getData")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException 
	{
		test=reports.createTest("Login Test");
		init();
		openBrowser("Chrome");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		test.log(Status.PASS, "Open chrome browser Successfully ");
		login.doLogin("suyash.trivedi", "Travel1234");
		test.log(Status.PASS, "Login Successfully ");
	}

	@Test(priority=2,dependsOnMethods={"loginTest"})
	public void gotoTrip() throws IOException, InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		test=reports.createTest("Trip Page");
		homePage.gotoTrip();
		test.log(Status.INFO, "Open menu items ");
		homePage.selectRegion();
		test.log(Status.INFO, "Clicked on the Europe Region ");
		test.log(Status.PASS, "Go to Trip page Succesfully ");
	}
	
	@Test(priority=3,dependsOnMethods={"loginTest"})
	public void logoutTest() throws IOException, InterruptedException, AWTException
	{
		HomePage hp1 = new HomePage(driver);
		hp1.Logout();
	} 
	
	@AfterClass
	public void quit()
	{
 	driver.close();
	reports.flush(); //generate the reports
	}
}
