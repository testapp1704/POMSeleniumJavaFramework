package content1.testcases;
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
import content1.base.BasePage;
import content1.pages.TripPage;
import content1.pages.HomePage;
import content1.pages.LoginPage;

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
		login.doLogin("suyash.trivedi@ttc.com", "Travel1234");
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
	
	@Test(priority=3,dependsOnMethods={"gotoTrip"})
	public void createTrip() throws IOException, InterruptedException, AWTException
	{
		TripPage createTrip = new TripPage(driver);
		test=reports.createTest("CreateTrip");
		createTrip.generateTripName("RegressionTest")  ;
		createTrip.clickOnCreateTrip();
		test.log(Status.INFO,"Clicked on CreateTrip Button");
		createTrip.enterTripName();
		createTrip.clickOnSavePublish();
		test.log(Status.INFO, "Entered the Trip name ");
		createTrip.goToTripSearchScreen();
		test.log(Status.INFO, "Click on search button ");
		createTrip.searchTrip();
		test.log(Status.PASS, "Trip Created & Searched Succesfully ");
	}
		


	@Test(priority=8,dependsOnMethods={"loginTest"})
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
