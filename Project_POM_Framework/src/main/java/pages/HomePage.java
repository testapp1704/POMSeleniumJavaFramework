package pages;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;
import reports.ExtentManager;

public class HomePage extends BasePage
{
   @FindBy(xpath=Constants.SEARCH_FIELD)
   WebElement SEARCH_FIELD;
   @FindBy(xpath=Constants.SEARCH_BTN)
   WebElement SEARCH_BTN;

   ExtentReports rep = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
   ExtentTest test ;
   String expectedTitle ;
   WebDriver driver;
	
	public HomePage(WebDriver driver) throws IOException 
	{
		super(driver);
	}

	public void searchProduct(String searchproduct) 
	{
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.elementToBeClickable(SEARCH_FIELD));
		    SEARCH_FIELD.sendKeys(searchproduct);
		    SEARCH_BTN.click();
									
	}

	@AfterMethod
	public void quit()
	{
		driver.close();
		rep.flush(); //generate the reports
	}
}
