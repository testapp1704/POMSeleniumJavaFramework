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
import pages.RegisterPage;
import pages.HomePage;
import reports.ExtentManager;
public class TestCases extends BasePage
{
	
	ExtentReports reports = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
	ExtentTest test ;
	
	@Test(priority=1)
	public void registrationPageTest() throws InterruptedException 
	{
		test=reports.createTest("Login Test");
		init();
		openBrowser("Chrome");
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		test.log(Status.PASS, "Open chrome browser Successfully ");
		registerPage.enterRegistrationDetails("Suh","Tridi","suyashtestfr@gmail.com","suyashtestfr@gmail.com","Pa$$word","Pa$$word", "07404837568");
	}
	
	@Test(priority=2)
	public void homePageTest() throws InterruptedException 
	{
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		test.log(Status.PASS, "Open chrome browser Successfully ");
		homepage.searchProduct("GIGABYTE Solid State Drive 120GB");
	}
 
	@AfterClass
	public void quit()
	{
//		driver.close();
//		reports.flush(); //generate the reports
	}
}

	

